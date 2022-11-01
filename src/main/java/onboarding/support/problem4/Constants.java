package onboarding.support.problem4;

public final class Constants {

    private static final int EMPTY_SPACE = ' ';
    private static final char LOWER_CASE_BASE = 'a';
    private static final char UPPER_CASE_BASE = 'A';
    private static final int LAST_CHARACTER_ASCII = 'z' - 'a';

    private Constants() {
    }

    public static char getLowerCaseBase() {
        return LOWER_CASE_BASE;
    }

    public static char getUpperCaseBase() {
        return UPPER_CASE_BASE;
    }

    public static int getEmptySpace() {
        return EMPTY_SPACE;
    }

    public static int getLastCharacterAscii() {
        return LAST_CHARACTER_ASCII;
    }
}
