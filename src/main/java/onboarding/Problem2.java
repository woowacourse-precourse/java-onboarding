package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        while(isDuplicate(cryptogram)) {
            cryptogram = removeDuplicate(cryptogram);
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

    private static String removeDuplicate(String answer) {
        StringBuilder result = new StringBuilder();

        boolean isRemove = false;
        for (int i = 0; i < answer.length()-1; i++) {
            if (checkDuplicate(answer.charAt(i), answer.charAt(i+1))) {
                isRemove = true;
            } else {
                if (isRemove) {
                    isRemove = false;
                } else {
                    result.append(answer.charAt(i));
                }
            }
        }

        int size = answer.length();
        if (!checkDuplicate(answer.charAt(size-2), answer.charAt(size-1))) {
            result.append(answer.charAt(size-1));
        }

        return result.toString();
    }

    private static boolean checkDuplicate(char first, char second) {

        if (first == second) {
            return true;
        } else {
            return false;
        }

    }

}
