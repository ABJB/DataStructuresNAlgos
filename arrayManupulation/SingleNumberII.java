import java.util.ArrayList;

class SingleNumberII{

    /**
     *      Problem : 
     *          Given an array of integers, every element appears thrice except for one which occurs once.
                Find that element which does not appear thrice.
                Note: Your algorithm should have a linear runtime complexity.
                Could you implement it without using extra memory?
     */


     public int solve(ArrayList<Integer> A){

        int ans = 0;
        int index;
        // int bits[]=new int[31];
        for(int j=0;j<31;j++){
            int oneCount=0;
            for(Integer val : A){
                String st = Integer.toBinaryString(val);
                if(st.length()>j && st.charAt(st.length()-1- j)=='1'){
                    oneCount++;
                }

            }
            // bits[j]=oneCount;
            if((oneCount-1)%3==0){
                ans += (int)Math.pow(2, j);
            }
        }
        // System.out.println(Integer.toBinaryString(8));
        return ans;

     }
}