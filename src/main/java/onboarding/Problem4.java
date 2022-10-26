package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return convertToFrogWord(word);
    }

    private static String convertToFrogWord(String word) {
        StringBuilder frogWordBuilder = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (isAlphabet(ch)) frogWordBuilder.append(convertToFrogChar(ch));
            else frogWordBuilder.append(ch);
        }
        return frogWordBuilder.toString();
    }

    private static boolean isAlphabet(char ch) {
        return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
    }

    private static char convertToFrogChar(char ch) {
        char firstAlphabet = isCapital(ch) ? 'A' : 'a';
        char lastAlphabet = isCapital(ch) ? 'Z' : 'z';
        return (char) (firstAlphabet + lastAlphabet - ch);
    }

    private static boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
