package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<LinkedList<Integer>> hsSet = new HashSet<LinkedList<Integer>>();
        LinkedList<Integer> list;
        for (int index = 0; index < nums.length; index++) {
            int start = index + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[index] + nums[start] + nums[end];
                if (sum == 0) {
                    list = new LinkedList<Integer>();
                    list.add(nums[index]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    hsSet.add(list);
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }

        }
        result.addAll(hsSet);
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums));

    }
}

