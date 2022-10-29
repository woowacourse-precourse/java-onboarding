package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private char changeLetter(char letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return changeUpperCase(letter);
        }
        if (letter >= 'a' && letter <= 'z') {
            return changeLowerCase(letter);
        }
        return letter;
    }
    private char changeUpperCase(char letter) {
        return (char)('A' + 'Z' - letter);
    }

    private char changeLowerCase(char letter) {
        return (char)('a' + 'z' - letter);
    }
}
