class Heap{
    int data[];
    int lastPos;

    public Heap(){
        data = new int[50];
        lastPos=0;
    }
    public Heap(int []arr){
        data=new int[50];
        lastPos=0;
        int i=0;
        while(i<arr.length){
            addElement(arr[i++]);
        }    
    }

    public void heapify(int arr[]){
        lastPos=1;

        while(lastPos-1<arr.length){
            data[lastPos]=arr[lastPos-1];
            ++lastPos;
        }
        --lastPos;


        int i = lastPos;

        while(i>0){
            if((i<<1)<=lastPos){
                if(data[compareChildren(i)]>data[i]){
                    int i2 = compareChildren(i);
                    swapElement(i,i2);
                    adjustTop(i2);
                }
            }
            i--;
        }
    }


    public void addElement(int val){
        lastPos++;
        data[lastPos]=val;
        if(lastPos==1){
            return;
        }
        // Moving up to root of DS till there is proper place for appended element is found.
        int i=lastPos;
        while((i>>1)>0){
            if(data[i>>1]<data[i]){
                swapElement(i,i>>=1);
            }else{
                break;
            }
        }
    }

    public void removeTop(){
        data[1] = data[lastPos];
        lastPos--;
        adjustTop(1);
    }


    public void adjustTop(int topIndex){
        int i = topIndex;
        while((i<<1)<=lastPos  && data[i]<data[compareChildren(i)]){
            i=compareChildren(i);
            swapElement(i, i>>1);
        }
    }

    // UTIL Functions



    public void swapElement(int index1, int index2){
        int temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }

    public int compareChildren(int index){
        if((index<<1|1)>lastPos){
            return index<<1;
        }
        if(data[index<<1]>data[index<<1|1]){
            return index<<1;
        }
        return index<<1|1;
    }

    public int[] returnDS(){
        return data;
    }
}