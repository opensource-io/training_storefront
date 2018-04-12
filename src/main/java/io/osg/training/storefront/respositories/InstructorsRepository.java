package io.osg.training.storefront.respositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import io.osg.training.storefront.model.entities.InstructorEntity;

@RepositoryRestResource(collectionResourceRel = "instructors", path = "instructors")
public interface InstructorsRepository extends PagingAndSortingRepository<InstructorEntity, Integer> {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
	<S extends InstructorEntity> S save(S entity);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Integer id);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends InstructorEntity> Iterable<S> save(Iterable<S> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(InstructorEntity entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void delete(Iterable<? extends InstructorEntity> entities);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll();

}
