package onboarding;

public class Problem4 {

    public static final char FIRST_LOWER = 'a';
    public static final char LAST_LOWER = 'z';
    public static final char FIRST_UPPER = 'A';
    public static final char LAST_UPPER = 'Z';


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    public static boolean isLower(char alphabet) {
        return alphabet >= FIRST_LOWER && alphabet <= LAST_LOWER;
    }

    public static boolean isUpper(char alphabet) {
        return alphabet >= FIRST_UPPER && alphabet <= LAST_UPPER;
    }
}