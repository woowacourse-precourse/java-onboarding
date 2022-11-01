package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        int n = cryptogram.length();
        if (n == 0 || n == 1 || n == 1000) return cryptogram;
        StringBuilder sb = new StringBuilder();
        if (cryptogram.charAt(0) != cryptogram.charAt(1)) {
            sb.append(cryptogram.charAt(0));
        }
        for (int i = 1; i < n - 1; i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i) || cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
            } else sb.append(cryptogram.charAt(i));
        }
        if (cryptogram.charAt(n - 2) != cryptogram.charAt(n - 1)) {
            sb.append(cryptogram.charAt(n - 1));
        }
        if (sb.length() == n) {
            return sb.toString();
        }
        return solution(sb.toString());
    }

}

