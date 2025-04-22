package tadzhibaeva.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tadzhibaeva.spring_security_db.entity.Teacher;
import tadzhibaeva.spring_security_db.service.TeacherService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public String homeTeacher(Model model) {
        List<Teacher> getAllTeacher = teacherService.getAllTeacher();
        model.addAttribute("teacher", getAllTeacher);
        return "teacher/teacher_page";
    }

    @GetMapping("/new")
    public String showNewTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher/new_teacher";
    }

    @PostMapping("teacher/save")
    public String saveTeacher(@ModelAttribute ("teacher") Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teacher/";
    }

    @GetMapping("teacher/edit/{id}")
    public String showEditTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        model.addAttribute("teacher1", teacher);
        return "teacher/edit_teacher";
    }

    @PostMapping("/edit")
    public String updateTeacher(@ModelAttribute("teacher1") Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teacher/";
    }

    @RequestMapping("teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return "redirect:/teacher/";
    }
}
