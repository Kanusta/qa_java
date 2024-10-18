package com.example;

import java.util.List;


 public  class Lion implements Predator{


     boolean hasMane;
     String sex;

    public Lion(String sex,Feline feline) throws Exception {
        this.feline=feline;
        this.sex=sex;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }

    }

    Feline feline = new Feline();


     public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }

     @Override
     public List<String> eatMeat() throws Exception {
         return List.of("Хищник");
     }

     @Override
     public String getFamily() {
         return "Кошачьи";
     }
 }
