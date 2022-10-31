package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if(hasException(word)){
            return null;
        }
        return answer;
    }

    public static boolean hasException(String word){
        if(word.length()<1 || word.length()>10000)
            return true;
        return false;
    }


}
