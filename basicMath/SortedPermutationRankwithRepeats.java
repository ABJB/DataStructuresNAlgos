import java.util.HashMap;

class SortedPermutationRankwithRepeats{



    /*
        Problem :

            Given a string, find the rank of the string amongst its permutations sorted lexicographically.
            Note that the characters might be repeated. If the characters are repeated, we need to look at
            the rank in unique permutations.
            
            EG :
                    Input : 'aba'
                    Output : 2

                    The order permutations with letters 'a', 'a', and 'b' : 
                    aab
                    aba
                    baa
    
    */

    public int factorial(final int n) {
        if (n == 1|| n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public HashMap<Character, Integer> frequncyCount(final String a){
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (final Char ch : a.toCharArray()){
            if(freq.containsKey(ch)){
                freq.replace(ch, freq.get(key),1+freq.get(key));
            }else{
                freq.put(ch, 1);
            }
        }
        return freq;
    }

    public int positionSolve(String a, HashMap<Character, Integer> freqCount) {
        final int firstVal = (int) a.charAt(0);
        int lessCount = 0;
        int totalEle = -1;
        int denominator = 1;
        int freq;
        for (Character ch : freqCount.keySet()){
            freq = freqCount.get(ch);
            totalEle+=freq;
            denominator *= factorial(freq);
            if((int)ch<firstVal){
                lessCount++;
            }
        }
        freqCount.replace(a.charAt(0), freqCount.get(a.charAt(0)), freqCount.get(a.charAt(0)));
    }

    public int solve(final String A) {
        HashMap<Character, Integer> freqCount = frequncyCount(A);

    }

}