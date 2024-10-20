package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private String sex;
    private boolean hasMane;

    public LionParameterizedTest(String sex,boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters()
    public static Object[] data() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false},
        };
    }
    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void initLion() throws Exception {
        lion = new Lion(sex,feline);
    }
        @Test
     public void checkDoesHaveMane() {
            MockitoAnnotations.openMocks(this);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(hasMane,actual);
    }
}
