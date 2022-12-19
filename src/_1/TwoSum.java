package _1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(input, target);
        Arrays.stream(result).forEach(System.out::println);
    }

}
