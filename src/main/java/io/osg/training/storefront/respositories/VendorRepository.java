package io.osg.training.storefront.respositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import io.osg.training.storefront.model.entities.VendorEntity;

/**
 *
 */
@RepositoryRestResource(collectionResourceRel = "vendors", path = "vendors")
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends VendorEntity> S save(S entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Integer id);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(VendorEntity entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Iterable<? extends VendorEntity> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteInBatch(Iterable<VendorEntity> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAllInBatch();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends VendorEntity> List<S> save(Iterable<S> entities);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends VendorEntity> S saveAndFlush(S entity);

	Set<VendorEntity> findByVendorNameContainsIgnoreCase(@Param("vendorName") final String vendorName);

	List<VendorEntity> findAllByOrderByVendorKeyAsc();

}
