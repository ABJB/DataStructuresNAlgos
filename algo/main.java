import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.math.BigDecimal;
import java.util.*;
import java.util.Collection;



class node{
    int val;
    node next;
}




// Definition of Interval Class
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
 
class driver{
    static Scanner in;
    public  static node get_list(){
        // System.out.println("Enter the size of the list");
        int n = in.nextInt();
        node start = new node();
        start.val = in.nextInt();
        node tra = start;
        while(n>1){
            node newNode = new node();
            newNode.val = in.nextInt();
            tra.next = newNode;
            n--;
            tra = tra.next;
        }
        return start;
    }
    public static int[] get_array(){
        // System.out.println("Enter the size of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static ArrayList<Integer> get_arrList(){
        // System.out.println("Enter the size of the array");
        int n = in.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i=0;i<n;i++){
            arr.add(i, in.nextInt());
        }
        return arr;
    }

    public static ArrayList<String> get_arrList_str(){
        // System.out.println("Enter the size of the array");
        int n = in.nextInt();
        ArrayList<String> arr = new ArrayList<String>(n);
        for (int i=0;i<n;i++){
            arr.add(i, in.next());
        }
        return arr;       
    }



    public static void print_arrList(ArrayList arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+ " ");
        }
    }

    public static void print_array(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void print_list(node head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    

   
    
    
    
    public static void main(String args[]){

        in = new Scanner(System.in);
        GridLandProvinces solver = new GridLandProvinces();
        System.out.println(solver.stringTotalRotationalReversalPermutation(in.nextLine()));
    }

}
