package tadzhibaeva.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tadzhibaeva.spring_security_db.entity.Group;
import tadzhibaeva.spring_security_db.service.GroupService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping()
    public String homeGroup(Model model) {
        List<Group> getAllGroup = groupService.getAllGroup();
        model.addAttribute("group", getAllGroup);
        return "group/group_page";
    }

    @GetMapping("/new")
    public String showNewGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "group/new_group";
    }

    @PostMapping("group/save")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.save(group);
        return "redirect:/group/";
    }

    @GetMapping("group/edit/{id}")
    public String showEditGroup(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getById(id);
        model.addAttribute("group1", group);
        return "group/edit_group";
    }

    @PostMapping("/edit")
    public String updateGroup(@ModelAttribute("group1") Group group){
        groupService.save(group);
        return "redirect:/group/";
    }

    @RequestMapping("group/delete/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
        groupService.delete(id);
        return "redirect:/group/";
    }
}
