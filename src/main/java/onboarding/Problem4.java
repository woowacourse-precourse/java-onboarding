package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean isLowerAlpha(char word){
        if (word >= 97 && word <= 122){
            return ture;
        }
        return false;
    }

    public static boolean isNotAlpha(char word){
        if (word < 65 || word > 122 || (91 <= word < 96){
            return true;
        }

        return false;
    }
}
