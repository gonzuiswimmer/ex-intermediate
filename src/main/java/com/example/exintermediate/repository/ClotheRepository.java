package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Clothe;

@Repository
public class ClotheRepository {
  @Autowired
  private NamedParameterJdbcTemplate template;
  private static final String SEARCH_QUERY = """
    SELECT id, category, genre, gender, color, price, size
      FROM clothes
  """;
  private static final RowMapper<Clothe> CLOTH_ROW_MAPPER = 
  ( rs, i) -> {
    Clothe clothe = new Clothe();
    clothe.setId(rs.getInt("id"));
    clothe.setCategory(rs.getString("category"));
    clothe.setGenre(rs.getString("genre"));
    clothe.setGender(rs.getInt("gender"));
    clothe.setColor(rs.getString("color"));
    clothe.setPrice(rs.getInt("price"));
    clothe.setSize(rs.getString("size"));
    return clothe;
  };
  // new BeanPropertyRowMapper<>(Clothe.class);

  /**
   * 条件に合致する服のリストを取得して返す.
   * 
   * @return List<Clothe> Clotheオブジェクトのリスト
   */
  public List<Clothe> search(Integer gender, String color){
    SqlParameterSource param;
    StringBuilder builder = new StringBuilder();
    builder.append(SEARCH_QUERY);
    // 両方指定
    if(gender != null && color != null){
      System.out.println("両方指定されている場合");
      builder.append(" WHERE gender = " + gender + " AND color = '"  + color + "';");
      // 色のみ指定
    } else if(gender == null){
      System.out.println("色のみ指定されている場合");
      builder.append(" WHERE color = '" + color + "';");
      // 性別のみ指定
    } else if(color == null){
      System.out.println("性別のみ指定されている場合");
      builder.append(" WHERE gender = " + gender + ";");
    } else {
      System.out.println("予期しないケースです");
    }
    System.out.println("builder.toString() = " + builder.toString());
    List<Clothe> clothes = template.query(builder.toString(), CLOTH_ROW_MAPPER);
    return clothes;
  }
}
