package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDup(cryptogram);
    }

    private static String removeDup(String s) {
        if (s.isEmpty()) {
            return s;
        }

        char prev = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int start = i - 1;
            while (i < s.length() && s.charAt(i) == prev) {
                i++;
                flag = true;
            }
            if (flag) {
                if (i >= s.length()) {
                    s = s.substring(0, start);
                } else {
                    s = s.substring(0, start) + s.substring(i);
                }
                break;
            } else {
                prev = s.charAt(i);
            }
        }

        if (flag) {
            return removeDup(s);
        }
        return s;
    }
}
