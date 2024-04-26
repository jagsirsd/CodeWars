import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DRootExampleTest {
    int numberOfReps = 100_000_000;

    @Test
    public void A1Test1() {
        assertEquals(7, DRootPlain.digital_root(16), "Nope!");
    }

    @Test
    public void B1Test2() {
        assertEquals(6, DRootPlain.digital_root(456), "Nope!");
    }

    @RepeatedTest(100)
    public void D1exampleTests() {
        assertArrayEquals(new int[]{8, 64}, DRootPlain.parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, DRootPlain.parse("iiisdosodddddiso"));
        assertArrayEquals(new int[]{8, 64, 3600, 12_967_201}, DRootPlain.parse("iiisdosodddddisoiso"));
        assertArrayEquals(new int[]{8, 64, 3600, 12_967_200}, DRootPlain.parse("iiisdosodddddisoisdo"));
    }

    @RepeatedTest(100)
    public void D2exampleDeadFishTests() {
        assertArrayEquals(new int[]{8, 64}, DeadFishCommand.parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, DeadFishCommand.parse("iiisdosodddddiso"));
        assertArrayEquals(new int[]{8, 64, 3600, 12_967_201}, DeadFishCommand.parse("iiisdosodddddisoiso"));
        assertArrayEquals(new int[]{8, 64, 3600, 12_967_200}, DeadFishCommand.parse("iiisdosodddddisoisdo"));
    }

    @RepeatedTest(10)
    public void E1DRootPlainStress() {
        for (int i = 0; i < numberOfReps; i++) {
            assertArrayEquals(new int[]{8, 64}, DRootPlain.parse("iiisdoso"));
            assertArrayEquals(new int[]{8, 64, 3600}, DRootPlain.parse("iiisdosodddddiso"));
            assertArrayEquals(new int[]{8, 64, 3600, 12_967_201}, DRootPlain.parse("iiisdosodddddisoiso"));
            assertArrayEquals(new int[]{8, 64, 3600, 12_967_200}, DRootPlain.parse("iiisdosodddddisoisdo"));
        }
    }

    @RepeatedTest(10)
    public void E2DeadFishCommandStress() {
        for (int i = 0; i < numberOfReps; i++) {
            assertArrayEquals(new int[]{8, 64}, DeadFishCommand.parse("iiisdoso"));
            assertArrayEquals(new int[]{8, 64, 3600}, DeadFishCommand.parse("iiisdosodddddiso"));
            assertArrayEquals(new int[]{8, 64, 3600, 12_967_201}, DeadFishCommand.parse("iiisdosodddddisoiso"));
            assertArrayEquals(new int[]{8, 64, 3600, 12_967_200}, DeadFishCommand.parse("iiisdosodddddisoisdo"));
        }
    }
}