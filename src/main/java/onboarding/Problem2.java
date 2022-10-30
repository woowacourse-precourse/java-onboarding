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
            if (cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                curDuplicated = false;
            } else {
                curDuplicated = true;
            }

            if (!curDuplicated && !prevDuplicated) {
                result += cryptogram.charAt(i - 1);
            }
            prevDuplicated = curDuplicated;
        }
        return result;
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
