package tadzhibaeva.spring_security_db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadzhibaeva.spring_security_db.enam.StudyFormat;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student_base", catalog = "postgres")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_fName")
    private String firstName;

    @Column(name = "student_lName")
    private String lastName;

    @Column(name = "student_email")
    private String email;

    @Column(name = "study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    //Связь с таблицой Group

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
}
