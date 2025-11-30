import java.util.HashMap;
//extract the element occuring once
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<nums.length;i++){
            int count =1;
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],count);
            }
         }
         for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
                return nums[i];
            }
         }
         return -1;
    }
}
//can be done using single space complexity by using XOR
// what xor does is is there 2 same number it will be 0 other wise it will be the same number. [2,3,2,4,4] so we will do 2^3^2^4^4 XOR of 2 and 3 will be 001 i.e 1 and 1 XOR 2 will be 011 i.e 3. here we can see the two same reoccuring elements 2,2 got cancelled and 3 in between them is safe.
/*
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;        
    }
} */