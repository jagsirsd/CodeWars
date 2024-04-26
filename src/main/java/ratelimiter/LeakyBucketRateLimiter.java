package ratelimiter;

public class LeakyBucketRateLimiter implements RateLimiter {

    @Override
    public boolean allowRequest() {
        com.google.common.util.concurrent.RateLimiter.create(2);
        return false;
    }
}
