package tadzhibaeva.spring_security_db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tadzhibaeva.spring_security_db.entity.Company;
import tadzhibaeva.spring_security_db.service.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping()
    public String homeCompany(Model model) {
        List<Company> company = companyService.getAllCompany();
        model.addAttribute("company", company);
        return "company/company_page";
    }

    @GetMapping("/new")
    public String showNewPage(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/new_company";
    }

    @PostMapping("company/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model) {;
        Company company = companyService.getById(id);
        model.addAttribute("company", company);
        return "company/edit_company";
    }

    @PostMapping("/company-update")
    public String updateUser(Company company){
        companyService.save(company);
        return "redirect:/";
    }


    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.delete(id);
        return "redirect:/";
    }
}
