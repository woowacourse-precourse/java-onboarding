package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        String result = cryptogram;
        String tmp;
        do {
            tmp = result;
            result = removeContinuousDupChar(result);
        } while (!tmp.equals(result));
        return result;
    }

    private static String removeContinuousDupChar(String dupStr) {
        if (dupStr.isEmpty())
            return "";

        int dupStrLength = dupStr.length();
        boolean[] checkDup = new boolean[dupStrLength];
        char tmpCh = dupStr.charAt(0);
        for (int i = 1; i < dupStrLength; i++) {
            if (tmpCh == dupStr.charAt(i)) {
                checkDup[i - 1] = checkDup[i] = true;
            }
            tmpCh = dupStr.charAt(i);
        }

        String result = "";
        for (int i = 0; i < checkDup.length; i++) {
            if (!checkDup[i]) {
                result += dupStr.charAt(i);
            }
        }
        return result;
    }
}
