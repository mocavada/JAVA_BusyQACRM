package com.busyqa.crm.model.academics;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private Integer id;
    private String name;
    private String description;
    private String location;
    private String trainer;

    @OneToMany(cascade = PERSIST)
    private List<Class> classes = new ArrayList<>();

    // DATES
    @Basic
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar startDate;
    @Basic
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar endDate;

    //
    public Course() {
    }

    public Course(String name, String description, String location, String trainer, List<Class> classes, Calendar startDate, Calendar endDate) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.trainer = trainer;
        this.classes = classes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }




    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", trainer='" + trainer + '\'' +
                ", classes=" + classes +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    // CUSTOM METHODS
    public void addClass(Class newClass) {
        this.classes.add(newClass);

    }

    public void removeClass(Class classEntry) {
        this.classes.remove(classEntry);
    }

}


//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName = "id")
//    private Client lead;
