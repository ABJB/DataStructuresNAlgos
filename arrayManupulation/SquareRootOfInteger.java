class SquareRootOfInteger{
    /*
        Problem :   
            Given an integar A.
            Compute and return the square root of A.
            If A is not a perfect square, return floor(sqrt(A)).
            DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY



    */
    public int solve(int A){
        if(A == 0){
            return 0;
        }
        long low = 1, high = A;
        long mid = 1;

        while(low<=high && (long)low*low <= A ){
            mid = low+high;
            mid/=2;

            if((long)mid*mid>A){
                high = mid-1;
            }else if((long)mid*mid<A){
                low= mid+1;
            }else{
                return (int)mid;
            }
        }
        return (int)mid;
    }
}