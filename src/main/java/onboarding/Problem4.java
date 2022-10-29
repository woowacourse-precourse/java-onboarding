package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String reversedString = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isAlphabetic(c)) {
                c = getReversedChar(c);
            }
            reversedString += c;
        }

        return reversedString;
    }

    private static char getReversedChar(char c) {
        if (Character.isLowerCase(c)) {
            return (char) (219 - c);
        }

        return (char) (155 - c);

    }
}
