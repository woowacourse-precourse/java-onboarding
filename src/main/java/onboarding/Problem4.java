package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        for (int n = 0; n < word.length(); n++) {
            char c = word.charAt(n);
            if (Character.isUpperCase(c)) {
                c = (char) ('Z' - (c - 'A'));
            }

            if (Character.isLowerCase(c)) {
                c = (char) ('z' - (c - 'a'));
            }

            answer += c;
        }
        return answer;
    }
}