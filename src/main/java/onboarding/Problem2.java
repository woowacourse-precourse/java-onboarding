package onboarding;

public class Problem2 {
    private static final int DEFAULT_IDX = -1;
    public static String solution(String cryptogram) {
        while (true) {
            int start = DEFAULT_IDX;
            int end = DEFAULT_IDX;
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                char now = cryptogram.charAt(i);
                char next = cryptogram.charAt(i + 1);
                if (now != next) {
                    if (start != DEFAULT_IDX) {
                        end = i + 1;
                        break;
                    }
                    continue;
                }
                if (i + 2 == cryptogram.length()) {
                    end = i + 2;
                }
                if (start == DEFAULT_IDX) {
                    start = i;
                }
            }
            if (start == DEFAULT_IDX && end == DEFAULT_IDX) {
                break;
            }
            cryptogram = deleteDuplicatesBeetweenIdx(cryptogram, start, end);
        }
        return cryptogram;
    }

    public static String deleteDuplicatesBeetweenIdx(String target, int start, int end) {
        String pre = target.substring(0, start);
        String post = target.substring(end);
        return pre + post;
    }
}