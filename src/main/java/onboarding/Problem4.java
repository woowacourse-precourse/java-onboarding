package onboarding;

public class Problem4 {
    public static char changeOneCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ('A' + 'Z' - ch);
        }
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('a' + 'z' - ch);
        }
        return ch;
    }

    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            result.append(changeOneCharacter(word.charAt(i)));
        }

        return result.toString();
    }
}
