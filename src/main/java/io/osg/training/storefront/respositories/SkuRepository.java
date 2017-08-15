package io.osg.training.storefront.respositories;

import io.osg.training.storefront.model.entities.SkuEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "skus", path = "skus")
public interface SkuRepository extends PagingAndSortingRepository<SkuEntity, Integer> {
    Set<SkuEntity> findBySkuVendorVendorKey(@Param("vendorKey") Integer vendorKey);
    SkuEntity findByVendorSkuCodeIgnoreCase(@Param("vendorSkuCode") String vendorSkuCode);
    Set<SkuEntity> findBySkuNameContainsIgnoreCase(@Param("skuName") String skuNameSearchCriterion);
    Set<SkuEntity> findBySkuVendorVendorNameContainsIgnoreCase(@Param("vendorName") String vendorNameSearchCriterion);
    Set<SkuEntity> findBySkuDescriptionContainsIgnoreCase(@Param("skuDescription") String skuDescriptionSearchCriterion);
}