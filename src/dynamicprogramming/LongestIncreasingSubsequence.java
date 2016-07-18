package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Time complexity: O(n^2)
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int[] L = new int[nums.length];
        Arrays.fill(L, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    L[i] = Math.max(L[j] + 1, L[i]);
                }
            }
        }
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            if (max < L[i]) {
                max = L[i];
            }
        }

        return max;
    }

    // Time complexity: O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int num : nums) {
            if (list.size() == 0) {
                list.add(num);
            } else if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);
            }
        }
        return list.size();
    }

}
