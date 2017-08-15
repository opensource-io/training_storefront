package io.osg.training.storefront.respositories;

import io.osg.training.storefront.model.entities.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

/**
 *
 */
@RepositoryRestResource(collectionResourceRel = "vendors", path = "vendors")
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {

    /**
     *
     * @param vendorName
     * @return
     */
    Set<VendorEntity> getVendorByVendorNameContainsIgnoreCase(@Param("vendorName") final String vendorName);

    List<VendorEntity> findAllByOrderByVendorKeyAsc();

}