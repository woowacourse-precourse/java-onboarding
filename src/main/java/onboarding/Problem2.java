package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        boolean hasChanged = true;
        while (hasChanged) {
            System.out.println(answer);
            StringBuilder sb = new StringBuilder();
            int len = answer.length();
            int cnt = 0;
            hasChanged = false;

            while (cnt < len-1) {
                if (answer.charAt(cnt) == answer.charAt(cnt + 1)) {
                    System.out.println(answer.charAt(cnt) + " 삭제");
                    cnt += 2;
                    hasChanged = true;
                    continue;
                }
                sb.append(answer.charAt(cnt++));
            }
            if (cnt == len-1) sb.append(answer.charAt(cnt));
            answer = sb.toString();
        }

        return answer;
    }

}
