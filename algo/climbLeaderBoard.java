import java.util.Arrays;

class climbLeaderBoard {

    public int binarycout(int arr[], int ele) {
        if (ele < arr[0]) {
            return arr.length + 1;
        } else if (ele == arr[0]) {
            return arr.length;
        }
        int l = 0, r = arr.length - 1, mid = 0;
        int justsmaller = mid;
        boolean elePresent = false;
        while (l <= r) {
            mid = l + r;
            mid /= 2;
            if (arr[mid] >= ele) {
                if (arr[mid] == ele) {
                    elePresent = true;
                }
                r = mid - 1;
            } else {
                justsmaller = mid;
                l = mid + 1;
            }
        }
        int position = arr.length - 1 - justsmaller;
        position += (elePresent) ? 0 : 1;
        // System.out.println(justsmaller);
        return position;
    }

    public int[] climbingLeaderboard(int[] scores, int[] alice) {
        // System.out.println("Enter the dragon");
        Arrays.sort(scores);
        int noRepeatcount = 1;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] != scores[i - 1]) {
                noRepeatcount++;
            }
        }
        int[] scoresNoRepeat = new int[noRepeatcount];
        scoresNoRepeat[0] = scores[0];
        for (int i = 1, scouresIndex = 1; scouresIndex < scores.length; scouresIndex++) {
            if (scores[scouresIndex] != scores[scouresIndex - 1]) {
                scoresNoRepeat[i] = scores[scouresIndex];
                i++;
            }
        }

        int sol[] = new int[alice.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = binarycout(scoresNoRepeat, alice[i]);
        }
        // System.out.println("hello");
        return sol;
    }



}