import java.util.ArrayList;

class MaxSPProd{


    /**
        Problem : 
                You are given an array A containing N integers.
                The special product of each ith integer in this array is defined as the product of the following:<ul>

                
                LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j).
                                  If multiple A[j]’s are present in multiple positions, the LeftSpecialValue 
                                  is the maximum value of j.
                RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i).
                                   If multiple A[j]s are present in multiple positions, the RightSpecialValue 
                                   is the minimum value of j.


                Write a program to find the maximum special product of any integer in the array.

                Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9

     */

    public long LeftMaxSPProduct(ArrayList<Integer> A){
        int maxEleTillNow = A.get(0);
        long maxProduct = 0;
        for(int i=1;i<A.size(); i++){
            if(maxEleTillNow > A.get(i) &&  (long)maxEleTillNow*A.get(i) > maxProduct){
                maxProduct=(long)maxEleTillNow*A.get(i);
            }
            if(maxEleTillNow<A.get(i)){
                maxEleTillNow = A.get(i);
            }
        }        
        return maxProduct;
    }


    public long RightMaxSPProduct(ArrayList<Integer> A){
        int maxEleTillNow = A.get(A.size()-1);
        long maxProduct = 0;

        for(int i=A.size()-2;i>-1;i--){
            if(maxEleTillNow>A.get(i) && (long)maxEleTillNow*A.get(i)> maxProduct){
                maxProduct = (long)maxEleTillNow*A.get(i);
            }
            if(maxEleTillNow< A.get(i)){
                maxEleTillNow = A.get(i);
            }
        }
        return maxProduct;
    }
    public int solve(ArrayList<Integer> A){
        long lp = LeftMaxSPProduct(A), rp = RightMaxSPProduct(A);
        return  (lp>rp?(int)(lp%1000000007):(int)(rp%1000000007));
    }
}