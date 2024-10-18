package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex,boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false},
        };
    }
        @Test
     public void checkDoesHaveMane() throws Exception{
            Feline feline = new Feline();

             Lion lion = new Lion(sex,feline);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(hasMane,actual);
    }
}
