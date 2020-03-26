import java.util.ArrayList;
import java.util.HashMap;

import sun.security.util.Length;

class QueensAttack{
    public boolean isInside(int n , int row, int col){
        if(row> n || col>n || row<1 || col<1){
            return false;
        }
        return true;
    }

    public boolean obstaclePresent(int row, int col,HashMap<Integer, ArrayList<Integer>> obstacles){
        ArrayList<Integer> obstracles_row = obstacles.get(row);
        if(obstracles_row == null){
            return false;
        }
        for(int i=0;i<obstracles_row.size();i++){
            if(col == obstracles_row.get(i)){
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, ArrayList<Integer>> createMappedObstracle(int n, int [][]obstacles){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0;i<obstacles.length;i++){
            if(map.get(obstacles[i][0])== null){
                map.put(obstacles[i][0], new ArrayList<Integer>());
            }
            temp = map.get(obstacles[i][0]);
            temp.add(obstacles[i][1]);
            map.put(obstacles[i][0], temp);
        }
        return map;
    }

    public int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashMap<Integer, ArrayList<Integer>> map = createMappedObstracle(n, obstacles);
        int cur_row = r_q;
        int cur_col = c_q;
        int placeHolderCount =0;
        // In positive x axis
        while( (isInside(n, cur_row, cur_col+1)) && !obstaclePresent(cur_row, cur_col+1, map)){
            cur_col++;
            placeHolderCount++;
        }
        // In I quadrant
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row+1, cur_col+1)) && !obstaclePresent(cur_row+1, cur_col+1, map)){
            cur_col++;
            cur_row++;
            placeHolderCount++;
        }
        // In positive y axis
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row+1, cur_col)) && !obstaclePresent(cur_row+1, cur_col, map)){
            cur_row++;
            placeHolderCount++;
        }
        // In II quadrant
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row+1, cur_col-1)) && !obstaclePresent(cur_row+1, cur_col-1, map)){
            cur_col--;
            cur_row++;
            placeHolderCount++;
        }
        // In negative x axis
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row, cur_col-1)) && !obstaclePresent(cur_row, cur_col-1, map)){
            cur_col--;
            placeHolderCount++;
        }
        // In III quadrant
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row-1, cur_col-1)) && !obstaclePresent(cur_row-1, cur_col-1, map)){
            cur_col--;
            cur_row--;
            placeHolderCount++;
        }
        // In negative y axis
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row-1, cur_col)) && !obstaclePresent(cur_row-1, cur_col, map)){
            cur_row--;
            placeHolderCount++;
        }
        // In IV quadrant
        cur_row=r_q;
        cur_col = c_q;
        while( (isInside(n, cur_row-1, cur_col+1)) && !obstaclePresent(cur_row-1, cur_col+1, map)){
            cur_col++;
            cur_row--;
            placeHolderCount++;
        }
        return placeHolderCount;
    }
}