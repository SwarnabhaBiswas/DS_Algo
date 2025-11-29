//create prefix sum array. Start a loop from (start)0 to k-1 since we are using loop inside loop and the inner loop will chck for all the possibilities hence we traverese till k-1. assign start variable to I and start  a while loop until i<n and i+k-1 is less than n. i+k-1 is actually the last index when we are creating a subarray of length k. from the prefix sum extract the sub array sum and now using kardane's algo check is the currSum is greater than currSum+ subArraysum. and then check if maximum b/w maxSum and currSum. the currSum actually jumps k places and calculates the sub array. at the end to jump assign k to i.
public class MaxSubArrSumOfLenDivByK{
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] preSum=new long[n];

        preSum[0]=nums[0];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+nums[i];
        }

        long result=Long.MIN_VALUE;

        for(int start=0;start<k;start++){
            long currSum=0;
            int i=start;//this is for starting point of sum array
            while(i<n && i+k-1<n){
                int j=i+k-1;//ending point of sum array from prefix sum
                
                long subSum=preSum[j] - ((i>0) ? preSum[i-1] : 0);

                currSum=Math.max(subSum,subSum+currSum);
                result=Math.max(currSum,result);

                i+=k;//jump   
            }
        }
        return result;
    }
}