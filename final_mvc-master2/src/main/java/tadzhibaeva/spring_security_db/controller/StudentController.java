package tadzhibaeva.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tadzhibaeva.spring_security_db.entity.Student;
import tadzhibaeva.spring_security_db.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public String homeStudent(Model model) {
        List<Student> getAllStudent = studentService.getAllStudent();
        model.addAttribute("student", getAllStudent);
        return "student/student_page";
    }

    @GetMapping("/new")
    public String showNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/new_student";
    }

    @PostMapping("student/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/";
    }

    @GetMapping("student/edit/{id}")
    public String showEditStudent(@PathVariable ("id") Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student1", student);
        return "student/edit_student";
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute("student1") Student student){
        studentService.save(student);
        return "redirect:/student/";
    }

    @RequestMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/student/";
    }
}
