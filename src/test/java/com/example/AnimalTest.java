package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {
    private String animalKind;

    @Test
    public void checkHerbivore() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Трава","Различные растения"),animal.getFood("Травоядное"));
    }

    @Test
    public void checkFamily() {
        Animal animal = new Animal();
        String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(family,animal.getFamily());
    }

    @Test
    public void checkPredator() throws Exception {
        Animal animal = new Animal();
        List<String> animalKids = List.of("Животные","Птицы","Рыба");
        Assert.assertEquals(animalKids,animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void checkExpected() throws Exception {
        Animal animal = new Animal();
        Mockito.spy(animal.getFood("Пол"));
        if  (!"Травоядное".equals(animalKind)&& !"Хищник".equals(animalKind)) {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        }
    }
}





























    









