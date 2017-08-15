package io.osg.training.storefront.model.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Component
@Scope("prototype")
@Table(name="VENDORS", schema = "TRAINING_STOREFRONT")
public class VendorEntity {

    @Id
    @Column(name="VENDOR_KEY")
    @NotNull
    private Integer vendorKey;

    @Column(name="VENDOR_NAME")
    @NotNull
    private String vendorName;

    public Integer getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(Integer vendorKey) {
        this.vendorKey = vendorKey;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "VendorEntity{" +
                "vendorKey=" + vendorKey +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendorEntity)) return false;

        VendorEntity that = (VendorEntity) o;

        if (!getVendorKey().equals(that.getVendorKey())) return false;
        return getVendorName().equals(that.getVendorName());
    }

    @Override
    public int hashCode() {
        int result = getVendorKey().hashCode();
        result = 31 * result + getVendorName().hashCode();
        return result;
    }
}
