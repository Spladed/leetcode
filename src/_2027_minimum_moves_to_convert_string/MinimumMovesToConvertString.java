package _2027_minimum_moves_to_convert_string;

public class MinimumMovesToConvertString {

    public static int minimumMoves(String s) {
        int count = 0;
        int covered = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X' && i > covered) {
                count++;
                covered = i + 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "OXOX";
        System.out.println(minimumMoves(s));
    }

}
