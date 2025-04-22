package tadzhibaeva.spring_security_db.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tadzhibaeva.spring_security_db.entity.PromptRequest;
import tadzhibaeva.spring_security_db.service.AiService;


@Controller
public class AIController {

    @Autowired
    private AiService aiService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/aitemp/recommendation")
    public String getForm(Model model) {
        model.addAttribute("promptRequest", new PromptRequest());
        model.addAttribute("response", "");
        return "aitemp/recommendation-combined";
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/aitemp/recommendation")
    public String getRecommendation(@ModelAttribute PromptRequest promptRequest, Model model) {
        String response = aiService.askAI(promptRequest.getPrompt());
        model.addAttribute("promptRequest", promptRequest);
        model.addAttribute("response", response);
        return "aitemp/recommendation-combined";
    }
//    @Autowired
//    private AiService aiService;
//
//    @GetMapping("/aitemp/recommendation")
//    public String getForm(Model model) {
//        model.addAttribute("promptRequest", new PromptRequest());
//        return "aitemp/recommendation-form";
//    }
//
//    @PostMapping("/aitemp/recommendation")
//    public String getRecommendation(@ModelAttribute PromptRequest promptRequest, Model model) {
//        String response = aiService.askAI(promptRequest.getPrompt());
//        model.addAttribute("response", response);
//        return "aitemp/recommendation-result";
//    }
}
