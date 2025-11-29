//[0,1,1] binary array is given. We need to traverse it from left to right, and store true/false based on the decimal value%5==0 till that index. If we are at index 1, i.e. 0,1 so binary to decimal will be 2^1*0+2^0*1 i.e 3 therefore ans[1]=false; in the example only index 1 will have a true value.sum=(sum*2+num)%5; It is that for a number to be divisible by any number only its remainder matters. Like 3%5=3 which is same as 8%5=3. here 3=5*0+3, 8=5*1+3. we can see that rem 3 is always constant so why take the whole number and do big computations. so storing just the remainder in sum is same as the whole number since we are computing mod values.

import java.util.ArrayList;
import java.util.List;

public class BinPreDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> answer=new ArrayList<>();
        int sum=0;
        for(int num:nums){
            sum=(sum*2+num)%5;
            answer.add(sum==0);
        }
        return answer;
    }
}
