package onboarding;

public class Problem4 {

    // A(65) + Z(90) = ASCII_UPPERCASE_RANGE(155)
    // a(97) + z(122) = ASCII_LOWERCASE_RANGE(219)
    static final Integer ASCII_UPPERCASE_RANGE = 155;
    static final Integer ASCII_LOWERCASE_RANGE = 219;

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
            return (char) (ASCII_LOWERCASE_RANGE - c);
        }

        return (char) (ASCII_UPPERCASE_RANGE - c);
    }
}
