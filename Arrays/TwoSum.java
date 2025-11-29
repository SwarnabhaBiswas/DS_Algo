//Simple change in for loops taking i as 1 to arr.length and and j as i-1 to arr.length. Comparing arr[j]+arr[j-1]=target. This helps in not repeating the comparision.
class TwoSum {
    public int[] twosum(int[] nums, int target) {
        for(int i = 1; i < nums.length; i++){
         for(int j = i; j < nums.length; j++){
            if(nums[j] + nums[j-i] == target)
            return new int[]{j, j-i};
         }
       }
       return new int[]{-1, -1};
    }
}