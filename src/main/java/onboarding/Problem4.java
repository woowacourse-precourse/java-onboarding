package onboarding;

public class Problem4 {

    private static final int ASCII_A_AND_Z_UPPERCASE_SUM = 'A' + 'Z';
    private static final int ASCII_A_AND_Z_LOWERCASE_SUM = 'a' + 'z';

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        char[] words = word.toCharArray();
        for (char eachWord : words) {
            answer.append(convertedWord(eachWord));
        }

        return answer.toString();
    }

    private static char convertedWord(char word) {
        if (isUppercase(word)) {
            return convertedUppercase(word);
        }
        if (isLowercase(word)) {
            return convertedLowercase(word);
        }

        return word;
    }

    private static char convertedUppercase(char word) {
        return (char) (ASCII_A_AND_Z_UPPERCASE_SUM - word);
    }

    private static char convertedLowercase(char word) {
        return (char) (ASCII_A_AND_Z_LOWERCASE_SUM - word);
    }

    private static boolean isUppercase(char word) {
        if (word >= 'A' && word <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowercase(char word) {
        if (word >= 'a' && word <= 'z') {
            return true;
        }
        return false;
    }
}
