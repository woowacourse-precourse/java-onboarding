package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        final String lowerCase = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            final char now = word.charAt(i);
            if (now == ' ') {
                answer.append(" ");
                continue;
            }

            final int sub = lowerCase.charAt(i) - 'a';
            char changed = (char) (now + 25 - 2 * sub);

            answer.append(changed);
        }

        return answer.toString();
    }
}
