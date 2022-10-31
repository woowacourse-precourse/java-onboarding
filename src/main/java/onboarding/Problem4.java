package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char converseChar(char ch) {
        if(Character.isUpperCase(ch)){
            return (char)('Z'-(ch-'A'));
        }else if(Character.isLowerCase(ch))
            return (char)('z'-(ch-'a'));
        else
            return ch;
    }
}
