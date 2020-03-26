import java.util.List;

class NonDivisibleSubset{
    public int nonDivisibleSubset(int k , List<Integer> s){
        for(int i=0;i<s.size();i++){
            s.set(i, s.get(i)%k);
        }

        int []arr = new int[k];
        for(int i=0;i<s.size();i++){
            arr[s.get(i)]+=1;
        }

        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        int answer = (arr[0]>0)?1:0;
        for(int i=1;i<k/2;i++){
            answer+=Math.max(arr[i], arr[k-i]);
            // System.out.println(answer);
        }
        if(k%2==0 && arr[k/2]>0){
            answer++;
        }
        if(k%2==1 && k/2>0){
            answer+=Math.max(arr[k/2], arr[(k/2)+1]);
        }
        // System.out.println(answer);
        return answer;
    }
}