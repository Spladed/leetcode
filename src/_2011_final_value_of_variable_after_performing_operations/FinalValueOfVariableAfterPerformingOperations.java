package _2011_final_value_of_variable_after_performing_operations;

import java.util.Arrays;

public class FinalValueOfVariableAfterPerformingOperations {

    private static int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations)
                .mapToInt(s -> 44 - s.charAt(1))
                .sum();
    }

    public static void main(String[] args) {
        String[] input = new String[]{"X++", "++X", "--X", "X--"};
        int result = finalValueAfterOperations(input);
        System.out.println(result);
    }

}
