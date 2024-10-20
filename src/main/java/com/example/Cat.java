package com.example;

import java.util.List;

public class Cat   {


    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }
    Feline feline = new Feline();


    public int getKittens() {
        return feline.getKittens();
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }




}
