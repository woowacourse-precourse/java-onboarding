package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (checkInput(word)) {
            return "-1";
        }

        return answer;
    }

    public static boolean checkInput(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return true;
        }
        return false;
    }

    public static int checkUpperOrLower(char alphabet) {
        if (alphabet >= 'A' && alphabet <= 'Z') {
            return 2;
        }
        if (alphabet >= 'a' && alphabet <= 'z') {
            return 1;
        }
        return 0;
    }
}
