package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            isBlank(sb, alphabet);
        }

        answer = sb.toString();
        return answer;
    }
    private static void isBlank(StringBuilder sb, char alphabet) {
        if (alphabet == ' ') {
            sb.append(' ');
        }
    }
}
