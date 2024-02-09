package com.example.exintermediate.form;

public class ClotheForm {
   /** 女性は0 */
   private static final int FEMALE = 0;
   /** 男性は1 */
   private static final int MALE = 1;
 
   /** 性別 */
   private Integer gender;
   /** 色 */
   private String color;
  public static int getFemale() {
    return FEMALE;
  }
  public static int getMale() {
    return MALE;
  }
  public Integer getGender() {
    return gender;
  }
  public void setGender(Integer gender) {
    this.gender = gender;
  }
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  @Override
  public String toString() {
    return "ClotheForm [gender=" + gender + ", color=" + color + "]";
  }

   
}
