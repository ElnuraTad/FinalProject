package tadzhibaeva.spring_security_db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_base", catalog = "postgres")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_duration")
    private int duration;

    //Связь с таблицой Company
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    //Связь с таблицой Group
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany/*(mappedBy = "courses", fetch = FetchType.LAZY)*/
    private List<Group> groups;

    //Связь с таблицой Teacher
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne/*(mappedBy = "course")*/
    private Teacher teacher;

    @Override
    public String toString() {
        return courseName;
    }
}