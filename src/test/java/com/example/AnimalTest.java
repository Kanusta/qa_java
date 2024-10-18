package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    private String animalKind;

    @Test
    public void checkHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> animalKids = List.of("Трава","Различные растения");
        assertEquals(animal.getFood("Травоядное"),animalKids);
    }

    @Test
    public void checkFamily() {
        Animal animal = new Animal();
        String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(animal.getFamily(),family);
    }

    @Test
    public void checkPredator() throws Exception {
        Animal animal = new Animal();
        List<String> animalKids = List.of("Животные","Птицы","Рыба");
        assertEquals(animal.getFood("Хищник"),animalKids);
    }

    @Test
    public void checkAnimalException() {
        try {
            Animal animal = new Animal();
            List<String> exception = List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник");

            Mockito.when(animal.getFood(animalKind)).thenReturn(exception);
            if (!"Травоядное".equals(animalKind)&& !"Хищник".equals(animalKind)) {
            }  {
            }
        } catch (Exception animal) {
            assertEquals(animal.getMessage(),"Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
}




    









