package arrays;

public class WaterContainer {

    public static int maxArea(int[] height) {
        int minIndex = 0;
        int maxIndex = height.length-1;
        int maxArea = (height.length -1) * Math.min(height[minIndex],height[maxIndex]);
        while(minIndex < maxIndex) {
            if(height[minIndex] <= height[maxIndex]) {
                minIndex++;
            }
            else {
                maxIndex--;
            }
            int tempArea = (maxIndex-minIndex) * Math.min(height[minIndex],height[maxIndex]);
            maxArea = Math.max(tempArea,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] input = {1,7,2,9,1};
        System.out.println(maxArea(input));
    }

}
