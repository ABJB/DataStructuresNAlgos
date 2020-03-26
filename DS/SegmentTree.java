import sun.security.util.Length;

class SegmentTree{

    int []data;
    int start ;

    public SegmentTree(int []arr){
        data=new int[arr.length*2];
        start=arr.length;
        for(int i=0;i<arr.length;i++){
            data[arr.length+i]=arr[i];
        }
        for(int i=arr.length-1;i>0;i--){
            data[i]=data[i*2]+data[i*2+1];
        }
    }

    public int updateEle(int index, int value){

        index+=start;
        int oldVal = data[index];
        int toAdd = value-oldVal;

        while(index>0){
            data[index]+=toAdd;
            index/=2;
        }

        return oldVal;
    }

    public int[] retArr(){
        return data;
    }

    public int sumInRange(int low, int high){
        low+=start;high+=start;
        int sum = 0;
        while(low<=high){
            if(low==high){
                sum+=data[low];
                break;
            }
            if(low%2==1){
                sum+=data[low];
                low++;
            }
            if(high%2==0){
                sum+=data[high];
                high--;
            }
            low/=2;
            high/=2;
        }
        return sum;
    }

}