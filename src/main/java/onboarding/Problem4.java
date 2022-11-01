package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++){
            answer += switchChar(word.charAt(i));
        }
        return answer;
    }

    private static boolean isLowerCase(char c){
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    private static boolean isUpperCase(char c){
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }

    private static char switchChar(char c){
        char switchedChar = c;
        if (isLowerCase(c)){
            switchedChar = (char)(-c + 'z' + 'a');
        }
        else if (isUpperCase(c)) {
            switchedChar = (char) (-c + 'Z' + 'A');
        }
        return switchedChar;
    }



}
