/*[[1,0],[2,0],[3,0],[2,2],[3,2]]
the specefic feature of trapezoid is that 2 lines are horizontal to each other in a quadritic shape. i.e two lines are parallel to x axis that means points with  same y axis will be parallel to each other.
1. Similar y points different x have parallell horizontal lines
2. Number of lines from n number of points can be created is nC2 since we need to points to create a line thats why nC2.
3. Number of trapezoid between no. of horizontal lines from one x1,y1 lets say c1 and number of horizontal lines in different x2,y2 let say c2 is c1*c2.
4. If there are multiple rows of horizontal lines the number of trapezoid first row with c1 horizontal lines will 0 trapezoids since there are no other points above it. c2 below it will make c2*c1. c3 below it will generate (c1+c2)*c3;
5. In this solution we actually store the count of y variables in hashmap with similar y point as key and their count in different points as values.
Then we store the values with count more than 2 or equal to 2 in an array since  extracting all values from map and calculating it excedded the limit and gave wrong output. and below 2 same y points dont matter as they cant create a line.
then we initiate 2 variables sum and ans, here sum will calculate the sum of horizontal lines as we go through and ans will calculate the product of those horizontal lines. 
*/

import java.util.*;
public class CountNumberOfTrapezoid{
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007L;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }
        ArrayList<Long> seg = new ArrayList<>();
        for (long k : map.values()) {
            if (k >= 2)
                seg.add((k * (k - 1) / 2) % MOD);
        }
        long sum = 0, ans = 0;
        for (long v : seg) {
            ans = (ans + v * sum) % MOD;
            sum = (sum + v) % MOD;
        }
        return (int) ans;
    }
}