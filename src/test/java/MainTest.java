import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
        Main forTest;

        @BeforeEach
        public void init() {
            System.out.println("Test started");
            forTest = new Main();
        }

        @BeforeAll
        public static void started() {
            System.out.println("Tests started");
        }

        @AfterEach
        public void finished() {
            System.out.println("Test completed");
        }

        @AfterAll
        public static void finishedAll() {
            System.out.println("Tests completed. IT'S ALIVE!! :)");
        }

        @Test
        public void test_notEquals() {
            int a = 100;
            int b = 300;
            boolean result = forTest.notEquals(a, b);
            assertTrue(result);
        }
        @Test
        @DisplayName("Проверка корректности деления метода")
        void devide() {
            //given
            final int x = 35;
            final int y = 7;
            final int expected = 5;
            //when
            final int result = forTest.taxEarningsMinusSpendings(x, y);
            //then
            Assertions.assertEquals(expected, result);
        }
    @Test
    @DisplayName("Проверка деления на 0")
    void devideByZero() {
        //given
        final int x = 35;
        final int y = 0;
        //then
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> forTest.taxEarningsMinusSpendings(x, y)
        );
    }
    @Test
    @DisplayName("Проверка текста исключения при делении на 0")
    void exceptionDevideByZero() {
        //given
        final int x = 0;
        final int y = 0;

        //when
        final  ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> forTest.taxEarningsMinusSpendings(x, y));
        //then
        Assertions.assertEquals("Внимание!!! Деление на 0! На ноль делить нельзя", "Внимание!!! Деление на 0! На ноль делить нельзя");
    }
}

