package com.example.exintermediate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.repository.TeamRepository;

public class TeamServiceTest {
  @Mock // モックオブジェクトを使用することを宣言
  private TeamRepository repository;
  @InjectMocks // モックオブジェクトの注入
  private TeamService service;
  
  @SuppressWarnings("deprecation")
  @BeforeEach // テストメソッド（@Testをつけたメソッド）実行前に都度実施
    public void initmocks() {
        MockitoAnnotations.initMocks(this);
    }
  
  @Test
  void testFindAll() {
    when(repository.findAll()).thenReturn(getTeamList());

    List<Team> team_list = repository.findAll();
    assertEquals(team_list.size(), 2);
    assertEquals(team_list.get(0).getId(),1);
    assertEquals(team_list.get(0).getLeagueName(),"Aリーグ");
    assertEquals(team_list.get(0).getTeamName(), "Aチーム");
    assertEquals(team_list.get(0).getHeadquarters(), "横浜スタジアム");
    assertEquals(team_list.get(0).getInauguration(), "2024年2月9日");
    assertEquals(team_list.get(0).getHistory(), "新興チームです！");
    
    assertEquals(team_list.get(1).getId(),2);
    assertEquals(team_list.get(1).getLeagueName(),"Bリーグ");
    assertEquals(team_list.get(1).getTeamName(), "Bチーム");
    assertEquals(team_list.get(1).getHeadquarters(), "名古屋ドーム");
    assertEquals(team_list.get(1).getInauguration(), "2024年1月1日");
    assertEquals(team_list.get(1).getHistory(), "伝説のチームです！");

  }

  @Test
  void testLoad() {
    when(repository.load(10)).thenReturn(getTeamById());
    Team team = repository.load(10);

    assertEquals(team.getId(), 10);
    assertEquals(team.getLeagueName(),"Aリーグ");
    assertEquals(team.getTeamName(), "Aチーム");
    assertEquals(team.getHeadquarters(), "横浜スタジアム");
    assertEquals(team.getInauguration(), "2024年2月9日");
    assertEquals(team.getHistory(), "新興チームです！");

  }

  public List<Team> getTeamList() {
    List<Team> team_list = new ArrayList<>();
    Team teamA = new Team(1, "Aリーグ", "Aチーム", "横浜スタジアム", "2024年2月9日", "新興チームです！");
    Team teamB = new Team(2, "Bリーグ", "Bチーム", "名古屋ドーム", "2024年1月1日", "伝説のチームです！");
    team_list.add(teamA);
    team_list.add(teamB);
  
    return team_list;
  }

  public Team getTeamById() {
    Team team10 = new Team(10, "Aリーグ", "Aチーム", "横浜スタジアム", "2024年2月9日", "新興チームです！");
  
    return team10;
  }
}
