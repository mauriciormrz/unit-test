package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest(){
        assertNotNull(calculator, "Calculator debe ser not null");
        System.out.println("@Test -> calculatorNotNullTest()");
    }

    @Test
    public void calculatorNullTest(){
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");
    }

    @Test
    public void addAssertTest(){
        //1.- SetUp
        int resultadoEsperado = 30;
        int resutadoActual;

        //2.- Action
        resutadoActual = calculator.add(10,20);

        //3.- Assert
        assertEquals(resultadoEsperado,resutadoActual);

        System.out.println("@Test -> addAssertTest()");
    }

    @Test
    public void addTest(){
        assertEquals(30,calculator.add(10,20));
    }

    @Test
    public void assertTypesTest(){
        assertTrue(1==1);
    }

    @Test
    public void divide_Invalid_Input_Test(){
        //fail("Fallo detectado manualmente -- No se puede dividir por cero");
        //calculator.divide(10,0);
    }

    @Test
    public void divide_Invalid_Input_ExpectedException_Test(){
        assertThrows(ArithmeticException.class, ()->calculator.divideByZero(2,0), "No se puede dividir por cero");
    }

}