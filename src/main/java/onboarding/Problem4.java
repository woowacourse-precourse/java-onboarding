package onboarding;

public class Problem4 {

    public static final int A = 65;
    public static final int a = 97;
    public static final int ASCII_A_Z_SUM = 155;
    public static final int ASCII_a_z_SUM = 219;

    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char digit = word.charAt(i);

            if (isBlank(digit) || isNotLetter(digit)) {
                stringBuilder.append(digit);
                continue;
            }

            if (isLowerCase(digit)) {
                stringBuilder.append((char) (ASCII_a_z_SUM - digit));
            } else if (isUpperCase(digit)) {
                stringBuilder.append((char) (ASCII_A_Z_SUM - digit));
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isBlank(char digit) {
        return digit == ' ';
    }

    private static boolean isLowerCase(char digit) {
        return digit >= a;
    }

    private static boolean isUpperCase(char digit) {
        return digit >= A;
    }

    private static boolean isNotLetter(char digit) {
        return !isLowerCase(digit) && !isUpperCase(digit);
    }
}
