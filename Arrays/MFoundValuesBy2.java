//Use a boolean var, starting with true. Start a while for boolean, make the boolean false, find the original if found, double it and break out of loop. It runs until it dosent find any original int and due to boolean false loop dosent run and returns original.
public class MFoundValuesBy2 {
    public int findFinalValue(int[] nums, int original) {
        boolean found = true;
        while (found) {
            found = false;
            for (int num : nums) {
                if (num == original) {
                    original *= 2;
                    found = true;
                    break;
                }
            }
        }
        return original;
    }
}
