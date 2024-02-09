package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.repository.TeamRepository;

@Service
public class TeamService {
  @Autowired
  private TeamRepository repository;

  /**
   * 全チームのリストを取得して返す.
   * 
   * @return
   */
  public List<Team> findAll(){
    return repository.findAll();
  }

  /**
   * 該当のチーム情報を取得して返す.
   * 
   * @param id
   * @return Team チームオブジェクト
   */
  public Team load(int id){
    return repository.Load(id);
  }
}
