package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('z' - (c - 'a')));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('Z' - (c - 'A')));
            } else
                sb.append(" ");
        }

        answer = sb.toString();
        return answer;
    }
}
