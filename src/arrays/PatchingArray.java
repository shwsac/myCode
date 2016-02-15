package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PatchingArray {
    public static int minimumPatches(int[] nums, int n) {
        if (n <= 0) {
            return 0;
        }
        nums = nums == null ? new int[0] : nums;
        int index = 0;
        int patchCount = 0;
        long boundary_val = 1, sum = 0;
        while (boundary_val <= n) {
            if (index < nums.length && nums[index] <= boundary_val) {
                sum += nums[index++];
                boundary_val = sum + 1;
            } else {
                patchCount++;
                sum += boundary_val;
                boundary_val = sum + 1;
            }
        }
        return patchCount;
    }
    
    // Brute force 
    public int minPatches(int[] nums, int n) {
        Arrays.sort(nums);
        List<Integer> tempList = new ArrayList<Integer>();
        for (int index = 0; index < nums.length; index++) {
            tempList.add(nums[index]);
        }
        int patchCount = 0;
        for (int index = 1; index <= n; index++) {
            int prevSum = 0;
            int start = 0;
            int end = tempList.size() - 1;
            boolean found = false;
            while (start < end) {
                if (tempList.get(start) == index || tempList.get(end) == index) {
                    found = true;
                    break;
                }
                int sum = tempList.get(start) + tempList.get(end);
                if (sum == index) {
                    found = true;
                    break;
                }
                if (sum + prevSum == index) {
                    found = true;
                    break;
                }
                if (sum > index) {
                    sum -= tempList.get(start);
                    end--;
                } else {
                    sum -= tempList.get(end);
                    start++;
                }
                prevSum = prevSum + sum;
            }
            if (!found) {
                tempList.add(index);
                patchCount++;
                Collections.sort(tempList);
            }
        }
        return patchCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 10};
        System.out.println(minimumPatches(nums,20));

    }

}
