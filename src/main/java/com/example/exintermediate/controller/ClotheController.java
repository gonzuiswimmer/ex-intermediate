package com.example.exintermediate.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Clothe;
import com.example.exintermediate.form.ClotheForm;
import com.example.exintermediate.service.ClotheService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/clothe")
public class ClotheController {
  @Autowired
  private ClotheService service;

  @GetMapping({"","/"})
  public String index(Model model, ClotheForm form, HttpServletRequest req) {
    List<Clothe> clothes;
    
    if(req.getParameter("color") == null && req.getParameter("gender") == null){
      System.out.println("パラメータがない場合");
      clothes = new ArrayList<>();
    }

    if(req.getParameter("color") != null && req.getParameter("gender") != null){
      System.out.println("パラメータが両方ある場合");
      clothes = service.search(form.getGender(),form.getColor());
    }else if(req.getParameter("color") != null){
      System.out.println("パラメータが色だけある場合");
      clothes = service.search(null, form.getColor());
    }else if(req.getParameter("gender") != null){
      System.out.println("パラメータが性別だけある場合");
      clothes = service.search(form.getGender(),null);
    } else {
      System.out.println("予期しないケースです");
      clothes = new ArrayList<>();
    }
  
    model.addAttribute("clothes", clothes);
    return "clothe/index";
  }
    
}
