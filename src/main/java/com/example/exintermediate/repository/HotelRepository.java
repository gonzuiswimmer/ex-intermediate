package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Hotel;

@Repository
public class HotelRepository {
  @Autowired
  private NamedParameterJdbcTemplate template;
  private static final String SEARCH_QUERY = """
    SELECT id, area_name, hotel_name, address, nearest_station, price, parking
      FROM hotels
        WHERE price <= :price
          ORDER BY price ASC;
  """;
  private static final String FIND_ALL_QUERY = """
    SELECT id, area_name, hotel_name, address, nearest_station, price, parking
      FROM hotels
        ORDER BY price ASC;
  """;

  private static final RowMapper<Hotel> HOTEL_ROW_MAPPER =
   (rs, i)-> {
    Hotel hotel = new Hotel();
    hotel.setId(rs.getInt("id"));
    hotel.setAreaName(rs.getString("area_name"));
    hotel.setHotelName(rs.getString("hotel_name"));
    hotel.setAddress(rs.getString("address"));
    hotel.setNearestStation(rs.getString("nearest_station"));
    hotel.setPrice(rs.getInt("price"));
    hotel.setParking(rs.getString("parking"));
    return hotel;
  };
  // new BeanPropertyRowMapper<>(Hotel.class);

  /**
   * 引数で渡された金額以下の値段のホテルのリストを取得して返す.
   * 
   * @param price
   * @return List<Hotel> ホテルオブジェクトのリスト
   */
  public List<Hotel> search(int price){
    SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
    return template.query(SEARCH_QUERY,param,HOTEL_ROW_MAPPER);
  }

  /**
   * すべてのホテルのリストを取得して返す.
   * 
   * @param price
   * @return List<Hotel> ホテルオブジェクトのリスト
   */
  public List<Hotel> findAll(){
    SqlParameterSource param = new MapSqlParameterSource();
    return template.query(FIND_ALL_QUERY,param,HOTEL_ROW_MAPPER);
  }
}
