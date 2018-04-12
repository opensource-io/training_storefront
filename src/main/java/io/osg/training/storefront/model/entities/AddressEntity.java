package io.osg.training.storefront.model.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Component
@Scope("prototype")
@Table(name="ADDRESSES", schema = "TRAINING_STOREFRONT")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADDRESS_KEY")
    private Integer addressKey;

    @Column(name="ADDRESS_LINE_1")
    private String addressLine1;

    @Column(name="ADDRESS_LINE_2")
    private String addressLine2;

    @Column(name="CITY")
    @NotNull
    private String city;

    @Column(name="COUNTRY_SUBDIVISION")
    @NotNull
    private String countrySubdivision;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    public Integer getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(Integer addressKey) {
        this.addressKey = addressKey;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountrySubdivision() {
        return countrySubdivision;
    }

    public void setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity)) return false;

        AddressEntity address = (AddressEntity) o;

        if (!getAddressKey().equals(address.getAddressKey())) return false;
        if (!getAddressLine1().equals(address.getAddressLine1())) return false;
        if (getAddressLine2() != null ? !getAddressLine2().equals(address.getAddressLine2()) : address.getAddressLine2() != null)
            return false;
        if (!getCity().equals(address.getCity())) return false;
        if (!getCountrySubdivision().equals(address.getCountrySubdivision())) return false;
        return getPostalCode().equals(address.getPostalCode());
    }

    @Override
    public int hashCode() {
        int result = (getAddressKey() != null ? getAddressKey().hashCode() : 0);
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getCountrySubdivision().hashCode();
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
    		StringBuilder b = new StringBuilder();
    		b.append("Address{");
    		b.append("addressKey=");
    		b.append(getAddressKey());
		b.append("'");
    		if (getAddressLine1() != null) {
    			b.append(", addressLine1='");
    			b.append(getAddressLine1());
    			b.append("'");
    		}
    		if (getAddressLine2() != null) {
    			b.append(", addressLine2='");
    			b.append(getAddressLine2());
    			b.append("'");
    		}
    		b.append(", city='");
    		b.append(getCity());
		b.append("'");
    		b.append(", countrySubdivision='");
    		b.append(getCountrySubdivision());
		b.append("'");
    		if (getPostalCode() != null) {
    			b.append(", postalCode='");
    			b.append(getPostalCode());
    			b.append("'");
    		}
    		b.append("}");
    		return b.toString();
    }
}
