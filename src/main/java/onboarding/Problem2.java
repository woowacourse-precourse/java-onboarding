package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return loopRemoveDuplicatedString(cryptogram);
    }

    public static String removeDuplicatedString(String cryptogram) {
        cryptogram += " ";
        boolean prevDuplicated = false;
        boolean curDuplicated;
        String result = "";

        for (int i = 1; i < cryptogram.length(); i++) {
            char previous = cryptogram.charAt(i - 1);
            char current = cryptogram.charAt(i);
            curDuplicated = isCurDuplicated(previous, current);
            result = getNotDuplicatedChar(curDuplicated, prevDuplicated, previous);
            prevDuplicated = curDuplicated;
        }
        return result;
    }

    private static String getNotDuplicatedChar(Boolean curDuplication, Boolean prevDuplication, char previous) {
        if (!curDuplication && !prevDuplication) {
            return String.valueOf(previous);
        }
        return "";
    }

    private static boolean isCurDuplicated(char previous, char current) {
        if (current == previous) {
            return true;
        }
        return false;
    }

    public static String loopRemoveDuplicatedString(String cryptogram) {
        while (cryptogram != "") {
            String removedDuplicatedString = removeDuplicatedString(cryptogram);
            if (removedDuplicatedString.equals(cryptogram)) {
                return removedDuplicatedString;
            }
            cryptogram = removedDuplicatedString;
        }
        return cryptogram;
    }
}
