package ClassicProblems;

public class MedianOfTwoSortedArraysOfSameSize {

    public static double findMedianSortedArrays(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd){
        if(aEnd - aStart < 0 || bEnd - bStart < 0) return -1;
        if(aEnd - aStart == 0 && bEnd - bStart == 0) return (1.0) * (a[0] + b[0])/2;
        if(aEnd - aStart == 1 && bEnd - bStart == 1) return (1.0) * (Math.max(a[aStart], b[bStart]) + Math.min(a[aEnd], b[bEnd]))/2;
        double m1 = findMedian(a, aStart, aEnd);
        double m2 = findMedian(b, bStart, bEnd);

        if(m1 == m2) return 1.0 * m1;
        //if m1 < m2, then median lies between a[m1--end] and b[start--m2]
        //else median lies between a[start--m1] and b[mid--end]
        if(m1 < m2){
            if((aEnd - aStart) % 2 == 0){
                aStart = aStart + (aEnd - aStart) / 2;
                bEnd = bStart + (bEnd - bStart) / 2;
            }else{
                aStart = aStart + (aEnd - aStart) / 2;
                bEnd = bStart + (bEnd - bStart) / 2 + 1;
            }
        }
        else{
            if((bEnd - bStart) % 2 == 0){
                aEnd = aStart + (aEnd - aStart) / 2;
                bStart = bStart + (bEnd - bStart) / 2;
            }else{
                aEnd = aStart + (aEnd - aStart) / 2 + 1;
                bStart = bStart + (bEnd - bStart) / 2;
            }
        }
        return findMedianSortedArrays(a, b, aStart, aEnd, bStart, bEnd);
    }

    private static double findMedian(int[] arr, int start, int end){
        if((end - start) % 2 == 0){
            return 1.0 * (arr[(start + end) / 2] + arr[(start + end) / 2 - 1]);
        }else return (1.0) * arr[(start + end) / 2];
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {6,7,8,9,10};
        //[1,2,3,4,5,6,7,8,9,10]

        System.out.println(findMedianSortedArrays(a, b, 0, a.length - 1, 0, b.length - 1));

    }
}
