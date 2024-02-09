package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Team;

@Repository
public class TeamRepository {
  @Autowired
  private NamedParameterJdbcTemplate template;
  private static final String FIND_ALL_QUERY = """
    SELECT id, league_name, team_name, headquarters, inauguration, history
      FROM teams
        ORDER BY inauguration ASC;   
  """;
  private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs,i) -> {
    Team team = new Team();
    team.setId(rs.getInt("id"));
    team.setLeagueName(rs.getString("league_name"));
    team.setTeamName(rs.getString("team_name"));
    team.setHeadquarters(rs.getString("headquarters"));
    team.setInauguration(rs.getString("inauguration"));
    team.setHistory(rs.getString("history"));
    return team;
  };

  /**
   * 全チームの情報をDBから取得して発足日の昇順のリストを返却する.
   * 
   * @return List<Team> チームオブジェクトのリスト
   */
  public List<Team> findAll(){
    SqlParameterSource param = new MapSqlParameterSource();
    return template.query(FIND_ALL_QUERY, param, TEAM_ROW_MAPPER);
  }
}
