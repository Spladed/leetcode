package _1753_maximum_score_from_removing_stones;

import java.util.Arrays;

public class MaximumScoreFromRemovingStones {

    public static int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int score = 0;
        while (arr[1] != 0) {
            arr[1]--;
            arr[2]--;
            Arrays.sort(arr);
            score++;
        }
        return score;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 8;
        int c = 8;
        int result = maximumScore(a, b, c);
        System.out.println(result);
    }

}
