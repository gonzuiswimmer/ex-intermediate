package com.example.exintermediate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.exintermediate.domain.Clothe;
import com.example.exintermediate.repository.ClotheRepository;

public class ClotheServiceTest {
  @Mock
  private ClotheRepository repository;
  @InjectMocks
  private ClotheService service;

  @SuppressWarnings("deprecation")
  @BeforeEach
  public void initMocks(){
    MockitoAnnotations.initMocks(this);  
  }

  @Test
  void testSearch() {
    when(repository.search(null, null)).thenReturn(resultClothesList());
    List<Clothe> clothes = repository.search(null, null);

    assertEquals(clothes.size(), 2);
    assertEquals(clothes.get(0).getId(), 1);
    assertEquals(clothes.get(0).getCategory(), "category_A");
    assertEquals(clothes.get(0).getGenre(), "genre_A");
    assertEquals(clothes.get(0).getGender(), 0);
    assertEquals(clothes.get(0).getColor(), "青");
    assertEquals(clothes.get(0).getSize(), "M");

    assertEquals(clothes.get(1).getId(), 2);
    assertEquals(clothes.get(1).getCategory(), "category_B");
    assertEquals(clothes.get(1).getGenre(), "genre_B");
    assertEquals(clothes.get(1).getGender(), 1);
    assertEquals(clothes.get(1).getColor(), "白");
    assertEquals(clothes.get(1).getSize(), "L");
  }


  public List<Clothe> resultClothesList(){
    List<Clothe> clothes = new ArrayList<>();

    Clothe clotheA = new Clothe(1, "category_A", "genre_A", 0, "青", 2000, "M");
    Clothe clotheB = new Clothe(2, "category_B", "genre_B", 1, "白", 3000, "L");
    clothes.add(clotheA);
    clothes.add(clotheB);

    return clothes;
  }
}
