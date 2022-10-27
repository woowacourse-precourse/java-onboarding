package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int makeAlphabetType(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            return Constants.LOWERCASE;
        }
        if (letter >= 'A' && letter <= 'Z') {
            return Constants.UPPERCASE;
        }
        return Constants.NOT_ALPHABET;
    }

    private static char convert(char letter, int alphabetType) {
        if (alphabetType == Constants.LOWERCASE) {
            return (char) ('a' + 'z' - letter);
        }
        return (char) ('A' + 'Z' - letter);
    }
}
