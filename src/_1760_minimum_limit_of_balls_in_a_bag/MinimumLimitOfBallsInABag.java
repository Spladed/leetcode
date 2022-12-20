package _1760_minimum_limit_of_balls_in_a_bag;

import java.util.Arrays;

public class MinimumLimitOfBallsInABag {

    private static int minimumSize(int[] nums, int maxOperations) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int result = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            int ops = 0;
            for (int num : nums) {
                // (num - 1) / mid 表示要把袋子里的 num 分解到每个袋子里最大只有 mid 个球，需要几步
                ops += (num - 1) / mid;
            }
            if (ops <= maxOperations) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int maxOperations = 2;
        // result shoule be 3
        int result = minimumSize(nums, maxOperations);
        System.out.println(result);
    }

}
