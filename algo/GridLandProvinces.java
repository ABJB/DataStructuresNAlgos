import javax.swing.text.StyledEditorKit.BoldAction;

public class GridLandProvinces{

    public boolean checkIfAnyRoationIsPallimdrome(String s){
        /*
            Given a string check whether any of its clockwise rotation is palindrome.
            i.e. check whether any rotation of string when reversed is same as the string.
        */
        String reverse = new StringBuilder(s).reverse().toString();
        for(int i=0;i<reverse.length();i++){
            int rotationStartIndex = i;
            int parseCount=0;
            boolean haveSame = true;  
            int frontStringIndex = 0;
            
            while(haveSame &&parseCount<s.length()){
                // System.out.println("Starting points "+ (rotationStartIndex+parseCount) +" "+ (frontStringIndex+parseCount));
                if(s.charAt(frontStringIndex+parseCount) != reverse.charAt((rotationStartIndex+parseCount)%reverse.length())){
                    haveSame=false;
                }
                parseCount++;
            }
            if(haveSame){
                return true;
            }
        }
        return false;
    }

    public int getStringRotationUniquePermutation(String s) {
        /*
         * Given a Even Count String find the count of rotation which are unique
         */

        int totalUniquePermutations = 1;

        for(int i=1;i<s.length();i++){
            boolean isEqual = true;
            for(int j=0;j<s.length()&&isEqual;j++){
                // System.out.println(j + " "+ (i+j));
                if(s.charAt((i+j)%s.length()) != s.charAt(j)){
                    isEqual=false;
                }                
            }
            if(isEqual){
                break;
            }else{
                totalUniquePermutations++;
            }
        }
        return totalUniquePermutations;
    }

    public int stringTotalRotationalReversalPermutation(String s){
        int rotationPermutation = getStringRotationUniquePermutation(s);
        // System.out.println(rotationPermutation);
        return checkIfAnyRoationIsPallimdrome(s)?rotationPermutation:rotationPermutation*2;
    }

    
}