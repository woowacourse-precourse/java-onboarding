package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String upper = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lower = "zyxwvutsrqponmlkjihgfedcba";
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) answer += upper.charAt(ch - 'A');
            else if (Character.isLowerCase(ch)) answer += lower.charAt(ch - 'a');
            else answer += ch;
        }
        return answer;
    }
}
