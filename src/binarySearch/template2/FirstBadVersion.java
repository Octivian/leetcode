package binarySearch.template2;

/**
 * 无限逼近
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left<right){
            int mid = (right+left)>>>1;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }

    static boolean isBadVersion(int n){
        return n>38-1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(100));
    }
}
