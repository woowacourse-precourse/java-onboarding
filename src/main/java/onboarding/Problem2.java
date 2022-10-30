package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decode(cryptogram);
        return answer;
    }

    public static String decode(String cryptogram) {
        int i = 0;
        int len = cryptogram.length();
        StringBuffer sb = new StringBuffer(len);
        int sb_idx = -1;

        while (i < len) {
            char ch = cryptogram.charAt(i);
            if (sb_idx != -1 && sb.charAt(sb_idx) == ch) {
                sb.deleteCharAt(sb_idx);
                --sb_idx;
            }
            else {
                sb.append(ch);
                ++sb_idx;
            }
            ++i;
        }
        return sb.toString();
    }
}
