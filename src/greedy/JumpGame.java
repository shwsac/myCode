package greedy;

public class JumpGame {

    public int jump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        int maxReachableDistance = 0;
        int maxNextAvailableDist = 0;
        int minSteps = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i > maxReachableDistance) {
                if (maxNextAvailableDist > maxReachableDistance) {
                    maxReachableDistance = maxNextAvailableDist;
                    ++minSteps;
                } else
                    return -1;
            }
            maxNextAvailableDist = Math.max(maxNextAvailableDist, nums[i] + i);
            if (maxNextAvailableDist >= nums.length - 1) {
                return minSteps + 1;
            }
        }
        return -1;
    }

}
