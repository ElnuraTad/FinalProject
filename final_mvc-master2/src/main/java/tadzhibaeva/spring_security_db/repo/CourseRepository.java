package tadzhibaeva.spring_security_db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadzhibaeva.spring_security_db.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}