package com.journaldev.concurrency;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class WaitNotifyTestTest extends TestCase {

    public void testLengthOfLongestSubstring() {
        Assertions.assertEquals("abc".length(),  WaitNotifyTest.lengthOfLongestSubstring("abcabcbb"));
    }
}