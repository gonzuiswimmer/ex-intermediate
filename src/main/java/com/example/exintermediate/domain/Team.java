package com.example.exintermediate.domain;

public class Team {
  /** ID */
  private int id;
  /** リーグ名 */
  private String leagueName;
  /** チーム名 */
  private String teamName;
  /** ホーム */
  private String headquarters;
  /** 創立 */
  private String inauguration;
  /** 歴史 */
  private String history;

  public Team() {
  }
  public Team(int id, String leagueName, String teamName, String headquarters, String inauguration, String history) {
    this.id = id;
    this.leagueName = leagueName;
    this.teamName = teamName;
    this.headquarters = headquarters;
    this.inauguration = inauguration;
    this.history = history;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getLeagueName() {
    return leagueName;
  }
  public void setLeagueName(String leagueName) {
    this.leagueName = leagueName;
  }
  public String getTeamName() {
    return teamName;
  }
  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }
  public String getHeadquarters() {
    return headquarters;
  }
  public void setHeadquarters(String headquarters) {
    this.headquarters = headquarters;
  }
  public String getInauguration() {
    return inauguration;
  }
  public void setInauguration(String inauguration) {
    this.inauguration = inauguration;
  }
  public String getHistory() {
    return history;
  }
  public void setHistory(String history) {
    this.history = history;
  }
  @Override
  public String toString() {
    return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters=" + headquarters
        + ", inauguration=" + inauguration + ", history=" + history + "]";
  }
  
}
