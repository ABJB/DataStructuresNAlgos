import java.math.BigInteger;

class BigFact{

    public void extraLongFactorials(int n){
        BigInteger fact = BigInteger.valueOf((long)1);
        while(n>1){
            fact = fact.multiply(BigInteger.valueOf(n));
            // System.out.println(n);
            n--;
        }
        System.out.println(fact.toString());
    }
}