package onboarding;

public class Problem4 {
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
        return (char) ('Z' - (word - 'A'));
    }

    private static char convertedLowercase(char word) {
        return (char) ('z' - (word - 'a'));
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
