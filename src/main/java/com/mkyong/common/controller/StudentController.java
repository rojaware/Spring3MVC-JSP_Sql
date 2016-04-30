package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.common.model.Student;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/student")
public class StudentController {

   @RequestMapping(value = "/{name}", method = RequestMethod.GET)
   public ModelAndView getStudent(@PathVariable String name, ModelMap model) {
      return new ModelAndView("student", "command", new Student(name));
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, 
   ModelMap model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      return "result";
   }
}