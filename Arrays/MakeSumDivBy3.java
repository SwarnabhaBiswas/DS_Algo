/*This question uses a common principle of 
in prefix sum array if subarray x divided by k gives remainder y and also z divided by k also gives remainder y, then we can say that subarray x - subarray z %k==0.
target=total sum of array % p (since removing the sum equal to this element or elements will make the array divisible by p)
In this question we will be tracking the derived formula of 
prev-curr=target;
here prev is one subarray and curr is another, our goal is to find a subarray that has a sum equal to target. so thik of it like as prev and curr both gives same remainder when divided by the same number, that dosent mean they have the same sum but they can generate me the target i want. here i have the target and the cummulative freq (the prefix sum) i dont have the subarray that makes this possible.
I now keep calculating the cummulative array i.e. pref=(pref+nums[i])%k we keep remainder to keep the value short.
so i keep on using the formula neededSubarraySum=(prev-target+k)%k (+k to deal with negative numbers when using modulo) and store the prefix with the index value we are on.
but we do this with a check in between
It checks if the neededSubArraySum is already there in the HashMap(since we are using modulo of each number so all are in their simplest form) we take that subArrays index stored in hashMap as i and the index we are on as j. The length of subarray that will give the sum equal to target as per the formula since i is sum till i and j is sum till j. The length will be j-i.
if this length's value is minimum to previous minimum value update it or leave it.
*/

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivBy3{
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;

        long target = total % p;
        if (target == 0) return 0;

        Map<Integer, Integer> mMap = new HashMap<>();
        mMap.put(0, -1);

        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int neededSubArrSum = (int)((prefix - target + p) % p);

            if (mMap.containsKey(neededSubArrSum)) {
                res = Math.min(res, i - mMap.get(neededSubArrSum));
            }

            mMap.put((int)prefix, i);
        }

        return res == nums.length ? -1 : res;
    }
}