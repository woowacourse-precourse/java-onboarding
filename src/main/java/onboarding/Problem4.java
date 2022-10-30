package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        char[] words = word.toCharArray();
        for (char eachWord : words) {
            answer.append(convertedAlphabet(eachWord));
        }
        return answer.toString();
    }

    private static char convertedAlphabet(char word) {
        if (isUppercase(word)) {
            return (char) ('Z' - (word - 'A'));
        }
        if (isLowercase(word)) {
            return (char) ('z' - (word - 'a'));
        }
        return word;
    }

    private static boolean isUppercase(char alphabet) {
        if (alphabet >= 'A' && alphabet <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowercase(char alphabet) {
        if (alphabet >= 'a' && alphabet <= 'z') {
            return true;
        }
        return false;
    }
}
