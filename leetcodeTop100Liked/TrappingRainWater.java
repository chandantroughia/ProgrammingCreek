package leetcodeTop100Liked;

public class TrappingRainWater {

    private static int trap(int[] heights){
        int left = 0;
        int right = heights.length - 1;
        int left_max = 0;
        int right_max = 0;
        int water = 0;

        while(left < right){
            left_max = Math.max(left_max, heights[left]);
            right_max = Math.max(right_max, heights[right]);

            if(left_max < right_max){
                water += left_max - heights[left];
                left++;
            }else{
                water += right_max - heights[right];
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
}
