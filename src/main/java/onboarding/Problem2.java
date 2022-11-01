package onboarding;

public class Problem2 {

    private static int getDuplicateStartPoint(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public static String solution(String cryptogram) {
        int start = getDuplicateStartPoint(cryptogram);
        if (start < 0) {
            return cryptogram; // 중복된 부분이 없으면 종료
        }
        int end = start;
        while (end < cryptogram.length()) {
            if (cryptogram.charAt(start) == cryptogram.charAt(end)) {
                end++;
                continue;
            }
            break;
        }
        String temp = cryptogram.substring(0, start) + cryptogram.substring(end);
        return solution(temp);
    }
}
