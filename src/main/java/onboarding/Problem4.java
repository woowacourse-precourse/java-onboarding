package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        final double MID = 25 / 2.0;    // 알파벳 중간 값

        for (int i = 0; i < word.length(); ++i) {
            char convertedChar = word.charAt(i);
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {   // 대문자
                convertedChar = (char) (2 * MID - (convertedChar - 'A') + 'A');
            } else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {    // 소문자
                convertedChar = (char) (2 * MID - (convertedChar - 'a') + 'a');
            }
            answer.append(convertedChar);
        }

        return answer.toString();
    }
}
