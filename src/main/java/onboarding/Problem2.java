package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean changed;            // 처리 전 문자열과 처리 후 문자열의 변화를 감지
        boolean[] duplicateChar;    // 연속으로 나오는 문자
        StringBuilder result;       // 처리 후 문자열

        do {
            changed = false;
            duplicateChar = checkDuplicate(cryptogram);

            result = new StringBuilder();
            for (int i = 0; i < cryptogram.length(); i++) {
                if (!duplicateChar[i]) {
                    result.append(cryptogram.charAt(i));
                } else {
                    changed = true;
                }
            }

            cryptogram = result.toString();

        } while (changed);

        return cryptogram;
    }

    private static boolean[] checkDuplicate(String str) {
        int strLen = str.length();
        boolean[] duplicate = new boolean[strLen];

        int left = 0;
        int right = 1;

        while (right < strLen) {
            if ((str.charAt(left) == str.charAt(right))) {
                duplicate[left] = true;
                duplicate[right] = true;
                right++;

                while (right < strLen && str.charAt(left) == str.charAt(right)) {
                    duplicate[right] = true;
                    right++;
                }
            }
            left = right;
            right++;
        }

        return duplicate;
    }
}
