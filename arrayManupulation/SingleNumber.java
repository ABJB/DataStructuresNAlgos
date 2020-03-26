class SingleNumber{

    /**
     *      Problem : 
     *                  Given an array of integers, every element appears twice except for one. Find that single one.

                        Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * 
     * 
     */

     public int solve(ArrayList<Integer> A){
         int ans = 0;


         for(Integer num : A){
             ans ^= num;
         }
         return ans;
     }
}