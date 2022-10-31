package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if(isUpper(word.charAt(i))) answer += (char)('A' + 'Z' - word.charAt(i));
            else if(isLower(word.charAt(i))) answer += (char)('a' + 'z' - word.charAt(i));
            else answer += word.charAt(i);
        }
        return answer;
    }

    private static boolean isUpper(char ch) {
        if('A' <= ch && ch <= 'Z') return true;
        else return false;
    }
    private static boolean isLower(char ch) {
        if('a' <= ch && ch <= 'z') return true;
        else return false;
    }
}
