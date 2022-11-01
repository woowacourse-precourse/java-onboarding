package onboarding;

public class Problem2 {
    //같은 문자 있는지 확인
    public static boolean check(String cryptogram) {
        int n = cryptogram.length();
        for (int i = 0; i < n-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
    //같은 문자 삭제
    public static String deleteChar(String cryptogram) {
        int n = cryptogram.length();
        char[] chars = cryptogram.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                chars[i - 1] = 'X';
                for (int j = i+1; j < n; j++) {
                    if (chars[i] != chars[j]) break;
                    if (chars[i] == chars[j]) chars[j] = 'X';
                }
                chars[i] = 'X';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != 'X') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static String solution(String cryptogram) {
        while (check(cryptogram)) {
            cryptogram = deleteChar(cryptogram);
        }
        return cryptogram;
    }
}

