import junit.framework.TestCase;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import java.util.Random;
import org.junit.Test;
import static java.lang.Math.log;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;



public class SortOddAndKeepEvenInPositionTest extends TestCase {

    @Test
    public void testROT13() {
        //assertEquals("I want some ROT13 data", SortOddAndKeepEvenInPosition.testToCharArray("V jnag fbzr EBG13 qngn"));
        assertEquals("I want some ROT13 data", SortOddAndKeepEvenInPosition.rot13("V jnag fbzr EBG13 qngn"));
    }

    @Test
    public void testBasic() {
        assertFalse("9 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(9));
        assertFalse("0  is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(0));
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
        assertFalse("9 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(9));
//            assertFalse("45 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(45));
//            assertFalse("-5 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-5));
//            assertFalse("-8 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-8));
//            assertFalse("-41 is not SortOddAndKeepEvenInPosition", SortOddAndKeepEvenInPosition.isPrime(-41));
    }

    @Test
    public void test0() {
        assertNull("0 is not a perfect number", SortOddAndKeepEvenInPosition.isPerfectPower(0));
    }

    @Test
    public void test1() {
        assertNull("1 is not a perfect number", SortOddAndKeepEvenInPosition.isPerfectPower(1));
    }

    @Test
    public void test2() {
        assertNull("2 is not a perfect number", SortOddAndKeepEvenInPosition.isPerfectPower(2));
    }

    @Test
    public void test3() {
        assertNull("3 is not a perfect number", SortOddAndKeepEvenInPosition.isPerfectPower(3));
    }

    @Test
    public void test4() {
        assertArrayEquals("4 = 2^2", new int[]{2,2}, SortOddAndKeepEvenInPosition.isPerfectPower(4));
    }

    @Test
    public void test5() {
        assertNull("5 is not a perfect power", SortOddAndKeepEvenInPosition.isPerfectPower(5));
    }

    @Test
    public void test8() {
        assertArrayEquals("8 = 2^3", new int[]{2,3}, SortOddAndKeepEvenInPosition.isPerfectPower(8));
    }

    @Test
    public void test9() {
        assertArrayEquals("9 = 3^2", new int[]{3,2}, SortOddAndKeepEvenInPosition.isPerfectPower(9));
    }
    @Test
    public void test225() {
        assertArrayEquals("9 = 3^2", new int[]{15,2}, SortOddAndKeepEvenInPosition.isPerfectPower(225));
    }
    @Test
    public void test10503459() {
        assertArrayEquals("9 = 3^2", new int[]{219, 3}, SortOddAndKeepEvenInPosition.isPerfectPower(10503459));
    }

    @Test
    public void testUpTo500() {
        int[] pp = {4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256, 289, 324, 343, 361, 400, 441, 484};
        for (int i: pp) assertNotNull(i+" is a perfect power", SortOddAndKeepEvenInPosition.isPerfectPower(i));
    }

    @Test
    public void testRandomPerfectPowers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int m = rnd.nextInt(254)+2;
            int k = (int)(rnd.nextDouble()*(log(Integer.MAX_VALUE)/log(m)-2.0)+2.0);
            int l = ipow(m, k);
            int[] r = SortOddAndKeepEvenInPosition.isPerfectPower(l);
            assertNotNull(l+" is a perfect power", r);
            assertEquals(r[0]+"^"+r[1]+"!="+l, l, ipow(r[0], r[1]));
        }
    }

    @Test
    public void testRandomNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int l = rnd.nextInt(Integer.MAX_VALUE);
            int[] r = SortOddAndKeepEvenInPosition.isPerfectPower(l);
            if (r != null) assertEquals(r[0]+"^"+r[1]+"!="+l, l, ipow(r[0], r[1]));
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