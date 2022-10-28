package onboarding;
/*
    기능 목록
    1. 연속된 문자가 있는지 체크하는 기능 -> checkDup
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int dupLen;
        int i = 0;

        while(i < cryptogram.length() - 1) {
            dupLen = checkDup(cryptogram, i);
            if (dupLen > 0) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + dupLen + 1, cryptogram.length());
                i = 0;
                continue;
            }
            i++;
        }
        answer = cryptogram;
        return answer;
    }

    private static int checkDup(String cryptogram, int i) {
        int ret = 0;

        while(cryptogram.charAt(i) == cryptogram.charAt(i + ret + 1)) {
            ret++;
            if(ret == cryptogram.length() - 1)
                break;
        }
        return ret;
    }
}
