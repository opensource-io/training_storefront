package io.osg.training.storefront.model.entities;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Component
@Scope("prototype")
@Table(name="CLASS_SESSIONS", schema = "TRAINING_STOREFRONT")
public class ClassSessionEntity {

    @Id
    @Column(name="CLASS_SESSION_KEY")
    @NotNull
    private Integer classSessionKey;

    @Autowired
    @ManyToOne
    @JoinColumn(name="SKU_KEY")
    @NotNull
    private SkuEntity classSessionSku;

    @Autowired
    @ManyToOne
    @JoinColumn(name="ADDRESS_KEY")
    @NotNull
    private AddressEntity classSessionAddress;

    public Integer getClassSessionKey() {
        return  classSessionKey;
    }

    public void setClassSessionKey(Integer classSessionKey) {
        this.classSessionKey = classSessionKey;
    }

    public SkuEntity getClassSessionSku() {
        return classSessionSku;
    }

    public void setClassSessionSku(SkuEntity classSku) {
        this.classSessionSku = classSessionSku;
    }

    public AddressEntity getClassSessionAddress() {
        return classSessionAddress;
    }

    public void setClassSessionAddress(AddressEntity classSessionAddress) { this.classSessionAddress = classSessionAddress; }

    /*@Autowired
    @ManyToOne
    @JoinColumn(name="INSTRUCTOR_KEY")
    @NotNull
    private InstructorEntity classSessionInstructor;

    Columns(columns={@Column(name="CLASS_SESSION_STARTTIME"), @Column(name="CLASS_SESSION_START_TIMEZONE")})
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTimeTZ")
    @NotNull
    private DateTime classSessionStartDate;

    @Columns(columns={@Column(name="CLASS_SESSION_ENDTIME"), @Column(name="CLASS_SESSION_END_TIMEZONE")})
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTimeTZ")
    @NotNull
    private DateTime classSessionEndDate;

    @Column(name="CLASS_SESSION_TIMEZONE")
    @NotNull
    private String classSessionTimeZone;*/
}
