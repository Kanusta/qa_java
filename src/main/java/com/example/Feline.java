package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        int kittens = getKittens(1);
        return kittens;
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
