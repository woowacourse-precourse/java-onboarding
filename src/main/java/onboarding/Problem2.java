package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder stringBuilder = new StringBuilder(cryptogram);

        while (isDuplicate(stringBuilder.toString())) {
            deleteDuplicate(stringBuilder);
        }

        answer = stringBuilder.toString();

        return answer;
    }

    private static boolean isDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1))
                return true;
        }
        return false;
    }

    private static void deleteDuplicate(StringBuilder stringBuilder) {
        int start = 0;
        int end = 0;
        int idx = 0;
        boolean isDuplicated = false;

        while (idx < stringBuilder.length() - 1) {
            if (stringBuilder.charAt(idx) == stringBuilder.charAt(idx + 1)) {
                if (!isDuplicated) {
                    start = idx;
                    isDuplicated = true;
                }
            } else {
                end = idx;
                if (isDuplicated) {
                    isDuplicated = false;
                    stringBuilder.delete(start, end + 1);
                    idx -= (end - start + 1);
                }
                start = idx;
            }
            idx++;
        }

        if (stringBuilder.charAt(start) == stringBuilder.charAt(stringBuilder.length()-1)) {
            stringBuilder.delete(start, stringBuilder.length());
        }
    }
}
