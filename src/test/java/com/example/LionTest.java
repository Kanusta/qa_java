package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private String sex;

    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void initLion() throws Exception {
        lion = new Lion("Самка",feline);
    }

    @Test
    public void checkEatMeat() throws Exception {
        List<String> eat = List.of("Хищник");
        Mockito.when(feline.getFood("Хищник")).thenReturn(eat);
        assertEquals(lion.getFood(),eat);
    }

   @Test
    public void checkGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int getKittensRes = lion.getKittens();
        Assert.assertEquals(getKittensRes,1);
    }

    @Test(expected = Exception.class)
    public void checkExpected() throws Exception{
         new  Lion(sex,feline);
        if (!"Самка".equals(sex))
            if (!"Самец".equals(sex)) {
                throw new Exception("Используйте допустимые значения пола животного - самец или самка");
            }
    }

}





















