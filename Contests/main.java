import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
 
public class main {
 
     static class FastReader {
         BufferedReader br;
         StringTokenizer st;
 
         public FastReader() {
             br = new BufferedReader(new InputStreamReader(System.in));
         }
 
         String next() {
             while (st == null || !st.hasMoreElements()) {
                 try {
                     st = new StringTokenizer(br.readLine());
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             return st.nextToken();
         }
 
         int nextInt() {
             return Integer.parseInt(next());
         }
 
         long nextLong() {
             return Long.parseLong(next());
         }
 
         double nextDouble() {
             return Double.parseDouble(next());
         }
 
         String nextLine() {
             String str = "";
             try {
                 str = br.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return str;
         }
     }
 
     static long gcd(long a, long b) {
         if (a == 0)
             return b;
         return gcd(b % a, a);
     }
 
     
 
     
 
     public static void main(String[] args) {
         out = new StringBuilder();
         in = new FastReader();
         int n = in.nextInt();
         String  s = in.next();
         String  temp;
         int count []=new int[26];
         for(int i=2;i<=n;i++){
             for(int j=0;j<n-i;j++){
                 temp = s.substring(j,i+j);
                 for(int k = 0;k<temp.length();k++){
                     count[temp.charAt(k)-97]++;
                 }
                 boolean dec =false;
                 for(int k=0;k<26;k++){
                     if(count[k]>temp.length()/2){
                         dec =true;
                         break;
                     }
                 }
                 if(!dec){
                     System.out.println("YES");
                     System.out.println(temp);
                     return;
                 }
             }
         }
         System.out.println("NO");
     }
}
 