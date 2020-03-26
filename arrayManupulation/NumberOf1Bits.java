class NumberOf1Bits{
    /**
     *      Problems : 
     *                  Write a function that takes an unsigned integer and returns the number of 1 bits it has.
     */

     public int solve(long a){
        int pow = 62;
        long nearestPow = (long)Math.pow(2, pow);
        int oneCounter = 0;
        while(a>0 && pow>-1){
            if(a/nearestPow != 0){
                oneCounter++;
                a-=nearestPow;
            }
            nearestPow>>=1;
            pow--;
        }
        return oneCounter;
     }
}