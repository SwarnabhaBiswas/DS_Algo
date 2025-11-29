/*rem=0,len=0;  rem = (rem * 10 + 1) % k;
if (rem == 0) return len; the blue logic will create the number with ones. */
public class SmallestIntDivByK {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        int remainder=0;
        int length=0;
        while(true){
            remainder=(remainder*10+1)%k;
            length++;
            if(remainder==0) return length;
        }
    }
}
