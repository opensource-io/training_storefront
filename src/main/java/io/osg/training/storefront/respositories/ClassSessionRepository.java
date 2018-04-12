package io.osg.training.storefront.respositories;


import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import io.osg.training.storefront.model.entities.ClassSessionEntity;

@RepositoryRestResource(collectionResourceRel = "class-sessions", path = "class-sessions")
public interface ClassSessionRepository extends PagingAndSortingRepository<ClassSessionEntity, Integer> {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends ClassSessionEntity> S save(S entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Integer id);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends ClassSessionEntity> Iterable<S> save(Iterable<S> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(ClassSessionEntity entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Iterable<? extends ClassSessionEntity> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll();

	Set<ClassSessionEntity> findByClassSessionSkuVendorSkuCode(String vendorSkuCodeSearchCriterion);
    Set<ClassSessionEntity> findByClassSessionSkuSkuNameContainsIgnoreCase(String vendorSkuNameSearchCriterion);
    Set<ClassSessionEntity> findByClassSessionSkuSkuVendorVendorNameContainsIgnoreCase(String vendorSkuNameSearchCriterion);
    Set<ClassSessionEntity> findByClassSessionInstructorInstructorNameContainsIgnoreCase(String classSessionInstrsutorNameSearchCriterion);
    Set<ClassSessionEntity> findByClassSessionStartDateBetween(LocalDate classSessionStartDateBeginSearchCriterion, LocalDate classSessionStartDateEndSearchCriterion);
}
