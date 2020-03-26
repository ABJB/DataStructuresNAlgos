import sun.font.TrueTypeFont;

class Heap2{

    int data[], size;
    public Heap2(int max_size){

        data = new int[max_size];
        size=0;
    }

    public boolean isEmpty(Heap2 heap2){

        return (heap2.size==0)?true:false;
    }


    // Add element

    public void addElement(int value){


        if(isEmpty(this)){
            data[size+=1] = value;
            return;
        }
        data[size+=1] = value;
        traverseUp(size);
    }
    public void traverseUp(int index){
        while(index>0 && data[index/2]<data[index]){
            swapElements(index, index/2);
        }
    }

    public void swapElements(int i1,int i2){
        int temp=data[i2];
        data[i2] = data[i1];
        data[i1] = temp;
    }



    // Delete Elements


    public int Delete(){
        int removed = data[0];
        data[0] = data[size];
        size--;
        traverseDown(0);
        return removed;
    }


    public void traverseDown(int index){
        while(true){
            if(index*2 < size && data[index*2]>data[index]){
                swapElements(index, index*=2);
            }else if(index*2+1 < size && data[index*2+1] >data[index] ){
                swapElements(index, index=index*2 + 1);
            }else{
                break;
            }
        }
    }




    // Peek top element
    public int peek(){
        if(isEmpty(this)){
            return -1; 
        }else{
            return data[0];
        }
    }




    // Heapify
    public void heapify(int []arr){
        for(int i=0;i<arr.length;i++){
            data[i+size] = arr[i];
        }
        size+=arr.length;

        int i=size;
        while(i>=size-arr.length){
            traverseUp(i);
            i--;
        }
    }

}