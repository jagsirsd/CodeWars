package cacheline;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CruiseControlConstantsTest {
    @Test
    public void setPresetStop() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(0);
        Assert.assertTrue("STOP SPEED not set properly",
                Double.compare(CruiseControlConstants.STOP_PRESET,
                        cruiseControlConstants.getTargetSpeedKmh()) == 0);

    }
    @Test
    public void setPresetP() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(1);
        Assert.assertTrue("PLANETARY SPEED not set properly",
                Double.compare(CruiseControlConstants.PLANETARY_SPEED_KMH,
                        cruiseControlConstants.getTargetSpeedKmh()) == 0);

    }
    @Test
    public void setPresetCruise() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();
        cruiseControlConstants.setPreset(2);
        Assert.assertTrue("CRUISE SPEED not set properly",
                Double.compare(CruiseControlConstants.CRUISE_SPEED_KMH,
                        cruiseControlConstants.getTargetSpeedKmh()) == 0);

    }
}
