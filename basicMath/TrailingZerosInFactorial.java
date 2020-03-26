class TrailingZerosInFactorial {

    /*
        Problem :

            Given an integer n, return the number of trailing zeroes in n!.
    */


    public int solve(int A){
        int tenCount = 0, fiveCount = 0;
        for(int i=1;i<A+1;i++){
            if(i%5 == 0){
                int j= i;
                while(j%5==0){
                    fiveCount++;
                    j/=5;
                }
            }
        }
        return fiveCount;
    }

    public int solveEfficient(int A){
        int fiveCount = 0;

        int valON = 5, valONFiveCount = 1;
        while(valON<= A){
            int multiplier = 0;
            while((multiplier+1)*valON <A+1){
                multiplier++;
            }
            fiveCount += multiplier;
            valON*=5;
            valONFiveCount+=1;
            // System.out.println(multiplier);
        }
        return fiveCount;
    }
}
 