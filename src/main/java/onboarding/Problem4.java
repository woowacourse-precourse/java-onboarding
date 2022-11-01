package onboarding;

public class Problem4 {
    public static String solution(String word) {

    }

    private static boolean checkInput(String word){
        if (word.length() < 1 || word.length() > 4000)
            return false;
        return true;
    }
    private static boolean is_Alpha(char c){
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            return true;
        return false;
    }
}
