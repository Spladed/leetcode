package _1759_count_number_of_homogenous_substrings;

public class CountNumberOfHomogenousSubstrings {

    private static int countHomogenous(String s) {
        // (10^9) + 7
        final int MOD = 1000000007;
        char prev = s.charAt(0);
        int count = 0;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == prev) {
                count++;
            } else {
                result += calculate(count);
                prev = current;
                count = 1;
            }
        }
        // 循环结束后，最后一次的字符序列纳入计算
        result += calculate(count);
        // 按题目要求取余
        return (int) (result % MOD);
    }

    // 假设当前连续字符序列是zzz
    // 那么一共有zzz（出现1次）、zz（出现两次）、z（出现三次）三种子项
    // 共计 1 + 2 + 3 = 6
    // 这里其实是一个等差数列，求n项和（n为连续字符序列的长度， 数列的差为1）
    // 计算等差数列前n项和
    private static long calculate(int count) {
        return (long) (count + 1) * count / 2;
    }

    public static void main(String[] args) {
        String str = "abbcccaa";
        int result = countHomogenous(str);
        System.out.println(result);
    }

}
