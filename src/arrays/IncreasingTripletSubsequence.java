package arrays;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++) {
            int z = nums[i];
            if(x >=z) {
                x = z;
            }else if (y >=z) {
                y =z;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
