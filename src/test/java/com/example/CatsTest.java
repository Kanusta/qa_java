package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatsTest {
    @Test
    public void checkGetSound() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void checkGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        int getKittensRes = cat.getKittens();
        Assert.assertEquals(getKittensRes,1);
    }

    @Test
    public void checkEatFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> eat = List.of("Хищник");
        Mockito.when(feline.eatMeat()).thenReturn(eat);
        Cat cat = new Cat(feline);
        assertEquals(eat,cat.getFood());
    }

    @Test
    public void checkGetFamily() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Кошачьи",cat.getFamily());
    }

}

