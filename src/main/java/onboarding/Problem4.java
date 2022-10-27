package onboarding;

public class Problem4 {

    public static String solution(String word) {
        return makeReverseString(word);
    }

    private static String makeReverseString(String word) {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            ret.append(convertToReverseCharacter(word.charAt(i)));
        }

        return ret.toString();
    }

    private static char convertToReverseCharacter(char ch) {
        return ch;
    }
}
