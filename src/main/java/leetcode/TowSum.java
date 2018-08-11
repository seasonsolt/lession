package leetcode;

public class TowSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int [] nums = new int[10];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 4;
        int [] result = TowSum.twoSum(nums, 6);
        System.out.println(result);
    }
}
