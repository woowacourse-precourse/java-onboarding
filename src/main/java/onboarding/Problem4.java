package onboarding;

public class Problem4 {

    static final char START_CHAR = 'A';
    static final char END_CHAR = 'Z';
    static final char DIFF_A_Z = (char) (END_CHAR - START_CHAR);

    public static char transformChar(char ch) {
        if (!Character.isAlphabetic(ch)) {
            return ch;
        }
        if (Character.isLowerCase(ch)) {
            return Character.toLowerCase(transformChar(Character.toUpperCase(ch)));
        }
        if (isLeftCharacter(ch)) {
            return transformLeftChar(ch);
        }

        return transformRightChar(ch);
    }

    public static String transformString(String str) {
        StringBuffer stringBuffer = new StringBuffer();

        for (char ch : str.toCharArray()) {
            stringBuffer.append(transformChar(ch));
        }

        return stringBuffer.toString();
    }

    private static char transformLeftChar(char ch) {
        return (char) (ch - START_CHAR + END_CHAR);
    }

    private static char transformRightChar(char ch) {
        return (char) (END_CHAR - ch + START_CHAR);
    }

    private static boolean isLeftCharacter(char ch) {
        return ch < centerValue();
    }

    private static int centerValue() {
        return DIFF_A_Z / 2;
    }

    public static String solution(String word) {
        return transformString(word);
    }
}
