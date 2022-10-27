package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w != ' ') {
                if ('A' <= w && w <= 'Z') {
                    w = (char) ('A' + ('Z' - w));
                    answer.append(w);
                } else if ('a' <= w && w <= 'z') {
                    w = (char) ('a' + ('z' - w));
                    answer.append(w);
                }
            } else {
                answer.append(' ');
            }

        }

        return answer.toString();
    }
}
