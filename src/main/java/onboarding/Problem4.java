package onboarding;

public class Problem4 {
    public static String solution(String word) {
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
}
