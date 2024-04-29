package com.journaldev.concurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaitNotifyTestTest {
    @Test
    public void testLengthOfLongestSubstring() {
        Assertions.assertEquals("abc".length(),  WaitNotifyTest.lengthOfLongestSubstring("abcabcbb"));
    }
}