package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char upper = 'A' + 'Z';
        char lower = 'a' + 'z';
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) answer += (char) (upper - ch);
            else if (Character.isLowerCase(ch)) answer += (char) (lower - ch);
            else answer += ch;
        }
        return answer;
    }
}
