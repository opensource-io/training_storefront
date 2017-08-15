package io.osg.training.storefront.repositories;

import io.osg.training.storefront.model.entities.VendorEntityTestRig;
import io.osg.training.storefront.model.entities.VendorEntity;
import io.osg.training.storefront.respositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("development")
@Sql(scripts = {"classpath:scripts/sql/drop-h2.sql", "classpath:scripts/sql/schema-h2.sql"})
public class VendorRepositoryTests {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private VendorEntityTestRig vendorEntityTestRig;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private VendorRepository vendorRepository;

    @Before
    public void setup() {
        vendorEntityTestRig.initializeDbWithVendors(dataSource, vendorEntityTestRig.getTestTable(), vendorEntityTestRig.getTestColumns(), vendorEntityTestRig.getVendorEntitiesMap());
    }

    @Test
    public void findVendorByIdTest(){
        for(VendorEntity venderEntityToFind : vendorEntityTestRig.getVendorEntitiesMap().values()){
            VendorEntity testVendor = vendorRepository.findOne(venderEntityToFind.getVendorKey());
            assert testVendor.equals(venderEntityToFind);
        }
    }

    @Test
    public void findVendorByNameTest(){
        for(VendorEntity controlVendorEntity : vendorEntityTestRig.getVendorEntitiesMap().values()){

            List<String> testSearchCriteria = vendorEntityTestRig.getStringSearchCriteria(controlVendorEntity.getVendorName());

            for(String testSearchCriterion : testSearchCriteria){

                Set<VendorEntity> searchResultsToTest = vendorRepository.getVendorByVendorNameContainsIgnoreCase(testSearchCriterion);

                for(VendorEntity searchResultToTest : searchResultsToTest){
                    assert Pattern.compile(Pattern.quote(testSearchCriterion), Pattern.CASE_INSENSITIVE).matcher(searchResultToTest.getVendorName()).find();
                    assert vendorEntityTestRig.getVendorEntitiesMap().containsValue(searchResultToTest);
                }
            }
        }
    }

    @Test
    public void findAllTest(){
        for (VendorEntity vendorEntityToTest : vendorRepository.findAllByOrderByVendorKeyAsc()){
            assert vendorEntityToTest.equals(vendorEntityTestRig.getVendorEntitiesMap().get(vendorEntityToTest.getVendorKey()));
        }
    }

    @Test
    public void saveTest(){
        vendorRepository.save(vendorEntityTestRig.getNewVendor());
        VendorEntity testVendor = jdbcTemplate.queryForObject(vendorEntityTestRig.getNewVendorQuery(), vendorEntityTestRig.getVendorEntityRowMapper(), vendorEntityTestRig.getNewVendor().getVendorKey());
        assert testVendor.equals(vendorEntityTestRig.getNewVendor());
    }
}
