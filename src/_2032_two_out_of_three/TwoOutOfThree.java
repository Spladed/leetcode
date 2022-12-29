package _2032_two_out_of_three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> set3 = new HashSet<>();
        for (int num : nums3) {
            set3.add(num);
        }
        HashSet<Integer> retain1 = new HashSet<>(set1);
        retain1.retainAll(set2);
        HashSet<Integer> retain2 = new HashSet<>(set1);
        retain2.retainAll(set3);
        HashSet<Integer> retain3 = new HashSet<>(set2);
        retain3.retainAll(set3);
        retain1.addAll(retain2);
        retain1.addAll(retain3);
        return new ArrayList<>(retain1);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1}, nums2 = {2, 3}, nums3 = {1, 2};
        List<Integer> integers = twoOutOfThree(nums1, nums2, nums3);
        integers.forEach(System.out::println);
    }

}
