package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void checkEatsFood () throws Exception {
        Feline feline = new Feline();
        List<String> animalKids = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        assertEquals(animalKids,cat.getFood());
    }
    @Test
    public void checkGetFamily(){
        Feline feline = new Feline();
        String family = "Кошачьи";
        assertEquals(family,feline.getFamily());
    }

}










