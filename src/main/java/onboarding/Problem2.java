package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        while(isDuplicate(cryptogram)) {

            break;
        }

        return cryptogram;
    }

    private static boolean isDuplicate(String answer) {

        if (answer.length() <= 1) {
            return false;
        }

        for (int i = 0; i < answer.length()-1; i++) {
            if (checkDuplicate(answer.charAt(i), answer.charAt(i+1))) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkDuplicate(char first, char second) {

        if (first == second) {
            return true;
        } else {
            return false;
        }

    }

}
