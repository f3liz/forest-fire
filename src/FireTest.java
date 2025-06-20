import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnExampleOneTree() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnLongPath() {
        char[][] forest = {
            {'t','t','t','t','t','t','t','t','t'},
            {'t','.','.','.','.','.','.','.','.'},
            {'t','.','t','t','t','t','t','t','t'},
            {'t','t','t','.','.','.','.','.','.'}
        };

        int matchR = 0;
        int matchC = 8;

        int expected = 20;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnNoTree() {
        char[][] forest = {
            {'t','t','t','t','t','t','t','t','t'},
            {'t','.','.','.','.','.','.','.','.'},
            {'t','.','t','t','t','t','t','t','t'},
            {'t','t','t','.','.','.','.','.','.'}
        };

        int matchR = 1;
        int matchC = 1;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Fire.timeToBurn(forest, matchR, matchC);
        });

        assertEquals("Not a tree!", exception.getMessage());
    }

}
