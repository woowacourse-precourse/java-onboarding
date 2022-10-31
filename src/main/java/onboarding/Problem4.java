package onboarding;

public class Problem4 {
    public static boolean checkNotAlphabet(char alphabet) {
        if (alphabet >= 65 && alphabet <= 122) {
            return false;
        }
        return true;
    }

    public static boolean checkLowerCase(char alphabet) {
        int ascii = (int)alphabet;
        if (ascii >= 97 && alphabet <= 122) {
            return true;
        }
        return false;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
