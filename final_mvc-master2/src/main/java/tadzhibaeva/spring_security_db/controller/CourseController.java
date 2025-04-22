package tadzhibaeva.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tadzhibaeva.spring_security_db.entity.Course;
import tadzhibaeva.spring_security_db.service.CourseService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("course/")
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public String homeCourse(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("course", courses);
        return "coursePackage/course_page";
    }

    @GetMapping("/new")
    public String showNewPage(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "coursePackage/new_course";
    }

    @PostMapping("course/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course/";
    }

    @GetMapping("course/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("course1", course);
        return "coursePackage/edit_course";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("course1") Course course){
        courseService.save(course);
        return "redirect:/course/";
    }

    @RequestMapping("course/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.delete(id);
        return "redirect:/course/";
    }

}
