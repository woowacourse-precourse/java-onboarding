package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (cryptogram.length() > 1) {
            String resultCryptogram = removeConsecutiveDuplicateAlpha(cryptogram);
            if (cryptogram.length() == resultCryptogram.length()) {
                break;
            }
            cryptogram = resultCryptogram;
        }

        return cryptogram;
    }

    private static String removeConsecutiveDuplicateAlpha(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;

        while (idx < cryptogram.length()) {
            int jumpedIdx = jumpConsecutiveDuplicateAlpha(cryptogram, idx);
            if (jumpedIdx == idx) {
                stringBuilder.append(cryptogram.charAt(idx));
                jumpedIdx++;
            }
            idx = jumpedIdx;
        }

        return stringBuilder.toString();
    }

    private static int jumpConsecutiveDuplicateAlpha(String cryptogram, int targetIdx) {
        if (targetIdx == cryptogram.length() - 1) {
            return targetIdx;
        }

        char targetAlpha = cryptogram.charAt(targetIdx);

        if (targetAlpha != cryptogram.charAt(targetIdx + 1)) {
            return targetIdx;
        }

        int idx = targetIdx + 2;
        while (idx < cryptogram.length()) {
            if (targetAlpha != cryptogram.charAt(idx)) {
                break;
            }
            idx++;
        }

        return idx;
    }
}
