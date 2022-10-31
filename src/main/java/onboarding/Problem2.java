package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; ++i) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                // 연속하는 중복 문자열 제거
                String targetString = cryptogram.substring(i, i+2);
                cryptogram = cryptogram.replace(targetString, "");

                // 중복한 문자 삭제 후 그 이전 문자부터 다시 검사
                if (i != 0) {
                    i -= 2;
                } else {
                    --i;
                }
            }
        }

        String answer = cryptogram;
        return answer;
    }
}
