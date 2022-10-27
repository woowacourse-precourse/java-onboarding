package onboarding;

/* 기능 목록
 * 1. 중복된 문자들을 삭제하는 기능
 * 2. 중복되지 않은 값들로 업데이트하는 기능
 * 3. 중복된 값이 모두 없어질 때 까지 반복하는 기능
 * */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 중복된 문자인지 검사하여 중복일 경우 true를 반환합니다.
     *
     * @param str 중복이 있는지 검사할 문자열
     * @param idx 중복이 있는지 검사할 인덱스
     * @return 중복된 문자일 경우 true, 아닐 경우 false 반환
     */
    boolean isDuplicate(String str, int idx) {
        if (idx > 0 && str.charAt(idx) == str.charAt(idx - 1)) {
            return true;
        } else if (idx < str.length() - 1 && str.charAt(idx) == str.charAt(idx + 1)) {
            return true;
        }
        return false;
    }
}
