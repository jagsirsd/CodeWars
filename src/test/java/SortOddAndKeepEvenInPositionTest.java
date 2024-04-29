
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.log;
import static org.junit.jupiter.api.Assertions.*;


public class SortOddAndKeepEvenInPositionTest {

    @Test
    public void testROT13() {
        //assertEquals("I want some ROT13 data", SortOddAndKeepEvenInPosition.testToCharArray("V jnag fbzr EBG13 qngn"));
        assertEquals("I want some ROT13 data", SortOddAndKeepEvenInPosition.rot13("V jnag fbzr EBG13 qngn"));
    }

    @Test
    public void testBasic() {
        assertFalse(SortOddAndKeepEvenInPosition.isPrime(9), "9 is not SortOddAndKeepEvenInPosition");
        assertFalse(SortOddAndKeepEvenInPosition.isPrime(0), "0  is not SortOddAndKeepEvenInPosition");
//            assertFalse("1  is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(1));
//            assertTrue ("2  is SortOddAndKeepEvenInPosition",     SortOddAndKeepEvenInPosition.isPrime(2));
//            assertTrue ("73 is SortOddAndKeepEvenInPosition",     SortOddAndKeepEvenInPosition.isPrime(73));
//            assertFalse("75 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(75));
//            assertFalse("-1 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-1));
    }

    @Test
    public void testPrime() {
//            assertTrue("3 is SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(3));
//            assertTrue("5 is SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(5));
//            assertTrue("7 is SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(7));
//            assertTrue("41 is SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(41));
//            assertTrue("5099 is SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(5099));
    }

    @Test
    public void testNotPrime() {
//            assertFalse("4 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(4));
//            assertFalse("6 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(6));
//            assertFalse("8 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(8));
        assertFalse(SortOddAndKeepEvenInPosition.isPrime(9), "9 is not SortOddAndKeepEvenInPosition");
//            assertFalse("45 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(45));
//            assertFalse("-5 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-5));
//            assertFalse("-8 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-8));
//            assertFalse("-41 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-41));
    }

    @Test
    public void test0() {
        assertNull(SortOddAndKeepEvenInPosition.isPerfectPower(0), "0 is not a perfect number");
    }

    @Test
    public void test1() {
        //"1 is not a perfect number",
        assertNull( SortOddAndKeepEvenInPosition.isPerfectPower(1));
    }

    @Test
    public void test2() {
        //"2 is not a perfect number",
        assertNull( SortOddAndKeepEvenInPosition.isPerfectPower(2));
    }

    @Test
    public void test3() {
        //"3 is not a perfect number",
        assertNull( SortOddAndKeepEvenInPosition.isPerfectPower(3));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{2,2}, SortOddAndKeepEvenInPosition.isPerfectPower(4), "4 = 2^2");
    }

    @Test
    public void test5() {
        //"5 is not a perfect power",
        assertNull( SortOddAndKeepEvenInPosition.isPerfectPower(5));
    }

    @Test
    public void test8() {
        //"8 = 2^3",
        Assertions.assertArrayEquals( new int[]{2,3}, SortOddAndKeepEvenInPosition.isPerfectPower(8));
    }

    @Test
    public void test9() {
        //"9 = 3^2",
        assertArrayEquals( new int[]{3,2}, SortOddAndKeepEvenInPosition.isPerfectPower(9));
    }
    @Test
    public void test225() {
        assertArrayEquals( new int[]{15,2}, SortOddAndKeepEvenInPosition.isPerfectPower(225));
    }
    @Test
    public void test10503459() {
        assertArrayEquals( new int[]{219, 3}, SortOddAndKeepEvenInPosition.isPerfectPower(10503459));
    }

    @Test
    public void testUpTo500() {
        int[] pp = {4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256, 289, 324, 343, 361, 400, 441, 484};
        for (int i: pp) {
            //i+" is a perfect power",
            assertNotNull(SortOddAndKeepEvenInPosition.isPerfectPower(i));
        }
    }

    @Test
    public void testRandomPerfectPowers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int m = rnd.nextInt(254)+2;
            int k = (int)(rnd.nextDouble()*(log(Integer.MAX_VALUE)/log(m)-2.0)+2.0);
            int l = ipow(m, k);
            int[] r = SortOddAndKeepEvenInPosition.isPerfectPower(l);
            //l+" is a perfect power",
            assertNotNull( r);
            //r[0]+"^"+r[1]+"!="+l,
            assertEquals( l, ipow(r[0], r[1]));
        }
    }

    @Test
    public void testRandomNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int l = rnd.nextInt(Integer.MAX_VALUE);
            int[] r = SortOddAndKeepEvenInPosition.isPerfectPower(l);
            if (r != null) {
                //r[0]+"^"+r[1]+"!="+l,
                assertEquals( l, ipow(r[0], r[1]));
            }
        }
    }

    private static int ipow(int b, int e) {
        int p = 1;
        for (; e > 0; e >>= 1) {
            if ((e & 1) == 1) p *= b;
            b *= b;
        }
        return p;
    }

}