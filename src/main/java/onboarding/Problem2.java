package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeOverlay(cryptogram);
    }

    static String removeOverlay(String s) {
        Integer cnt = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            } else if (cnt > 0) {
                return removeOverlay(s.substring(0, i-cnt-1) + s.substring(i));
            }
            if (s.length() == 2 && cnt > 0) return "";
        }
        return s;
    }
}
