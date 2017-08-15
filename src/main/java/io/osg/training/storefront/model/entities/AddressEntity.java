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
@Table(name="ADDRESSES", schema = "TRAINING_STOREFRONT")
public class AddressEntity {

    @Id
    @Column(name="ADDRESS_KEY")
    @NotNull
    private Integer addressKey;

    @Column(name="ADDRESS_LINE_1")
    @NotNull
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
    @NotNull
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
        int result = getAddressKey().hashCode();
        result = 31 * result + getAddressLine1().hashCode();
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getCountrySubdivision().hashCode();
        result = 31 * result + getPostalCode().hashCode();
        return result;
    }

    @Override
    public String toString() {
        if(addressLine2 != null) {
            return "Address{" +
                    "addressKey=" + addressKey +
                    ", addressLine1='" + addressLine1 + '\'' +
                    ", addressLine2='" + addressLine2 + '\'' +
                    ", city='" + city + '\'' +
                    ", countrySubdivision='" + countrySubdivision + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }else{
            return "Address{" +
                    "addressKey=" + addressKey +
                    ", addressLine1='" + addressLine1 + '\'' +
                    ", city='" + city + '\'' +
                    ", countrySubdivision='" + countrySubdivision + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }

    }
}
