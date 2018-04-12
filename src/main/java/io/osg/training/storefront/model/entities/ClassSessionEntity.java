package io.osg.training.storefront.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@Table(name="CLASS_SESSIONS", schema = "TRAINING_STOREFRONT")
public class ClassSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLASS_SESSION_KEY")
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
    
    @Autowired
    @ManyToOne
    @JoinColumn(name="INSTRUCTOR_KEY")
    private InstructorEntity classSessionInstructor;

    @Column(name="CLASS_SESSION_STARTDATE")
    private LocalDate classSessionStartDate;
    
    @Column(name="CLASS_SESSION_STARTTIME")
    private LocalTime classSessionStartTime;

    @Column(name="CLASS_SESSION_ENDTIME")
    private LocalTime classSessionEndTime;

    @Column(name="CLASS_SESSION_TIMEZONE")
    private String classSessionTimeZone;
    
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
        this.classSessionSku = classSku;
    }

    public AddressEntity getClassSessionAddress() {
        return classSessionAddress;
    }

    public void setClassSessionAddress(AddressEntity classSessionAddress) {
    		this.classSessionAddress = classSessionAddress;
	}
    
    public InstructorEntity getClassSessionInstructor() {
        return classSessionInstructor;
    }

    public void setClassSessionInstructor(InstructorEntity classSessionInstructor) {
    		this.classSessionInstructor = classSessionInstructor;
	}
    
    public LocalDate getClassSessionStartDate() {
        return classSessionStartDate;
    }

    public void setClassSessionStartDate(LocalDate dateTime) {
        this.classSessionStartDate = dateTime;
    }
    
    public LocalTime getClassSessionStartTime() {
        return classSessionStartTime;
    }

    public void setClassSessionStartTime(LocalTime startTime) {
        this.classSessionStartTime = startTime;
    }
    
    public LocalTime getClassSessionEndTime() {
        return classSessionEndTime;
    }

    public void setClassSessionEndTime(LocalTime endTime) {
        this.classSessionEndTime = endTime;
    }

    public String getClassSessionTimeZone() {
        return classSessionTimeZone;
    }

    public void setClassSessionTimeZone(String classSessionTimeZone) {
        this.classSessionTimeZone = classSessionTimeZone;
    }
}
