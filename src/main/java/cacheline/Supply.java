package cacheline;

public enum Supply {
    CONTAMINATED(false), CLEAN(true);

    final boolean isClean;

    Supply(boolean isClean) {
        this.isClean = isClean;
    }

    Supply isContaminated() {
        return CONTAMINATED;
    }
}
