import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LargestCoprimeDivisor{




    public int GCD(int a, int b){
        if (b == 0){
            return a;
        }         
        return GCD(b, a % b);  
    }

    public int solve(int A, int B){
        int gcd = GCD(A, B);
        while(gcd != 1){
            A/=gcd;
            gcd=GCD(A, B);
        }
        return A;
    }
}