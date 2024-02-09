package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.service.TeamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/team")
public class TeamController {

  @Autowired
  private TeamService service;

  @GetMapping({"","/"})
  public String index(Model model) {
    List<Team> team_list = service.findAll();
    model.addAttribute("team_list", team_list);

    return "team/index";
  }

  @GetMapping("/show/{id}")
  public String show(Model model, @PathVariable("id") Integer id) {
    Team team = service.load(id);
    model.addAttribute("team", team);

    return "team/show";
  }
  
}
