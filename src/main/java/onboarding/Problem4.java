package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += checkWord(word.charAt(i));
        }

        return result;
    }

    private static char checkWord(char word) {
        if (word >= 'A' && word <= 'Z') {
            return changeUppercase(word);
        }

        if (word >= 'a' && word <= 'z') {
            return changeLowercase(word);
        }

        return word;
    }

    private static char changeLowercase(char word) {
        return (char) (word + 25 - (word - 'a') * 2);
    }

    private static char changeUppercase(char word) {
        return (char) (word + 25 - (word - 'A') * 2);
    }
}
