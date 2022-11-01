package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            if (!hasDuplication(answer)) return answer;
            answer = removeDuplication(answer);
        }
    }

    private static String removeDuplication(String cryptogram) {
        int startIndex = -1;
        int lastIndex = -1;
        String startString;
        String lastString;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                if (startIndex == -1) startIndex = i;
                lastIndex = i + 1;
            }
            if (cryptogram.charAt(i) != cryptogram.charAt(i + 1) && startIndex != -1) break;
        }
        if (startIndex == -1) return cryptogram;
        startString = cryptogram.substring(0, startIndex);
        // 중복 다음 값의 index 부터 시작이라 +1
        lastString = cryptogram.substring(lastIndex + 1);
        return startString + lastString;
    }


    public static boolean hasDuplication(String str) {
        for (int index = 0; index < str.length() - 1; index++) {
            if (str.charAt(index) == str.charAt(index + 1)) return true;
        }
        return false;
    }
}