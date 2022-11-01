package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (violation(cryptogram)) return "ERROR";
        String curr = cryptogram;
        while (true) {
            String next = delete(curr);
            if (curr.equals(next)) break;
            curr = next;
        }
        return curr;
    }
    
    // 길이 및 소문자로만 이루어져있는지 검증
    static boolean violation(String cryptogram) {
        int length = cryptogram.length();
        if (length == 0 || length > 1000) return true;
        String regex = "^[a-z]*$";
        return !Pattern.matches(regex, cryptogram);
    }
    
    // 한차례 순회하면서 중복 문자 제거
    static String delete(String curr) {
        boolean[] delete = new boolean[curr.length()];
        for (int i = 0; i < curr.length() - 1; i++) {
            if (curr.charAt(i) == curr.charAt(i + 1)) {
                delete[i] = delete[i + 1] = true;
            }
        }
        StringBuilder deleted = new StringBuilder();
        for (int i = 0; i < curr.length(); i++) {
            if (delete[i]) {
                continue;
            }
            deleted.append(curr.charAt(i));
        }
        return deleted.toString();
    }
}
