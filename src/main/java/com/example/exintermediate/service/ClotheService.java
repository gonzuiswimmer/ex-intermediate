package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.domain.Clothe;
import com.example.exintermediate.repository.ClotheRepository;

@Service
public class ClotheService {
  @Autowired
  private ClotheRepository repository;

  /**
   * 服のリストを返す.
   * 
   * @return List<Clothe> Clotheオブジェクトのリスト
   */
  public List<Clothe> search(Integer gender, String color){
    return repository.search(gender, color);
  }
}
