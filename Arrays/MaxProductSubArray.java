//Observations
/*
1. if all +ve number then whole array multiplies is answer
2. if even negative numbers and rest positive wjhole array multiplies is answer
3. so in 1st intituion we can see negative numbers are the problem so we can think like taking a prefix product as well as from the back a suffix product. what we can do is divide the whole array at the points it has negative numbers. like while calculating prefix(start to end) when we encounter 1 negative number,and the product before that is a subarray and after that is another subarray, same for suffix.
4. But if we observe closely negative numbers arent the problem since we are tracking a max variable it will not let any smaller values or negative values to come in. if there are even negative it will calculate either in prefix or suffix and update max, so we need to track the elements with value 0 in it since it will make the whole answer 0 even if it positive or negative.
5. So we will track the product of array from start to end using prefix and end to staret using suffix. Whenever we see the suffix is 0 means it got multiplied with a 0 hence we need to change the value again to 1 which is also a kind of partition of subarray. this will be same for the prefix array. We will track a max value where we will compare the older max with max of prefix or suffix.
 */
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-i-1];
            
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}
