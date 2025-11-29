//Can use HashMap, but used a switch statement to assign all character their integer values. Run a loop for i to str length, find current, check if i+1 isn't outOfBounds, find next. If the current element is smaller than next element, answer-=current otherwise answer+=current. And last is always added to answer, so put a else since if will not exceute on last el due to i+1.
public class RomantoInteger {   
    public static int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int result =0;
        for(int i=0;i<s.length();i++){
            int curr= getValue(s.charAt(i));
            if(i+1<s.length()){
                int next=getValue(s.charAt(i+1));
                if(curr<next){
                    result-=curr;
                }
                else{
                    result+=curr;
                }
            }
            else{
                result+=curr;
            }
        }
        return result;
    }
}
