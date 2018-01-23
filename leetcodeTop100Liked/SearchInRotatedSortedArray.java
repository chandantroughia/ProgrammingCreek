package leetcodeTop100Liked;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] <= nums[high]){
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 5 ));
    }
}
