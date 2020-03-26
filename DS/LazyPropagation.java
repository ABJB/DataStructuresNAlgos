import sun.security.util.Length;

class LazyPropagation{

    int []data;
    int []lazy;
    int start ;

    public LazyPropagation(int []arr){
        data=new int[arr.length*2];
        lazy=new int[arr.length];
        start=arr.length-1;
        for(int i=0;i<arr.length;i++){
            data[arr.length+i]=arr[i];
        }
        for(int i=arr.length-1;i>0;i--){
            data[i]=data[i*2]+data[i*2+1];
        }
    }


    public int[] retArr(){
        return data;
    }


    public void updateNode(int index, int value){
        data[index] += value;
        if(index<start){
            lazy[index] += value;
        }
    }

    public void updateUp(int index){
        index>>=1;
        for(int i=index;i>0;i>>=1){
            data[i] = lazy[i<<1]+lazy[i<<1|1]+ data[i<<1]+data[i<<1|1];
        }
    }

    public void updateDown(int index){
        int height = (int)(Math.log(start-1) / Math.log(2) + 1);
        for(int i=height; i>0;i--){
            int p = index>>i;
            if(lazy[p]!=0){
                updateNode(p<<1, lazy[p]);
                updateNode(p<<1|1, lazy[p]);
                lazy[p]=0;
            }
        }
    }



    public void updateLazy(int add, int low, int high){

        low+=start;high+=start;

        while(low<=high){
            if(low==high){
                updateNode(low, add);
            }
            if(low%2==1){
                updateNode(low, add);
                low++;
            }
            if(high%2==0){
                updateNode(high, add);
                high--;
            }
            low/=2;
            high/=2;
        }
        updateUp(low);
        updateUp(high);
    }

    

    public int sumInRange(int low, int high){
        low+=start;high+=start;
        int sum = 0;
        updateDown(low);
        updateDown(high);
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