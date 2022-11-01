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
            curDuplicated = isCurDuplicated(cryptogram, i);
            result = getNotDuplicatedChar(curDuplicated, prevDuplicated, cryptogram.charAt(i-1));
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

    private static boolean isCurDuplicated(String cryptogram, int i) {
        if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
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
