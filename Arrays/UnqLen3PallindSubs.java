//Use a HashSet for char, result=0 and first,last=-1. iterate over char a to char z and track a letters first and last occurrence with another loop for the string. Keep the 1st occurence index in first and  last's in last. Check if  first==-1 or first==last which means there is either no occurence or less than 2 occurrence of a letter. start a loop from first+1 since we dont want to include the starting letter till < last and add those letters in middle in a hashSet since it only takes unique values, repetitive letter dosent get added. add the size of hashSet to the result at last. and in the end return result.
import java.util.HashSet;
public class UnqLen3PallindSubs{
    public int countPalindromicSubsequence(String s) {
        int result = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = -1;
            int last = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    if (first == -1){
                        first = i; 
                    }  
                    last = i;                    
                }
            }

            if (first == -1 || first == last) continue;

            HashSet<Character> midChars = new HashSet<>();

            for (int i = first + 1; i < last; i++) {
                midChars.add(s.charAt(i));
            }

            result += midChars.size();
        }

        return result;
    }
}