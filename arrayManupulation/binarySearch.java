import java.util.ArrayList;

class binarySearch{


    /*
        Problem : 
        Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.
        Your algorithm’s runtime complexity must be in the order of O(log n).
        Return an array of size 2, such that first element = starting position of B in A and 
                                            second element = ending position of B in A, 
                                            if B is not found in A return [-1, -1].
    */
    public ArrayList<Integer> solve(ArrayList<Integer> arr , int ele){
        int start  = 0, end = arr.size()-1;
        ArrayList<Integer>ret = new ArrayList<Integer>();
        int mid=-1;
        ret.add(-1);
        ret.add(-1);
        while(start<=end && arr.get(start)<=ele){
            
            mid = start+end;
            mid/=2;

            
        
            if(arr.get(mid)>ele){
                end = mid-1;
            }else if(arr.get(mid)<ele){
                start = mid+1;
            }else{
                
                
                ret.set(0,mid);
                end = mid -1;
            }
        }
        start = 0;
        end = arr.size()-1;
        while(start<=end && arr.get(start)<=ele){
            
            mid = start+end;
            mid/=2;

            
        
            if(arr.get(mid)>ele){
                end = mid-1;
            }else if(arr.get(mid)<ele){
                start = mid+1;
            }else{
                
                
                start = mid +1;
                ret.set(1,mid);
            }
        }
        
        return ret;
    }
}