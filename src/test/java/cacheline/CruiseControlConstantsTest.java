package cacheline;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CruiseControlConstantsTest {
    @Test
    public void setPresetStop() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(0);
        //"STOP SPEED not set properly"
        Assertions.assertEquals(0, Double.compare(CruiseControlConstants.STOP_PRESET,
                cruiseControlConstants.getTargetSpeedKmh()));

    }
    @Test
    public void setPresetP() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(1);
        //"PLANETARY SPEED not set properly"
        Assertions.assertEquals(0, Double.compare(CruiseControlConstants.PLANETARY_SPEED_KMH,
                cruiseControlConstants.getTargetSpeedKmh()));

    }
    @Test
    public void setPresetCruise() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(2);
        //"CRUISE SPEED not set properly"
        Assertions.assertEquals(0, Double.compare(CruiseControlConstants.CRUISE_SPEED_KMH,
                cruiseControlConstants.getTargetSpeedKmh()));

    }
}
