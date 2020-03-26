class RotatedSortedArraySearch{

        /*
            Problem :
                        Given an array of integers A of size N and an integer B.
                    array A is rotated at some pivot unknown to you beforehand.
                    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
                    You are given a target value B to search. If found in the array, return its index, otherwise return -1.
                    You may assume no duplicate exists in the array.
        */
    public int solve(final int []A, int B){


        //finding pivot point i.e. smallest element
        int pivot = 0;

        for(int i=1;i<A.length;i++){
            if(A[i-1]>A[i]){
                pivot = i;
            }
        }


        // Pretending to binary search a sorted array

        int start = pivot, end = pivot+A.length-1;
        int mid = -1;
        while(start<=end){
            mid = start+end;
            mid/=2;

            if(A[mid%A.length] > B){
                end = mid-1;
            }else if(A[mid%A.length] < B){
                start = mid+1;
            }else{
                return  mid%A.length;
                // break;
            }
        }

        return -1;

    }
}