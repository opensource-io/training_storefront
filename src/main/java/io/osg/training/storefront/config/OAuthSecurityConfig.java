package io.osg.training.storefront.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configurable
@EnableWebSecurity
@EnableOAuth2Sso
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	private static final String GOOGLE_EMAIL = "email";
	private static final String GOOGLE_PICTURE = "picture";
	private static final String GOOGLE_GIVEN_NAME = "given_name";
	private static final String GOOGLE_FAMILY_NAME = "family_name";
	private static final String GOOGLE_NAME = "name";
	private static final String GOOGLE_HD = "hd"; // domain name
//	private static final String GOOGLE_SUB = "sub"; // Google Subscriber ID?  Seems all numeric
//	private static final String GOOGLE_PROFILE = "profile"; // Google+ Profile URL
//	private static final String GOOGLE_EMAIL_VERIFIED = "email_verified"; // "true"
//	private static final String GOOGLE_LOCALE = "locale"; // "en"
	
	@Autowired
	OAuth2ClientContext oAuth2ClientContext;
	
	@Autowired
	AuthorizationCodeResourceDetails authorizationCodeResourceDetails;
	
	@Autowired
	ResourceServerProperties resourceServerProperties;
	
	@Value("${security.oauth2.returnUrl}")
	private String returnUrl; // "http://localhost:4201/"

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	private OAuth2ClientAuthenticationProcessingFilter oAuthProcessingfilter() {
		final String returnUrl = this.returnUrl;
		final OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(authorizationCodeResourceDetails, oAuth2ClientContext);
		final OAuth2ClientAuthenticationProcessingFilter oAuth2Filter = new OAuth2ClientAuthenticationProcessingFilter("/login");
		oAuth2Filter.setRestTemplate(oAuth2RestTemplate);
		oAuth2Filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler() {
		    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		        this.setDefaultTargetUrl(returnUrl);
		        super.onAuthenticationSuccess(request, response, authentication);
		    }
		});
		final UserInfoTokenServices userInfoTokenServices = new UserInfoTokenServices(resourceServerProperties.getUserInfoUri(), resourceServerProperties.getClientId());
		userInfoTokenServices.setPrincipalExtractor(new GooglePrincipalExtractor());
		userInfoTokenServices.setAuthoritiesExtractor(new GoogleAuthoritiesExtractor());
		oAuth2Filter.setTokenServices(userInfoTokenServices);
		return oAuth2Filter;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			// Configure cross-origin headers
			.cors()
				.and()
				
			// Logout 
			.logout()
				.logoutSuccessUrl(this.returnUrl) // TODO make an external config
				.permitAll()
				.and()

			// Login URL filter
			.addFilterAt(oAuthProcessingfilter(), BasicAuthenticationFilter.class)

			.authorizeRequests()
				.anyRequest()
					.permitAll()
				.and()

			// Protect from Cross Site Request Forgeries 
			.csrf()
				.disable() // TODO need to find a way to pass necessary info to front-end app
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			;
	}
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	public class GoogleUser {
		
		private Map<String, Object> map;
		
		private GoogleUser(final Map<String, Object> map) {
			this.map = map;
		}
		
		public String getEmail() {
			final Object email = map.get(GOOGLE_EMAIL);
			return email != null ? email.toString() : null;
		}
		
		public String getPictureUrl() {
			final Object pic = map.get(GOOGLE_PICTURE);
			return pic != null ? pic.toString() : null;
		}
		
		public String getGivenName() {
			final Object givenName = map.get(GOOGLE_GIVEN_NAME);
			return givenName != null ? givenName.toString() : null;
		}
		
		public String getFamilyName() {
			final Object familyName = map.get(GOOGLE_FAMILY_NAME);
			return familyName != null ? familyName.toString() : null;
		}
		
		public String getName() {
			final Object name = map.get(GOOGLE_NAME);
			return name != null ? name.toString() : null;
		}
		
		public String toString() {
			return getEmail();
		}
	}
	
	private class GoogleAuthoritiesExtractor implements AuthoritiesExtractor {
		List<String> allowedDomains = new ArrayList<String>(Arrays.asList("opensource.io", "opensourcearchitect.co")); // TODO needs to be configurable

		@Override
		public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
            final List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            if (map != null && map.containsKey(GOOGLE_HD)) {
                final String domain = map.get(GOOGLE_HD).toString();
                if (allowedDomains.contains(domain)) {
                		list.add(new SimpleGrantedAuthority(ROLE_ADMIN));
                } else {
//                		list.add(new SimpleGrantedAuthority(ROLE_USER));
                    throw new BadCredentialsException("Not an allowed domain");
                }
            }
            return list;
		}
		
	}
	
	private class GooglePrincipalExtractor implements PrincipalExtractor {

		@Override
		public Object extractPrincipal(Map<String, Object> map) {
			if (map != null && map.containsKey(GOOGLE_EMAIL)) {
				return new GoogleUser(map);
			}
			return null;
		}
		
	}


}

/* Example of map returned from Google OAuth2

{
	sub=103125892792318523072, 
	name=Rob Jenks, 
	given_name=Rob, 
	family_name=Jenks, 
	profile=https://plus.google.com/103125892792318523072, 
	picture=https://lh4.googleusercontent.com/-QSSbd8ui0Wk/AAAAAAAAAAI/AAAAAAAAAHI/1Gm87HguSd0/photo.jpg, 
	email=rob@opensourcearchitect.co, 
	email_verified=true, 
	locale=en, 
	hd=opensourcearchitect.co
}

*/