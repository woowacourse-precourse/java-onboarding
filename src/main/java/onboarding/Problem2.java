package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeAdjDuplicate(cryptogram);
    }

    private static String removeAdjDuplicate(String cryptogram) {
        char[] charArr = cryptogram.toCharArray();
        int writeIdx = -1;

        for (char c: charArr) {
            if (writeIdx >= 0 && charArr[writeIdx] == c) {
                writeIdx--;
            } else {
                charArr[++writeIdx] = c;
            }
        }
        return String.valueOf(charArr).substring(0, writeIdx+1);
    }
}
