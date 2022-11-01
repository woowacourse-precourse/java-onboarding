package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int upBase = 'A' + 'Z';
        int lowBase = 'a' + 'z';

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char)(upBase - c);
            } else if (c >= 'a' && c <= 'z') {
                c = (char)(lowBase - c);
            }
            answer += c;
        }
        return answer;
    }
}
