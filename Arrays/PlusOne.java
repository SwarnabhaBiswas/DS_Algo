//1. Add one from right to left of an array.
//2. If encountered 9 make it 0 and make the prev of the element in the array +1 just like everyone.
//3. If there's only one element and its 9, make the array bigger and return  [1,0]; else +1
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
