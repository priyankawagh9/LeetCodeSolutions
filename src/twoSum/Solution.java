package twoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int nextNum = 0;
        for(int i=0;i<nums.length;i++) {
            nextNum = target - nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if(nextNum == nums[j]) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
            if(indices[0] != 0 && indices[1] != 0)
                break;

        }
        return indices;
    }
}