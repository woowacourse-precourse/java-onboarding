package onboarding;

public class Problem4 {
    private static final int UPPER_ASCII_SUM = 155;
    private static final int LOWER_ASCII_SUM = 219;

    public static String solution(String word) {
        char[] charWord = word.toCharArray();

        if (!verifyException(charWord)) {
            return "Error";
        }
        return convertReverse(charWord).toString();
    }

    private static String convertReverse(char[] word) {
        String answer = "";

        for (char alphabet : word) {
            if (alphabet == ' ') {
                answer += ' ';
            }
            if (Character.isUpperCase(alphabet)) {
                answer += (char)(UPPER_ASCII_SUM - (int)alphabet);
            }
            if (Character.isLowerCase(alphabet)) {
                answer += (char)(LOWER_ASCII_SUM - (int)alphabet);
            }
        }
        return answer;
    }

    private static boolean verifyException(char[] word) {
        return (word != null && word.length >= 1 && word.length <= 1000);
    }
}
