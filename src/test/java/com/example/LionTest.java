package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private String sex;

    @Test
    public void checkEatFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> eat = List.of("Животные","Птицы","Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(eat);
        Lion lion = new Lion("Самка",feline);
        assertEquals(eat,lion.getFood());
    }

    @Test
    public void checkFamily() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        String name = "Кошачьи";
        Lion lion = new Lion("Самец",feline);
        assertEquals(name,lion.getFamily());
    }

    @Test
    public void checkEatMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> eat = List.of("Хищник");
        Lion lion = new Lion("Самка",feline);
        assertEquals(eat,lion.eatMeat());
    }

    @Test
    public void checkGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец",feline);
        int getKittensRes = lion.getKittens();
        Assert.assertEquals(getKittensRes,1);
    }

    @Test
    public void checkLionException() {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(sex,feline);
            if (!equals("Самка") && !equals("Самец")) {
            }
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Используйте допустимые значения пола животного - самец или самка");
        }
    }
}





















