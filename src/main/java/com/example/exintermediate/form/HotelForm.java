package com.example.exintermediate.form;

public class HotelForm {
  /** 料金 */
  private Integer price;

  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "HotelForm [price=" + price + "]";
  }
  
}
