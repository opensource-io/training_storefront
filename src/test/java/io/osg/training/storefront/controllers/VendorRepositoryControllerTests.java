package io.osg.training.storefront.controllers;

import io.osg.training.storefront.model.entities.VendorEntityTestRig;
import io.osg.training.storefront.respositories.VendorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("development")
@Sql(scripts = {"classpath:scripts/sql/drop-h2.sql", "classpath:scripts/sql/schema-h2.sql"}/*, config = @SqlConfig(separator = "@@", commentPrefix = "`")*/)
@AutoConfigureMockMvc
public class VendorRepositoryControllerTests {

    private static final Logger logger = LoggerFactory.getLogger(VendorRepositoryControllerTests.class);

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private VendorEntityTestRig vendorEntityTestRig;

    @Autowired
    private VendorRepository vendorRepository;

    String path;

    @Test
    public void assertTrueTest(){
        assert true;
    }

    /*@Before
    public void setup(){
        vendorEntityTestRig.intializeDbWithVendors();

        try {
            logger.info("*****");
            mockMvc.perform(get("/")).andDo(print());

            logger.info("*****");
            mockMvc.perform(get("/profile")).andDo(print());

            logger.info("*****");
            mockMvc.perform(get("/profile/vendors")).andDo(print());

            logger.info("*****");
            mockMvc.perform(get("/vendors")).andDo(print());

            for (VendorEntity vendorEntity : vendorEntityTestRig.getVendorEntitiesMap().values()){
                logger.info("*****");
                mockMvc.perform(get("/vendors" + "/" + vendorEntity.getVendorKey())).andDo(print());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        path = "/" + VendorRepository.class.getAnnotation(RepositoryRestResource.class).path();
    }*/



    /*@Test
    public void findVendorByIdTest(){

        for(String vendorEntityJsonNode : vendorEntityTestRig.getTestJsonNodes()) {
            logger.info("Checking for json node: " + vendorEntityJsonNode);
        }

        //String path = VendorRepository.class.getAnnotation(RepositoryRestResource.class).path();
        logger.info("Testing path: " + path);

        for(VendorEntity vendorEntity : vendorEntityTestRig.getVendorEntitiesMap().values()){

            Iterator vendorEntityJsonNodesIterator = vendorEntityTestRig.getTestJsonNodes().iterator();

            logger.info("*****");
            logger.info("GET vendor: " + vendorEntity.toString());
            try {

                mockMvc.perform(get("/" + path + "/" + vendorEntity.getVendorKey()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$." + vendorEntityJsonNodesIterator.next(), vendorEntity.getVendorName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/

    /*@Test
    public void findAllVendorsTest(){
        try {
            mockMvc.perform(get(path + "/" + "/all")).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
