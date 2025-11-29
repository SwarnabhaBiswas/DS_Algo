//Use sliding window. Length of sliding window is given k. add all elements till length of k and slide the window forwards that remove the sum of first index and add the num at next index. Therefore eq would be sum of window= sum of window - nums[i(which starts from k)] - nums[i-k](that is index 0 at start since we tsart i from k and it moves on).
public class MaxAvgSubArr {
     public double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }
    int maxSum = sum;
    for (int i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k]; 
        maxSum = Math.max(maxSum, sum);
    }

    return (double) maxSum / k;
}
}
