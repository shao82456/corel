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

    public static void main(String[] args) {
        Solution sol=new Solution();
        int res=sol.firstBadVersion(2126753390);
        System.out.println(res);
    }
}
