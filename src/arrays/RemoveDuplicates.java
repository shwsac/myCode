package arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
     
         int j = 0;
         int i = 1;
         while(i< nums.length) {
             if(nums[j] == nums[i]) {
                 i++;
             } else {
                 j++;
                 nums[j] = nums[i];
                 i++;
             }
         }
         return j+1;
    }
    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(removeDuplicates(a));

    }

}
