package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean checkDuplicated(String cryptogram){
        for(int i = 0; i < cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}
