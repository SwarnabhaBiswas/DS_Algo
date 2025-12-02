/*using hashset and sliding window since we want the difference of 2 indexes of duplicate value to be within k we use sliding window of size k and we iterate over nums and if i exceeds k means it is getting bigger than the window so we remove starting el from the set and then if any duplicate comes while putting data in hashset we return true since we got duplicates in k range.
 */

import java.util.*;
public class DupValueIndexDiffIsK {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
