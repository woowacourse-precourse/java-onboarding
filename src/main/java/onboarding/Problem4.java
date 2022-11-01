package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (byte w : word.getBytes()) {
            answer += funnyConverter((char) w);
        }

        return answer;
    }

    private static char funnyConverter(char ch) {
        if (!Character.isAlphabetic(ch)) {
            return (char) ch;
        }

        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));
        }
        return (char) ('Z' - (ch - 'A'));
    }
}
