package junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;
    private static Calculator calculatorStatic;

    @BeforeAll
    public static void beforeAllTest(){
        calculatorStatic = new Calculator();
        System.out.println("@BeforeAll -> beforeAllTest()");
    }

    @AfterAll
    public static void afterAllTest(){
        calculatorStatic = null;
        System.out.println("@AfterAll -> afterAllTest()");
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest() {
        assertNotNull(calculatorStatic, "Calculator debe ser not null");
        assertNotNull(calculator, "Calculator debe ser not null");
        System.out.println("@Test -> calculatorNotNullTest()");
    }

    @Test
    public void calculatorNullTest() {
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");
    }

    @Test
    public void addAssertTest() {
        //1.- SetUp
        int resultadoEsperado = 30;
        int resutadoActual;

        //2.- Action
        resutadoActual = calculator.add(10, 20);

        //3.- Assert
        assertEquals(resultadoEsperado, resutadoActual);

        System.out.println("@Test -> addAssertTest()");
    }

    @Test
    public void addTest() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void assertTypesTest() {
        assertTrue(1 == 1);
    }

    @Disabled("Comentarios")
    @Test
    public void divide_Invalid_Input_Test() {
        fail("Fallo detectado manualmente -- No se puede dividir por cero");
        calculator.divide(10, 0);
    }

    @Test
    public void divide_Invalid_Input_ExpectedException_Test() {
        assertThrows(ArithmeticException.class, () -> calculator.divideByZero(2, 0), "No se puede dividir por cero");
    }

    @Test
    @DisplayName("Método dividir -> Funciona")
    public void divide_ValidInput_ValueResultExpected_Name_Test() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    public void add_Assert_All_Test() {
        assertAll(
                () -> assertEquals(31, calculator.add(11, 20)),
                () -> assertEquals(30, calculator.add(10, 20)),
                () -> assertEquals(2, calculator.add(1, 1))
        );
    }

    @Nested
    class AddTest {

        @Test
        public void add_Positive_Test() {
            assertEquals(30, calculator.add(15, 15));
        }

        @Test
        public void add_Negative_Test() {
            assertEquals(-30, calculator.add(-15, -15));
        }

        @Test
        public void add_Zero_Test() {
            assertEquals(0, calculator.add(15, -15));
        }
    }

}