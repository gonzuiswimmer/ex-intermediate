package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.repository.HotelRepository;

@Service
public class HotelService {
  @Autowired
  private HotelRepository repository;

  /**
   * 全てのホテルのリストを返す.
   * @return List<Hotel> Hotelオブジェクトのリスト
   */
  @Transactional
  public List<Hotel> findAll(){
    return repository.findAll();
  }

  /**
   * 引数の価格以下の全てのホテルのリストを返す.
   * @return List<Hotel> Hotelオブジェクトのリスト
   */
  @Transactional
  public List<Hotel> search(int price){
    return repository.search(price);
  }
}
