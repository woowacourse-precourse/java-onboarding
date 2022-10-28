package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = translate(word);
        return answer;
    }

    private static String translate(String word) {
        StringBuilder sb = new StringBuilder();

        char[] splitWord = word.toCharArray();
        for (char c : splitWord) {
            sb.append(convert(c));
        }
        return sb.toString();
    }

    private static char convert(char letter) {
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

