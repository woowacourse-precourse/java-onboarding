package onboarding;

import java.util.Arrays;

public class Problem2 {

    private static final char EMPTY_CHARACTER = ' ';

    public static String solution(String cryptogram) {
        char[] cryptogramArr = cryptogram.toCharArray();
        String result = "";

        while (true) {
            result = removeDuplicatedChars(cryptogramArr);
            if (result.equals(cryptogramArrToString(cryptogramArr))) {
                break;
            }
            cryptogramArr = result.toCharArray();
        }

        return result;
    }

    private static String cryptogramArrToString(char[] cryptogramArr) {
        StringBuilder ret = new StringBuilder();
        for (char ch : cryptogramArr) {
            if (ch != EMPTY_CHARACTER) {
                ret.append(ch);
            }
        }

        return ret.toString();
    }

    private static String removeDuplicatedChars(char[] cryptogramArr) {
        int left = 0, right = 1, len = cryptogramArr.length;
        cryptogramArr = Arrays.copyOf(cryptogramArr, len);

        while (right < len) {
            char leftCh = cryptogramArr[left];
            char rightCh = cryptogramArr[right];
            if (leftCh == rightCh) {
                cryptogramArr[left] = EMPTY_CHARACTER;
                while (leftCh == rightCh) {
                    cryptogramArr[right++] = EMPTY_CHARACTER;
                    if (right >= len) {
                        break;
                    }
                    rightCh = cryptogramArr[right];
                }
                left = right - 1;
            }
            left++;
            right++;
        }

        return cryptogramArrToString(cryptogramArr);
    }
}
