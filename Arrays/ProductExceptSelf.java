//We take 2 arrays prefix/suffix or left/right. One calculates the left side product of each element and other vice versa. Like in left[i] it will have the product for all the left side element for the mainArray[i] i.e if el index is 3 then left[3] will have mainArrray[0] *mainArrray[1]*mainArrray[2]. same for right array. left[i]=left[i-1]*mainArray[i-1]. then at last ans[i]=left[i]*right[i].  
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }

        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            answer[i]=left[i]*right[i];
        }

        return answer;
    }
}
