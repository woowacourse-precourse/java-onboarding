package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static char changeLetter(char letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return changeUpperCase(letter);
        }
        if (letter >= 'a' && letter <= 'z') {
            return changeLowerCase(letter);
        }
        return letter;
    }
    private static char changeUpperCase(char letter) {
        return (char)('A' + 'Z' - letter);
    }

    private static char changeLowerCase(char letter) {
        return (char)('a' + 'z' - letter);
    }
}
