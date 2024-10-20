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
    public class CatsTest {

        @Mock
        private Feline feline;
        private Cat cat;

        @Before
        public void initCat() {
            cat = new Cat(feline);
        }

        @Test
        public void getSoundTest() {
            Assert.assertEquals("Мяу", cat.getSound());
        }

        @Test
        public void getFoodTest() throws Exception {
            List<String> eat = List.of("Хищник");
            Mockito.when(feline.eatMeat()).thenReturn(eat);
            Assert.assertEquals(eat, cat.getFood());
        }
        @Test
        public void checkGetKittens()  {
            assertEquals(cat.getKittens(),1);
        }
    }




