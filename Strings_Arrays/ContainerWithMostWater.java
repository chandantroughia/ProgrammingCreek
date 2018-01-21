package Strings_Arrays;

public class ContainerWithMostWater {

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {3, 1, 2, 4, 5};
        System.out.println(maxArea(height));
    }
}
