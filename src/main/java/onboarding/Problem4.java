package onboarding;

public class Problem4 {

    private static final int UPPER_ASCII_CODE = 65 + 90;
    private static final int LOWER_ASCII_CODE_ = 97 + 122;

    public static String solution(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            answer += convertOppositeWord(c);
        }
        return answer;
    }

    private static char convertOppositeWord(char c) {
        int currentChar = (int)c;

        if (isUpperAlphabet(currentChar)) {
            return (char)(UPPER_ASCII_CODE - currentChar);
        }
        if (isLowerAlphabet(currentChar)) {
            return (char)(LOWER_ASCII_CODE_ - currentChar);
        }
        return c;
    }

    private static boolean isUpperAlphabet(int asciiCode) {
        if (asciiCode >= 'A' && asciiCode <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowerAlphabet(int asciiCode) {
        if (asciiCode >= 'a' && asciiCode <= 'z') {
            return true;
        }
        return false;
    }

}
