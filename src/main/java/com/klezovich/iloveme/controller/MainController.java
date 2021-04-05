package com.klezovich.iloveme.controller;

import com.klezovich.iloveme.controller.dto.AddQualityDto;
import com.klezovich.iloveme.entity.Quality;
import com.klezovich.iloveme.repository.QualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Objects;

@RequestMapping("/")
@Controller
public class MainController {

    private final QualityRepository repository;

    @Autowired
    public MainController(QualityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public String show(Model m, Principal principal) {
        m.addAttribute("qualities", repository.findAll());
        m.addAttribute("new_quality", new AddQualityDto());

        if(Objects.isNull(principal)) {
            m.addAttribute("username", "NoNameFakePrincipal");
        }else {
            m.addAttribute("username", principal.getName());
        }
        return "quality_list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("new_quality") AddQualityDto dto, Principal principal) {
        repository.save(Quality.builder()
                .text(dto.getText())
                .user(principal.getName())
                .build()
        );
        return "redirect:/";
    }
}
