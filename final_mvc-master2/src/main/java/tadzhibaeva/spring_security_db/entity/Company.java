package tadzhibaeva.spring_security_db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_base", catalog = "postgres")  //, schema = "security_mvc"
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "located_country")
    private String locatedCountry;

/*    //Связь с таблицой Course
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> course;*/
}