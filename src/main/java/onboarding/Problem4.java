package onboarding;

public class Problem4 {

    private static final int UPPER_A_ASCII = 'A';
    private static final int UPPER_Z_ASCII = 'A';
    private static final int LOWER_A_ASCII = 'a';
    private static final int LOWER_Z_ASCII = 'z';

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char treeFrogDictionary(char word) {
        if (Character.isUpperCase(word)) {
            return (char) (UPPER_A_ASCII + UPPER_Z_ASCII - (int) word);
        }
        return (char) (LOWER_A_ASCII + LOWER_Z_ASCII - (int) word);
    }
}
