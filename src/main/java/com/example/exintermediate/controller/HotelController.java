package com.example.exintermediate.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.form.HotelForm;
import com.example.exintermediate.service.HotelService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/hotel")
public class HotelController {
  @Autowired
  private HotelService service;
  
  @GetMapping({"","/"})
  public String index(Model model, HotelForm form, HttpServletRequest req) {
    List<Hotel> hotel_list;

    if(req.getParameter("price") == null){
      hotel_list = new ArrayList<>();
    } else if(form.getPrice() == null){
      hotel_list = service.findAll();
    } else {
      hotel_list = service.search(form.getPrice());
    }
    
    model.addAttribute("hotel_list", hotel_list);
    return "hotel/index";
  }
    
}
