package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String str = cryptogram;
        while (true) {
            String str_rm = same_remove(str);
            if (str_rm.equals(str)) {
                break;
            }
            str = str_rm;
        }
        return str;
    }

    public static String same_remove(String s) {
        StringBuilder sb = new StringBuilder();
        boolean check = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                check = false;
                continue;
            }
            if (check) {
                sb.append(s.charAt(i - 1));
                continue;
            }
            check = true;
        }
        if (check && s.length() != 0) {
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }


}
