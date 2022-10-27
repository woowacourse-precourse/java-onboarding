package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            int duplicatesIndex = getDuplicatesIndex(cryptogram);
            if (duplicatesIndex == -1 ) return answer;
            answer = removeDuplicates(answer);
        }
    }

    private static String removeDuplicates(String cryptogram) {
        int startIndex = -1;
        int lastIndex = -1;
        String startString;
        String lastString;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (hasDuplicates(cryptogram, i)) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                lastIndex = i + 1;
            }
        }
        startString = cryptogram.substring(0, startIndex);
        // 중복 다음 값의 index 부터 시작이라 +1
        lastString = cryptogram.substring(lastIndex + 1);
        return startString + lastString;
    }

    public static int getDuplicatesIndex(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return i;
        }
        return -1;
    }
    public static boolean hasDuplicates(String str, int index) {
        if (str.charAt(index) == str.charAt(index + 1)) return true;
        return false;
    }
}