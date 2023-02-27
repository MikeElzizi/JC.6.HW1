import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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


    @ParameterizedTest
    @MethodSource("source")
    public void test_taxEarnings(int a, int b) {
        int result = forTest.taxEarnings(a);
        assertEquals(result, b);
    }

    @Test
    public void test1_taxEarnings() {
        int a = 500;
        int result = forTest.taxEarnings(a);
        assertNotNull(result);
    }

    @Test
    public void test_notEquals() {
        int a = 500, b = 100;
        boolean result = forTest.notEquals(a, b);
        assertTrue(result);
    }


    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(500, 100), Arguments.of(500, 600));
    }
}

