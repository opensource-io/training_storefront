package io.osg.training.storefront.respositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import io.osg.training.storefront.model.entities.SkuEntity;

@RepositoryRestResource(collectionResourceRel = "skus", path = "skus")
public interface SkuRepository extends PagingAndSortingRepository<SkuEntity, Integer> {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends SkuEntity> S save(S entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Integer id);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends SkuEntity> List<S> save(Iterable<S> entities);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(SkuEntity entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Iterable<? extends SkuEntity> entities);

	@Override
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	Set<SkuEntity> findBySkuVendorVendorKey(@Param("vendorKey") Integer vendorKey);
    SkuEntity findByVendorSkuCodeIgnoreCase(@Param("vendorSkuCode") String vendorSkuCode);
    Set<SkuEntity> findBySkuNameContainsIgnoreCase(@Param("skuName") String skuNameSearchCriterion);
    Set<SkuEntity> findBySkuVendorVendorNameContainsIgnoreCase(@Param("vendorName") String vendorNameSearchCriterion);
    Set<SkuEntity> findBySkuDescriptionContainsIgnoreCase(@Param("skuDescription") String skuDescriptionSearchCriterion);
}