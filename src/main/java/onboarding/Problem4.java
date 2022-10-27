package onboarding;

public class Problem4 {

    private static char translate(char c) {
        if (Character.isUpperCase(c)) {
            return c; // 대문자 번역
        }
        return c; // 소문자 번역
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isAlphabetic(c)) {
                answer.append(translate(c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}
