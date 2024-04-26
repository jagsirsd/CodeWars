import java.util.*;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> number_to_index = new HashMap<>();

        int indexforHalfNum = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (number_to_index.containsKey(numbers[i])) {
                indexforHalfNum = number_to_index.get(numbers[i]);
            }
            number_to_index.put(numbers[i], i);

        }

        Set<Integer> retArr = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : number_to_index.entrySet()) {
            Integer num = entry.getKey();
            Integer checkNum = target - num;
            if (number_to_index.containsKey(checkNum) && (entry.getValue() != number_to_index.get(checkNum))) {
                retArr.add(entry.getValue());
                retArr.add(number_to_index.get(checkNum));
            }
        }
        if (indexforHalfNum >= 0) {
            Integer checkNum = target - numbers[indexforHalfNum];
            if (number_to_index.containsKey(checkNum) && indexforHalfNum != number_to_index.get(checkNum)) {
                retArr.add(indexforHalfNum);
                retArr.add(number_to_index.get(checkNum));
            }
        }
        return retArr.stream().mapToInt(i -> i).toArray();
    }
}
