package cacheline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CruiseControlEnumTest {

    @Test
    public void setPresetStop() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.STOP);
        //"STOP SPEED not set properly"
        Assertions.assertEquals(0, Double.compare(SpeedPreset.STOP.speedKmh,
                cruiseControlEnum.getTargetSpeedKmh()));

    }
    @Test
    public void setPresetPlanetary() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.PLANETARY_SPEED);
        //"STOP SPEED not set properly",
        Assertions.assertEquals(0, Double.compare(SpeedPreset.PLANETARY_SPEED.speedKmh,
                cruiseControlEnum.getTargetSpeedKmh()));

    }
    @Test
    public void setPresetCruise() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.CRUISE_SPEED);
        //"STOP SPEED not set properly",
        Assertions.assertEquals(0, Double.compare(SpeedPreset.CRUISE_SPEED.speedKmh,
                cruiseControlEnum.getTargetSpeedKmh()));

    }
}