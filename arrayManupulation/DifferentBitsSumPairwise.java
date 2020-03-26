import java.util.ArrayList;

class DifferentBitsSumPairwise{

    /**
     *  Problem : 
     *              We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. 
     *              For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. 
     *                          The first and the third bit differ, so f(2, 7) = 2.

                    You are given an array of N positive integers, A1, A2 ,…, AN. 
                    Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
     */




    public int solve(ArrayList<Integer> A){

        int largestNum = Integer.MIN_VALUE;

        for(Integer num : A){
            if(largestNum<num){
                largestNum=num;
            }
        }
        int []zeroCount=new int[Integer.toBinaryString(largestNum).length()], oneCount = new int[Integer.toBinaryString(largestNum).length()];


        for (Integer num : A){
            StringBuilder s = new StringBuilder(Integer.toBinaryString(num));
            int bitPlace =0;
            
            for(Character ch : s.reverse().toString().toCharArray()){
                if(ch=='1'){
                    oneCount[bitPlace]++;
                }else{
                    zeroCount[bitPlace]++;
                }
                bitPlace++;
            }
            while(bitPlace<zeroCount.length){
                zeroCount[bitPlace]++;
                bitPlace++;
            }
        }

        long answer = 0;
        for(int i=0;i<zeroCount.length;i++){
            int zero=zeroCount[i], one= oneCount[i];
            answer = (answer%1000000007 + ((long)zero*one)%1000000007)%1000000007;
        }
        return (int)(answer*2)%1000000007;
     }
}