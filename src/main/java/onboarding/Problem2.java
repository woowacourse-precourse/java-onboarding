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
    public static String shortTextDuplication(String cryptogram) {
        sb.setLength(0);
        checkCurrent = false;
        checkModifyText = false;
        if (cryptogram.length() == 2) {
            checkCurrent = checkDuplicate(cryptogram.charAt(0), cryptogram.charAt(1));
            if (!checkCurrent) {
                sb.append(cryptogram.charAt(0)).append(cryptogram.charAt(1));
            }
            return String.valueOf(sb);
        }
        return cryptogram;
    }
    public static Boolean checkModify(boolean checkPre, boolean checkCurrent) {
        return checkCurrent || checkPre != checkCurrent;
    }
    public static Boolean checkDuplicate(char pre, char current) {
        return pre == current;
    }

    public static void initailValue(String cryptogram) {
        checkCurrent = checkDuplicate(cryptogram.charAt(0), cryptogram.charAt(1));
        if (!checkCurrent) {
            sb.append(cryptogram.charAt(0));
        }
    }
}
