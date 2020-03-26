import java.util.ArrayList;

class RearrangeArray {
    /*
        Problem : 

        Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

        Input : [1, 0]
        Return : [0, 1]
    */


    public int encode(int currVal,int insertVal, int size){
        /*
                Given currVal and insertVal function encodes them to a integer using size value
        */
        if(insertVal == size-1){
            return currVal*(size-1) + insertVal;
        }
        return - currVal*(size-1) - insertVal;
    }

    public int[] decode(int decodedVal, int size){
        /*
                Given a decoded value function returns decoded value
                return array :
                    0: currVal after decoding
                    1: insertVal after decoding 
        */
        int [] dec = new int[2];
        if(decodedVal<=0){
            decodedVal*=-1;
            dec[0] = decodedVal/(size-1);
            dec[1] = decodedVal%(size-1);
        }else{
            dec[0] = (decodedVal-1)/(size-1);
            dec[1] = size-1;
        }
        return dec;
    }
    public void solve(ArrayList<Integer> a) {
        int insVal;

        // Encoding whole array
        for(int i=0;i<a.size();i++){
            if(a.get(i)<i){
                insVal = decode(a.get(a.get(i)), a.size())[0];
            }else{
                insVal = a.get(a.get(i));
            }
            a.set(i, encode(a.get(i), insVal, a.size()));
        }
        
        // Decoding whole array

        for(int i=0;i<a.size();i++){
            a.set(i, decode(a.get(i), a.size())[1]);
        }

    }
}