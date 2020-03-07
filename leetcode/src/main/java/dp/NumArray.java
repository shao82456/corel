package dp;

public class NumArray {
    //data[i]表示Sum[0,i]
    int[] data;
    public NumArray(int[] nums) {
        data=new int[nums.length];
        if(nums.length>0){
            data[0]=nums[0];
        }
        for(int i=1;i<nums.length;i++){
            data[i]=data[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        //sum[i,j]=sum[0,j]-sum[0,i-1]
        int s1=data[j];
        int s2=0;
        if(i-1>=0){
            s2=data[i-1];
        }
        return s1-s2;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,0,3,-5,2,-1};
        NumArray obj=new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
    }
}
