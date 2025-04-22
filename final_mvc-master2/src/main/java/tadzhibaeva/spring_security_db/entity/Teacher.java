package tadzhibaeva.spring_security_db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teacher_base",  catalog = "postgres")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_fName")
    private String firstName;

    @Column(name = "teacher_lName")
    private String lastName;

    @Column(name = "teacher_email")
    private String email;

    //Связь с таблицой Course
    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
}
