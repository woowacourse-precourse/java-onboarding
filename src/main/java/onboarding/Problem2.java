package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String ans = "answer";
        String tmpAns = ans;
        String subStr = "";
        boolean isComplete = false;
        while (!isComplete) {
            tmpAns = ans;
            if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
                ans = "";
                break;
            }else {
                for (int i = 1; i < cryptogram.length() - 1; i++) {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)||cryptogram.charAt(i) == cryptogram.charAt(i + 1) )
                        subStr += cryptogram.charAt(i);
                }
            }

            ans = cryptogram.replaceAll(subStr, "");
            cryptogram = ans;

            if (tmpAns.equals(ans)) {
                isComplete = true;
            }
            subStr = "";
        }

        return ans;
    }

}
