package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] splitWord = word.toCharArray();
        return answer;
    }

    private static char translate(char letter) {
        if (Character.isAlphabetic(letter)) {
            return replaceLetter(letter);
        }
        return letter;
    }

    private static char replaceLetter(char letter) {
        if (Character.isLowerCase(letter)) {
            return (char) ('z' - (letter - 'a'));
        }
        return (char) ('Z' - (letter - 'A'));
    }

}

