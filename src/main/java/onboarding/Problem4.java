package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
