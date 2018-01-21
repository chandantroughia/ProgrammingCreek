package leetcodeTop100Liked;

public class ContainerWithMostWater {

    private static int maxArea(int[] height) {
        if(height.length == 0 || height == null) return -1;
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            maxArea = Math.max(maxArea, (Math.min(height[left], height[right]) * Math.abs(right - left)));
            if(left < right){
                left++;
            }else{
                right++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {3, 1, 2, 4, 5};
        System.out.println(maxArea(height));
    }

}
