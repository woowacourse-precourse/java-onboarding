package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(!checkValidation(word)){
            return null;
        }
        return answer;
    }

    private static boolean checkValidation(String word){
        if(1 <= word.length() || word.length()<=1000){
            return true;
        }
        return false;
    }

}
