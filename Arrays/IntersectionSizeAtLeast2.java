//since the question asks to check for how many digits we require to satisfy the condition i.e no. of least possible digits to satisfy each interval of numbers. We first sort the 2-D array on the basis of 2nd interval in ascending and if 2 intervals are equal we sort on basis of 1st interval in descending. Then we take the last and 2nd last digits from 1st interval array, and then check for them if they exist in the 2nd interval. we check for both largest and 2nd largest, if both are present no need to count digits, if one of them is present, add +1 to count and interchange the variable of largest and 2nd largest to the new intervals, and if both are not present add +2 to count since the qustion asked for atmost 2.                                                                            
import java.util.Arrays;
public class IntersectionSizeAtLeast2{
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) ->
            x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]
        );

        int a = -1; // largest point
        int b = -1; // second largest
        int count = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end   = interval[1];

            boolean hasA = (a >= start); // correct interval check
            boolean hasB = (b >= start); // FIXED

            // CASE 1: both inside
            if (hasA && hasB) {
                continue;
            }
            // CASE 2: exactly one inside
            else if (hasA || hasB) {

                count++;

                // only a is inside
                if (hasA) {
                    b = a;
                    a = end;
                } 
                // only b is inside
                else {
                    b = a;  // shift
                    a = end;
                }
            }
            // CASE 3: none inside
            else {
                count += 2;
                b = end - 1; // second largest
                a = end;     // largest
            }
        }

        return count; // MOVED OUTSIDE LOOP
   
        // Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // HashSet<Integer> set = new HashSet<>();

        // for(int[] interval :intervals){
        //     int start=interval[0];
        //     int end=interval[1];

        //     int count=0;
        //     for(int x:set){
        //         if(x>=start && x<=end){
        //             count++;
        //         }
        //     }
        //     int add=2-count;
        //     int e=end;

        //     while(add>0){
        //         if(!set.contains(e)){
        //             set.add(e);
        //             add--;
        //         }
        //         e--;
        //     }
        // }
        // return set.size();
    }
}