//Use 2 pointers. Start with i=1, k=1 and check i and i-1, if same then continue if not then place the new element in place of k and increment k. what this will do is lenth of k in the array will have unique elments only.
class RemoveDuplicates {
    public int removeDup(int[] nums) {
        int k=1;
        for(int i=1; i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}