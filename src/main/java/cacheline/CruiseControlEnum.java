package cacheline;

import java.util.Objects;

public class CruiseControlEnum {

    private double targetSpeedKmh;

    public double getTargetSpeedKmh() {
        return targetSpeedKmh;
    }

    void setPreset(SpeedPreset speedPreset) {
        Objects.requireNonNull(speedPreset);

        setTargetSpeedKmh(speedPreset.speedKmh);
    }

    void setTargetSpeedKmh(double speedKmh) {
        this.targetSpeedKmh = speedKmh;
    }
}

enum SpeedPreset {
    STOP(0), PLANETARY_SPEED(7667), CRUISE_SPEED(16944);
    final double speedKmh;

    SpeedPreset(int speedKmh) {
        this.speedKmh = speedKmh;
    }
}
