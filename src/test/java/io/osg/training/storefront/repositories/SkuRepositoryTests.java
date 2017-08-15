package io.osg.training.storefront.repositories;

import io.osg.training.storefront.model.entities.SkuEntity;
import io.osg.training.storefront.model.entities.SkuEntityTestRig;
import io.osg.training.storefront.respositories.SkuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SkuRepositoryTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private SkuEntityTestRig skuEntityTestRig;

    @Autowired
    private SkuRepository skuRepository;

    @Before
    public void setup() {

        logger.info("Testing table: " + skuEntityTestRig.getTestTable());

        for(String testColumn : skuEntityTestRig.getTestColumns()){
            logger.info("Testing columns: " + testColumn);
        }

        for(SkuEntity skuEntityToInitialize : skuEntityTestRig.getSkuEntitiesMap().values()){
            logger.info("Using initialized skuEntity: " + skuEntityToInitialize.toString());
        }

        skuEntityTestRig.initializeDbWithSkus(dataSource, skuEntityTestRig.getTestTable(), skuEntityTestRig.getTestColumns(), skuEntityTestRig.getSkuEntitiesMap());
    }

    @Test
    public void findSkuByIdTest(){
        for(SkuEntity skuEntityToFind : skuEntityTestRig.getSkuEntitiesMap().values()){
            logger.info("Testing SKU: " + skuEntityToFind.toString());
            SkuEntity testSku = skuRepository.findOne(skuEntityToFind.getSkuKey());
            logger.info("Got SKU: " + testSku.toString());
            assert testSku.equals(skuEntityToFind);
        }
    }

    @Test
    public void saveTest(){
        logger.info("Testing saving a new SKU with query: " + skuEntityTestRig.getNewSkuQuery());
        logger.info("Testing the saving of SKU: " + skuEntityTestRig.getNewSku().toString());
        logger.info("Inserting new Vendor: " + skuEntityTestRig.getNewSku().toString() + " with SQL statement: " + skuEntityTestRig.getNewSkuQuery());
        skuRepository.save(skuEntityTestRig.getNewSku());
        SkuEntity testSku = (SkuEntity) jdbcTemplate.queryForObject(skuEntityTestRig.getNewSkuQuery(), skuEntityTestRig.getSkuEntityRowMapper(), skuEntityTestRig.getNewSku().getSkuKey());
        logger.info("Got Vendor: " + testSku.toString());
        assert testSku.equals(skuEntityTestRig.getNewSku());
    }

    @Test
    public void findAllTest(){
        for (SkuEntity skuEntityToTest : skuRepository.findAll()){
            logger.info("Checking Vendor: " + skuEntityToTest.toString());
            assert skuEntityToTest.equals(skuEntityTestRig.getSkuEntitiesMap().get(skuEntityToTest.getSkuKey()));
        }
    }

    @Test
    public void findSkusByVendorKey(){
        for(SkuEntity skuEntityToFind : skuEntityTestRig.getSkuEntitiesMap().values()){
            logger.info("Testing SKU: " + skuEntityToFind.toString());
            for (SkuEntity skuEntityToTest : skuRepository.findBySkuVendorVendorKey(skuEntityToFind.getSkuVendor().getVendorKey())){
                logger.info("Checking Vendor: " + skuEntityToTest.toString());
                assert skuEntityToTest.equals(skuEntityTestRig.getSkuEntitiesMap().get(skuEntityToTest.getSkuKey()));
            }
        }
    }

    @Test
    public void findSkuByVendorSkuCodeTest(){
        for(SkuEntity skuEntityToFind : skuEntityTestRig.getSkuEntitiesMap().values()){
            logger.info("Testing SKU: " + skuEntityToFind.toString());
            SkuEntity testSku = skuRepository.findByVendorSkuCodeIgnoreCase(skuEntityToFind.getVendorSkuCode());
            logger.info("Got SKU: " + testSku.toString());
            assert testSku.equals(skuEntityToFind);
        }
    }

    @Test
    public void findSkuBySkuNameTest(){
        for(SkuEntity controlSkuEntity : skuEntityTestRig.getSkuEntitiesMap().values()){

            List<String> testSearchCriteria = skuEntityTestRig.getStringSearchCriteria(controlSkuEntity.getSkuName());

            for(String testSearchCriterion : testSearchCriteria){

                Set<SkuEntity> searchResultsToTest = skuRepository.findBySkuNameContainsIgnoreCase(testSearchCriterion);

                for(SkuEntity searchResultToTest : searchResultsToTest){
                    assert Pattern.compile(Pattern.quote(testSearchCriterion), Pattern.CASE_INSENSITIVE).matcher(searchResultToTest.getSkuName()).find();
                    assert skuEntityTestRig.getSkuEntitiesMap().containsValue(searchResultToTest);
                }
            }
        }
    }

    @Test
    public void findSkuByVendorNameTest(){
        for(SkuEntity controlSkuEntity : skuEntityTestRig.getSkuEntitiesMap().values()){

            List<String> testSearchCriteria = skuEntityTestRig.getStringSearchCriteria(controlSkuEntity.getSkuVendor().getVendorName());

            for(String testSearchCriterion : testSearchCriteria){

                Set<SkuEntity> searchResultsToTest = skuRepository.findBySkuVendorVendorNameContainsIgnoreCase(testSearchCriterion);

                for(SkuEntity searchResultToTest : searchResultsToTest){
                    assert Pattern.compile(Pattern.quote(testSearchCriterion), Pattern.CASE_INSENSITIVE).matcher(searchResultToTest.getSkuVendor().getVendorName()).find();
                    assert skuEntityTestRig.getSkuEntitiesMap().containsValue(searchResultToTest);
                }
            }
        }
    }

    @Test
    public void findSkuBySkuDescriptionTest(){
        for(SkuEntity controlSkuEntity : skuEntityTestRig.getSkuEntitiesMap().values()){

            List<String> testSearchCriteria = skuEntityTestRig.getStringSearchCriteria(controlSkuEntity.getSkuDescription());

            for(String testSearchCriterion : testSearchCriteria){

                Set<SkuEntity> searchResultsToTest = skuRepository.findBySkuDescriptionContainsIgnoreCase(testSearchCriterion);

                for(SkuEntity searchResultToTest : searchResultsToTest){
                    assert Pattern.compile(Pattern.quote(testSearchCriterion), Pattern.CASE_INSENSITIVE).matcher(searchResultToTest.getSkuDescription()).find();
                    assert skuEntityTestRig.getSkuEntitiesMap().containsValue(searchResultToTest);
                }
            }
        }
    }
}
