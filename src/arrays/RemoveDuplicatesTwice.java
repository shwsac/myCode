package arrays;

public class RemoveDuplicatesTwice {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;
        int repetitionCount = 0;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                repetitionCount = 0;
            } else if (repetitionCount == 0 && nums[i] == nums[j]) {
                i++;
                nums[i] = nums[j];
                repetitionCount++;
            }
            j++;
        }

        return i + 1;
    }

}
