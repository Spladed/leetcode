package _1750_minimum_length_of_string_after_deleting_similar_ends;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static int minimumLength(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char c = s.charAt(i);
            while (i <= j && s.charAt(i) == c) {
                i++;
            }
            while (i <= j && s.charAt(j) == c) {
                j--;
            }
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        String s = "cabaabac";
        int minimumLength = minimumLength(s);
        System.out.println(minimumLength);
    }

}
