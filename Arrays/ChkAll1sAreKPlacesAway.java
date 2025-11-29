//1. Can use a count variable that counts when it encounters 0, and when it encounters 1 it will check with another if that if count<k, if yes set result to false otherwise make count 0 since count would have equal or greater than k. 2. Use 2 pointers. start prev with -1 and res with true, when it encounters 1st '1' make it 'i', when 'i' encounters '1' again it checks if prev isn't -1 & i-prev-1<k then false.
public class ChkAll1sAreKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int count=k;
        boolean res=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            if(nums[i]==1){
                if(count<k){
                    res=false;
                    break;
                }
                count=0;
            }
        }
        return res;
    }
}
