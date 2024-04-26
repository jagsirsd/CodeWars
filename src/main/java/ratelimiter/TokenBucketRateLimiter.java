package ratelimiter;

public class TokenBucketRateLimiter implements RateLimiter {
    @Override
    public boolean allowRequest() {

        return false;
    }
}
