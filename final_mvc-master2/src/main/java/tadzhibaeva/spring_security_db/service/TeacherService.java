package tadzhibaeva.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tadzhibaeva.spring_security_db.entity.Teacher;
import tadzhibaeva.spring_security_db.repo.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher getById(Long id) {
        return teacherRepository.findById(id).get();
    }

    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
