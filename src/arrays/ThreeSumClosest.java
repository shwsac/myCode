package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = i;
            int second = i+1;
            int third = nums.length-1;
            while(second<third) {
                int sum = nums[first] + nums[second] + nums[third];
                if(sum == target) {
                    return sum;
                }
                int newDifference = Math.abs(sum - target);
                if(newDifference < minDifference) {
                    minDifference = newDifference;
                    closestSum = sum;
                }
                System.out.println(sum);
                if(sum > target) {
                    third--;
                }
                else {
                    second++;
                }
            }
        }
        return closestSum;

    }

    public static void main(String[] args) {
        int[] S = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(S,-1));

    }

}
