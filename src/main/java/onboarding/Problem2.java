package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean isDuplicated = true;

        while (isDuplicated) {
            for (int i = 0; i < sb.length(); i++) {
                if (i == 0) {
                    continue;
                }
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    i = i - 2;
                }
            }
            isDuplicated = checkDuplicated(sb);
        }

        return sb.toString();
    }

    private static boolean checkDuplicated(StringBuilder cryptogram) {
        String str = cryptogram.toString();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                continue;
            }
            if (str.charAt(i - 1) == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
