package _3_longest_substring_without_repeating_characters;

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.offer(c);
                max = Math.max(max, queue.size());
            } else {
                while(queue.element()!=c) {
                    queue.poll();
                }
                queue.poll();
                queue.offer(c);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "dvdf";
        int result = lengthOfLongestSubstring(s);
        // result shoule be 3
        System.out.println(result);
    }

}
