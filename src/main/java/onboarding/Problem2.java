package onboarding;

public class Problem2 {
    private static final int NO_DUPLICATE = -1;
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static int findDuplicateIndex(String str){
        for(int index=0; index<str.length()-1; index++){
            if(str.charAt(index)==str.charAt(index+1)){
                return index;
            }
        }
        return NO_DUPLICATE;
    }
}
