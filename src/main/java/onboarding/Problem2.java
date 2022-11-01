package onboarding;

public class Problem2 {
    static StringBuilder sb = new StringBuilder();
    static boolean checkModifyText;
    static boolean checkPre;
    static boolean checkCurrent;
    static boolean checkNotLowerCase;
    public static String solution(String cyptogram) {
        if (exceptionMethod(cyptogram)) {
            return cyptogram;
        }
        do {
            cyptogram = (cyptogram.length() >= 3 ? longTextDeduplication(cyptogram) : shortTextDuplication(cyptogram));
        } while (checkModifyText);
        return cyptogram;
    }

    public static String longTextDeduplication(String cryptogram) {
        sb.setLength(0);
        checkPre = false;
        checkCurrent = false;
        checkModifyText = false;
        initailValue(cryptogram);
        checkPre = checkCurrent;
        for (int i = 1; i < cryptogram.length() - 1; i++) {
            checkCurrent = checkDuplicate(cryptogram.charAt(i), cryptogram.charAt(i + 1));
            if (checkPre == checkCurrent && !checkCurrent) {
                sb.append(cryptogram.charAt(i));
            }
            verifyStringChange();
            checkPre = checkCurrent;
        }
        lastValue(cryptogram);
        return String.valueOf(sb);
    }
}
