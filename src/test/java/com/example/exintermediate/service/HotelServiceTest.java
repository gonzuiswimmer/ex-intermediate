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

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.repository.HotelRepository;

public class HotelServiceTest {

  @Mock
  private HotelRepository repository;
  @InjectMocks
  private HotelService service;
  @SuppressWarnings("deprecation")
  @BeforeEach
  public void initMocks(){
    MockitoAnnotations.initMocks(this);
  }


  @Test
  void testFindAll() {
    when(repository.findAll()).thenReturn(getHotelList());
    List<Hotel> hotel_list = repository.findAll();

    assertEquals(hotel_list.size(), 2);
    assertEquals(hotel_list.get(0).getId(), 1);
    assertEquals(hotel_list.get(0).getAreaName(), "エリアA");
    assertEquals(hotel_list.get(0).getHotelName(), "ホテルA");
    assertEquals(hotel_list.get(0).getAddress(), "東京都新宿区");
    assertEquals(hotel_list.get(0).getNearestStation(), "新宿三丁目");
    assertEquals(hotel_list.get(0).getPrice(), 5000);

    assertEquals(hotel_list.get(1).getId(), 2);
    assertEquals(hotel_list.get(1).getAreaName(), "エリアB");
    assertEquals(hotel_list.get(1).getHotelName(), "ホテルB");
    assertEquals(hotel_list.get(1).getAddress(), "東京都葛飾区");
    assertEquals(hotel_list.get(1).getNearestStation(), "亀有公園前");
    assertEquals(hotel_list.get(1).getPrice(), 10000);
  }

  @Test
  void testSearch() {
    when(repository.search(9000)).thenReturn(lessThanPriceHotels());
    List<Hotel> hotel_list = repository.search(9000);

    assertEquals(hotel_list.size(), 1);
    assertEquals(hotel_list.get(0).getId(), 1);
    assertEquals(hotel_list.get(0).getAreaName(),"エリアA");
    assertEquals(hotel_list.get(0).getHotelName(),"ホテルA");
    assertEquals(hotel_list.get(0).getAddress(),"東京都新宿区");
    assertEquals(hotel_list.get(0).getNearestStation(),"新宿三丁目");
    assertEquals(hotel_list.get(0).getPrice(),5000);

  }

  public List<Hotel> getHotelList(){
    List<Hotel> hotel_list = new ArrayList<>();
    Hotel hotelA = new Hotel(1, "エリアA", "ホテルA", "東京都新宿区", "新宿三丁目", 5000,
    "あり");
    Hotel hotelB = new Hotel(2, "エリアB", "ホテルB", "東京都葛飾区", "亀有公園前", 10000,
    "なし");
    hotel_list.add(hotelA);
    hotel_list.add(hotelB);

    return hotel_list;
  }

  public List<Hotel> lessThanPriceHotels(){
    List<Hotel> hotel_list = new ArrayList<>();
    Hotel hotelA = new Hotel(1, "エリアA", "ホテルA", "東京都新宿区", "新宿三丁目", 5000,
    "あり");
 
    hotel_list.add(hotelA);

    return hotel_list;
  }
}
