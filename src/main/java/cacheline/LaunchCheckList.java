package cacheline;

import java.util.Arrays;
import java.util.List;

public class LaunchCheckList {
    List<String> checks = Arrays.asList(
            "Cabin Pressure",
            "Communication",
            "Engine");

    Status prepareForTakeOff(Commander commander) {
        for (int i = 0; i < checks.size(); i++) {
            boolean shouldAbortTakeOff = commander.isFailing(checks.get(i));
            if (shouldAbortTakeOff) {
                return Status.HALT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}

enum  Commander {
    CabinPressure("Cabin Pressure");

    final String str;
    Commander(String str) {
        this.str = str;
    }
    boolean isFailing(String str) {
        return false;
    }
}
enum Status {
    READY_FOR_TAKE_OFF(true), HALT_TAKE_OFF(false);

    final boolean doTakeOff;
    Status(boolean doTakeOff) {
        this.doTakeOff = doTakeOff;
    }
}