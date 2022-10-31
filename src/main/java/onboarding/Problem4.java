package onboarding;

public class Problem4 {
    public static String solution(String word) {

        StringBuilder conversionText = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            conversionText.append(getAlphabat(character));
        }

        return conversionText.toString();
    }

    private static char getAlphabat(char character) {
        if ('A' <= character && character <= 'Z') {
            return (char)('A' + 'Z' - character);
        }
        if ('a' <= character && character <= 'z') {
            return (char)('a' + 'z' - character);
        }

        return character;
    }
}
