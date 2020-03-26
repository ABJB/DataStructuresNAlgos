import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class MinXorValue{
    /**
            Problem : 
                Given an integer array A of N integers,
                find the pair of integers in the array which have minimum XOR value.
                Report the minimum XOR value.       
     */

    
    public int solve(ArrayList<Integer> A){
        Collections.sort(A);
        int minXOR = Integer.MAX_VALUE;
        int b = 1^2;

        for(int i=1;i<A.size();i++){
            if((A.get(i).intValue() ^ A.get(i-1).intValue()) < minXOR){
                minXOR = A.get(i).intValue() ^ A.get(i-1).intValue();
            }
        }

        return minXOR;

    }
}