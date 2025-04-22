package tadzhibaeva.spring_security_db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "group_base", catalog = "postgres")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;

    //Связь с таблицой Course

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_group",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> courses;

    //Связь с таблицой Student

    @OneToMany/*(mappedBy = "group")*/
    private List<Student> students;
}
