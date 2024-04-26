package com.journaldev.concurrency;

import java.util.HashMap;

public class WaitNotifyTest {

    public static void main(String[] args) {
        String str = "Test String";
        forwardAndReverse(str);
        long howMany = 0;
        for(int i = 0;howMany > 1; i--) {
            howMany ++;
        }
        System.out.println(howMany);
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter, "waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }

    private static void forwardAndReverse(String test) {

        int indexOf ;
        for (int index = 99; index >= 0; index--) {
            switch ((index / test.length()) % 2) {
                case 0:
                    //Going forward
                    indexOf = index % test.length();
                    break;
                default:
                    //Going Reverse
                    indexOf = test.length() - index % test.length() - 1;
                    break;
            }
            System.out.println( test.charAt(indexOf));
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        return WaitNotifyTest.Solution.lengthOfLongestSubstring(s);
    }
    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            int len;
            if (s == null || (len = s.length()) == 0) return 0;
            int preP = 0, max = 0;
            int[] histogram = new int[256];
            for (int i = 0; i < len; ++i) {
                char c = s.charAt(i);
                if (histogram[c] > preP) {
                    preP = histogram[c];
                }
                int l = i - preP + 1;
                histogram[c] = i + 1;
                if (l > max) max = l;
            }
            return max;
        }
    }
    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; ++i) {
                final Integer expected  = target - nums[i];
                //Returns the index where expected is
                final Integer value = map.get(expected);
                if (value != null) {
                    //if present, then return the 2 numbers
                    return new int[] { expected, nums[i] };
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}