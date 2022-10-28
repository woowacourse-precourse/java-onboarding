package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // 연속하는 중복 문자가 있는지 확인하는 메소드
    private static int isRepetitive(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return 1;
            }
        }
        return 0;
    }
}
