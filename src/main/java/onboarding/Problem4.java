package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (!validation(word)) return "ERROR";
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            char frogC = c;
            if (Character.isLowerCase(c)) {
                frogC = (char) ('z' - c + 'a');
            } else if (Character.isUpperCase(c)) {
                frogC = (char) ('Z' - c + 'A');
            }
            answer.append(frogC);
        }
        return answer.toString();
    }

    static boolean validation(String word) {
        int length = word.length();
        return length > 0 && length <= 1000;
    }
}
