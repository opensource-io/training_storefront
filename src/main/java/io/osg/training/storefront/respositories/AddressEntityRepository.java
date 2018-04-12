package io.osg.training.storefront.respositories;


import io.osg.training.storefront.model.entities.AddressEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses")
public interface AddressEntityRepository extends PagingAndSortingRepository<AddressEntity, Integer> {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends AddressEntity> S save(S entity);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Integer id);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends AddressEntity> Iterable<S> save(Iterable<S> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(AddressEntity entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Iterable<? extends AddressEntity> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll();

	Set<AddressEntity> findByAddressLine1ContainsIgnoreCase(@Param("addressLine1") String addressLine1);
    Set<AddressEntity> findByAddressLine2ContainsIgnoreCase(@Param("addressLine2") String addressLine2);
    Set<AddressEntity> findByCityContainsIgnoreCase(@Param("city") String countrySubdivision);
    Set<AddressEntity> findByCountrySubdivisionContainsIgnoreCase(@Param("countrySubdivision") String countrySubdivision);
    Set<AddressEntity> findByPostalCode(@Param("postalCode") String postalCode);
}
