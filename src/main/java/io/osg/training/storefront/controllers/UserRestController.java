package io.osg.training.storefront.controllers;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public Principal getPrincipal(Principal principal) {
		return principal;
	}


}