package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (isDuplication(cryptogram)) {
            // 연속하는 중복 문자가 있으면 중복 문자 삭제
        }

        return answer;
    }

    public static boolean isDuplication(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }
}
