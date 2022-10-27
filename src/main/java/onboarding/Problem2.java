package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            if(!hasReduplication(answer)){
                return answer;
            }
            if(hasReduplication(answer)){
                answer = removeReduplication(answer);
            }
        }
    }

    private static String removeReduplication(String cryptogram) {
        int startIndex = -1;
        int lastIndex = -1;
        String startString;
        String lastString;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (hasReduplication(cryptogram, i)) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                lastIndex = i + 1;
            }
        }
        if (startIndex == -1) {
            return cryptogram;
        } else {
            startString = cryptogram.substring(0, startIndex);
            // 중복 다음 값의 index 부터 시작이라 +1
            lastString = cryptogram.substring(lastIndex + 1);
            return startString + lastString;
        }
    }

    public static boolean hasReduplication(String str, int index) {
        if (str.charAt(index) == str.charAt(index + 1)) {
            return true;
        }
        return false;
    }

    public static boolean hasReduplication(String str) {
        for (int index = 0; index < str.length() - 1; index++) {
            if (str.charAt(index) == str.charAt(index + 1)) {
                return true;
            }
        }
        return false;
    }
}