package onboarding;

/**
 * [기능 요구사항 목록]
 * 1. 중복 문자를 삭제한 결과를 저장하는 메서드 getMessage
 */
public class Problem2 {

    public static String getMessage(String str, boolean flag) {
        if (flag) {
            return str;
        }
        String msg = "";
        str += " ";
        flag = true;

        if (str.length() > 1) {
            if (str.charAt(0) == str.charAt(1)) {
                flag = false;
            } else {
                msg += str.charAt(0);
            }
        }

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                flag = false;
                continue;
            }
            if (str.charAt(i) != str.charAt(i - 1)) {
                msg += str.charAt(i);
            }
        }
        return getMessage(msg, flag);
    }
    public static String solution(String cryptogram) {
        return getMessage(cryptogram, false);
    }
}
