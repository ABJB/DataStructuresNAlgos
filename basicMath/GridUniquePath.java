class GridUniquePath{
    public int solve(int A, int B){
        if(A==1 || B == 1){
            return 1;
        }
        // int ans = 0, left =0;
        int []pre = new int[B];
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                if(j==0){
                    pre[0]=1;
                }else{
                    pre[j]+=pre[j-1];
                }
            }

        }
        return pre[B-1];
    }
}