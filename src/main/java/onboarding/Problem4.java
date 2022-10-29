package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z') {
                tmp = (char)('Z' - tmp + 'A');
            } else if (tmp >= 'a' && tmp <= 'z') {
                tmp = (char)('z' - tmp + 'a');
            }

            answer += Character.toString(tmp);
        }

        return answer;
    }
}
