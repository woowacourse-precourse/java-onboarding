package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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
