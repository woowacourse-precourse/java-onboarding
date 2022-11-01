package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 연속 중복이 끝나는 인덱스를 반환합니다.
     */
    private static int findDuplicateEndIndex(String str, int start) {
        int end = str.length() - 1;

        for (int i = start; i < str.length(); i++) {
            if (str.charAt(start) != str.charAt(i)) {
                end = i - 1;
                break;
            }
        }

        return end;
    }
}
