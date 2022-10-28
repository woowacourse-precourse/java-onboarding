package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static String getAnswer(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(getFrogWord(c));
        }
        return sb.toString();
    }

    public static char getFrogWord(char alphabet) {
        if (!Character.isAlphabetic(alphabet))
            return alphabet;
        if (Character.isUpperCase(alphabet)) {
            return (char) ('A' + ('Z' - alphabet));
        } else {
            return (char) ('a' + ('z' - alphabet));
        }
    }
}
