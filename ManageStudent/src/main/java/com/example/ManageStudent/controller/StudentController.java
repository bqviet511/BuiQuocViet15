package com.example.ManageStudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ManageStudent.entity.Student;
import com.example.ManageStudent.service.StudentService;


@Controller
public class StudentController {
	@Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
    
    @GetMapping("/student/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/student";
        }

        model.addAttribute("students", studentService.search(term));
        return "list";
    }
    
    @GetMapping("/student/add")
    public String add(Model model) {
    	Student student = new Student();
        model.addAttribute("student", student);
        return "form";
    }
    
    @PostMapping("/student/save")
    public String save(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        studentService.save(student);
        redirect.addFlashAttribute("successMessage", "Saved student successfully!");
        return "redirect:/student";
    }
    
    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", studentService.findOne(id));
        return "form";
    }
    
    @GetMapping("/student/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	studentService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted student successfully!");
        return "redirect:/student";
    }
}
