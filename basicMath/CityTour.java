import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class CityTour{

    /*
        Problem : 

                There are A cities numbered from 1 to A. You have already visited M cities,
                the indices of which are given in an array B of M integers.If a city with 
                index i is visited, you can visit either the city with index i-1 (i >= 2) or
                the city with index i+1 (i < A) if they are not already visited.
                
                Eg: if N = 5 and array M consists of [3, 4], then in the first level of 
                moves, you can either visit 2 or 5.You keep visiting cities in this fashion 
                until all the cities are not visited. Find the number of ways in which you can
                visit all the cities modulo 10^9+7.


    */




    /*  
        Function to return number ways to go cities given they all lies in
        between start and end index(both included) given start-1 and end +1
        both are visited or are invalid i.e. start = 1 and end = Total cities
    */
    public int countWays(int start, int end, int size){
        if(end - start < 0){
            //if start - end is less than 0 then there are no cities to go 
            return 0;
        }
        if(start==1 || end == size){
            return 1;
        }else {
            int citiesBetween = end - start + 1;
            return citiesBetween+1;
        }
    }

    public int solve(int  A, ArrayList<Integer> B){
        int lastCity = 0;
        Collections.sort(B);
        int ans = 0;

        for (Integer  currentCity : B) {
            ans+= countWays(lastCity+1, currentCity-1, B.size());
            lastCity = currentCity;
        }
        return ans;
    }


    
}