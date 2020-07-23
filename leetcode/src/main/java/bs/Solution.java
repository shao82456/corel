package bs;

public class Solution {
    public boolean isBadVersion(int version){
        if(version>=1702766719){
            return true;
        }else{
            return false;
        }
    }

    public int firstBadVersion(int n) {
        long l=1,r=n;
        while (l<=r){
            int m= (int) ((l+r)/2);
            if(isBadVersion(m)){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return (int) l;
    }

    public int binarySearch(int nums[], int l, int r, int x) {
        while (l<=r) {
            int mid = (l + r) / 2;
            if (nums[mid] > x)
                r = mid - 1;
            else if (nums[mid] < x)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        int res=sol.firstBadVersion(2126753390);
//        System.out.println(res);
        int[] arr=new int[]{1,2,3,3,4,5,5};
        int idx=sol.binarySearch(arr,0,arr.length-1,1);
        System.out.println(idx);
    }

    //*旋转数组中搜索
    public int search(int[] nums, int target) {
        return _search(nums,0,nums.length-1,target);
    }

    private int _search(int[] nums,int l,int r, int target) {
        int left=l,right=r;
        while(l<=r){
            int m=(l+r)/2;
            if(target==nums[m]){
                return m;
            }else if(nums[l]<nums[m]){
                if(m-1>=left&&target>=nums[l]&&target<=nums[m-1]) {
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else{
                if(m+1<=right&&target>=nums[m+1]&&target<=nums[r]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return -1;
    }

   public  boolean search2(int[] nums,int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(target==nums[m]){
                return true;
            }else if(nums[l]<nums[m]){
                if(target>=nums[l]&&target<=nums[m]) {
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else if(l!=m&&nums[l]==nums[m]){
                if(m+1<nums.length&&nums[m+1]==nums[r]){
                    for(int i=l;i<=r;i++){
                        if(nums[i]==target) {
                            return true;
                        }
                    }
                    return false;
                }else if(m+1<nums.length){
                    l=m+1;
                }else{
                    return false;
                }
            }else{
                if(m+1<nums.length&&target>=nums[m+1]&&target<=nums[r]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return false;
    }

    private int bs(int[] nums,int l,int r,int target){
        while (l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return -1;
    }
}

