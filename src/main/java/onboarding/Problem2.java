package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getAllRemovedDuplicatedString(cryptogram);
    }

    public static String getAllRemovedDuplicatedString(String cryptogram) {
        while (cryptogram != "") {
            String removedDuplicatedString = getRemovedDuplicatedString(cryptogram);
            if (removedDuplicatedString.equals(cryptogram)) {
                return removedDuplicatedString;
            }
            cryptogram = removedDuplicatedString;
        }
        return cryptogram;
    }

    public static String getRemovedDuplicatedString(String cryptogram) {
        cryptogram = addBlankAtLastIndex(cryptogram);
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

    private static String addBlankAtLastIndex(String cryptogram) {
        return cryptogram + " ";
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
}
