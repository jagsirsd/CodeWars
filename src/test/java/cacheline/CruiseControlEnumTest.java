package cacheline;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CruiseControlEnumTest {

    @Test
    public void setPresetStop() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.STOP);
        Assert.assertTrue("STOP SPEED not set properly",
                Double.compare(SpeedPreset.STOP.speedKmh,
                        cruiseControlEnum.getTargetSpeedKmh()) == 0);

    }
    @Test
    public void setPresetPlanetary() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.PLANETARY_SPEED);
        Assert.assertTrue("STOP SPEED not set properly",
                Double.compare(SpeedPreset.PLANETARY_SPEED.speedKmh,
                        cruiseControlEnum.getTargetSpeedKmh()) == 0);

    }
    @Test
    public void setPresetCruise() {
        CruiseControlEnum cruiseControlEnum = new CruiseControlEnum();
        cruiseControlEnum.setPreset(SpeedPreset.CRUISE_SPEED);
        Assert.assertTrue("STOP SPEED not set properly",
                Double.compare(SpeedPreset.CRUISE_SPEED.speedKmh,
                        cruiseControlEnum.getTargetSpeedKmh()) == 0);

    }
}