package leetcodeTop100Liked;

public class MedianOfTwoSortedArrays {

    public static double getMedianSortedArrays(int[] one, int[] two){
        if(one.length > two.length){
            getMedianSortedArrays(two, one);
        }

        int x = one.length;
        int y = two.length;
        int low = 0;
        int high = x;

        while(low <= high){
            int partX = (low + high)/2;
            int partY = (x + y + 1)/2 - partX;

            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : one[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE : one[partX];

            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : two[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : two[partY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y) % 2 == 0){
                    return (double) (Math.max(maxLeftX,maxLeftY) + Math.max(minRightX, minRightY))/2.0;
                }else{
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = partX - 1;
            }else{
                low = partX + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        double median = getMedianSortedArrays(x, y);
        System.out.println(median);
    }
}
