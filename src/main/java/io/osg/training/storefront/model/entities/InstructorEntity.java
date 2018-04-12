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
@Table(name="INSTRUCTORS", schema = "TRAINING_STOREFRONT")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INSTRUCTOR_KEY")
    @NotNull
    private Integer instructorKey;

    @Column(name="INSTRUCTOR_NAME")
    @NotNull
    private String instructorName;

    @Column(name="INSTRUCTOR_EMAIL")
    @NotNull
    private String instructorEmail;

    public Integer getInstructorKey() {
        return instructorKey;
    }

    public void setInstructorKey(Integer instructorKey) {
        this.instructorKey = instructorKey;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstructorEntity)) return false;

        InstructorEntity that = (InstructorEntity) o;

        if (!getInstructorKey().equals(that.getInstructorKey())) return false;
        if (!getInstructorName().equals(that.getInstructorName())) return false;
        return getInstructorEmail().equals(that.getInstructorEmail());
    }

    @Override
    public int hashCode() {
        int result = (getInstructorKey() != null ? getInstructorKey().hashCode() : 0);
        result = 31 * result + getInstructorName().hashCode();
        result = 31 * result + getInstructorEmail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorKey=" + instructorKey +
                ", instructorName='" + instructorName + '\'' +
                ", instructorEmail='" + instructorEmail + '\'' +
                '}';
    }
}
