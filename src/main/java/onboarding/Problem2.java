package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = removeReduplication(cryptogram);
        return answer;
    }

    private static String removeReduplication(String cryptogram) {
        int startIndex = 0;
        int lastIndex = 0;
        String startString;
        String lastString;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                if (startIndex == 0) {
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
}
