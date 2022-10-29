package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        System.out.println(backwardAlphabet('h'));
        return answer;
    }

    private static Character backwardAlphabet(char c) {
        if (!validation(c)) {
            return c;
        }

        if (c >= 'A' && c <= 'Z') {
            return (char) ('Z' - (c - 'A'));
        }

        return (char) ('z' - (c - 'a'));
    }

    private static boolean validation(char c) {
        return Character.isAlphabetic(c);
    }

}



