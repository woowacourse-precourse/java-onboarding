package onboarding;


public class Problem2 {

    public static final boolean NO_DUPLICATION = true;
    public static final boolean YES_DUPLICATION = false;

    /**
     * 중복 문자를 삭제한 결과를 저장하는 메서드
     * @param str 해독 해야할 암호문
     * @param isComplete 더이상 해독할 게 없으면 true
     * @return 해독된 암호문
     */
    public static String getMessage(String str, boolean isComplete) {
        if (isComplete) {
            return str;
        }
        String msg = "";
        str += " ";
        isComplete = NO_DUPLICATION;

        if (str.length() > 1) {
            if (str.charAt(0) == str.charAt(1)) {
                isComplete = YES_DUPLICATION;
            } else {
                msg += str.charAt(0);
            }
        }

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isComplete = YES_DUPLICATION;
                continue;
            }
            if (str.charAt(i) != str.charAt(i - 1)) {
                msg += str.charAt(i);
            }
        }
        return getMessage(msg, isComplete);
    }
    public static String solution(String cryptogram) {
        return getMessage(cryptogram, false);
    }
}
