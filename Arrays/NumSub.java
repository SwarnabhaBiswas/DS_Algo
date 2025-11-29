/*1513. Number of Substrings With Only 1s
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.
Example 2:

Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s. */
//Sol - It basically follows a increment as well as addition formula. For a substring of a given length 'n', number of substrings is n(n+1)/2. Either use this formula for only the group 1's in the binary number and calculate when faced with 0 else use the pre-increment operator to calculate it just like the expanded version of sormula i.e. if n=4, 1+2+3+4. maintain a result variable and add preincrement of the counter value if countered with 1. count=1, result=1, counterd 0, do nothing, countered 1 count=2,result=3 and so on. 
class NumSub {
    public int numSubs(String s) {
        long answer = 0;
        long count = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                answer += (count * (count + 1)) / 2;
                answer %= mod;
                count = 0;
            }
        }
        answer += (count * (count + 1)) / 2;

        return (int)(answer % mod);
    }
}
