//1st Approach- For %3 either rem will be 1 or 2. take 2 arrays for remainder 1 and 2. add ll elements of arr and also check if rem==1 add in rem 1 and same for rem2. Now there will be 3 cases. 1. if total sum%3==0 return sum, otherwise if sum%3==1 then either we have to remove the samller one among one element of remainder 1 or 2 elements of remainder 2,and if sum%==2 then remove the smaller one among one element of remainder 2 or 2 numbers of remainder 1. 2nd Approach- DP(from youtube)

public class GrtstSumDivBy2 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] temp = dp.clone();
            for (int i = 0; i < 3; i++) {
                int sum = temp[i] + num;
                dp[sum % 3] = Math.max(dp[sum % 3], sum);
            }
        }
        return dp[0];
    }
}
// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         int sum=0;
//         ArrayList<Integer> rem1=new ArrayList<>();
//         ArrayList<Integer> rem2=new ArrayList<>();
//         for(int num:nums){
//             sum+=num;
//             if(num%3==1){
//                 rem1.add(num);
//             }
//             if(num%3==2){
//                 rem2.add(num);
//             }
//         }
//         Collections.sort(rem1);
//         Collections.sort(rem2);
//         int remove1 = Integer.MAX_VALUE;
//         int remove2 = Integer.MAX_VALUE;

//         if(sum%3==0) return sum;
//         else if(sum%3==1){
//             if(!rem1.isEmpty()) remove1=rem1.get(0);
//             if(rem2.size()>=2) remove2=rem2.get(0)+rem2.get(1);

//             return sum-Math.min(remove1,remove2);
//         }
//         else{
//             if(!rem2.isEmpty()) remove1=rem2.get(0);
//             if(rem1.size()>=2) remove2=rem1.get(0)+rem1.get(1);

//             return sum-Math.min(remove1,remove2);
//         }
//     }
// }

