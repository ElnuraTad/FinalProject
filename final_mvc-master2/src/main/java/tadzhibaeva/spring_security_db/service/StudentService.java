package tadzhibaeva.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tadzhibaeva.spring_security_db.entity.Student;
import tadzhibaeva.spring_security_db.repo.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
