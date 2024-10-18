package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void checkEatsFood () throws Exception {
        Feline feline = new Feline();
        List<String> animalKids = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        assertEquals(feline.eatMeat(),animalKids);
    }
}










