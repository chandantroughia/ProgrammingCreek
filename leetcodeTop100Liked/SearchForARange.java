package leetcodeTop100Liked;


/*
*
* Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
* Your algorithm's runtime complexity must be in the order of O(log n).
* If the target is not found in the array, return [-1, -1].
* For example,
* Given [5, 7, 7, 8, 8, 10] and target value 8,
* return [3, 4].
*
* */
public class SearchForARange {


    public static int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }

    private static int findStart(int[] nums, int target){
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    private static int findEnd(int[] nums, int target){
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        printArray(result);
    }
}
