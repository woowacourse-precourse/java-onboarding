package onboarding;

/* 기능 목록
 * 1. 중복 문자 검사 기능
 * 2. 중복 문자 제거 기능
 * 3. 연속적으로 중복해서 나타나는 문자가 없을 때까지 반복
 * */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (!answer.equals(cryptogram)) {
            answer = cryptogram;
            cryptogram = deduplicate(cryptogram);
        }

        return answer;
    }

    /**
     * 중복된 문자인지 검사하여 중복일 경우 true를 반환합니다.
     *
     * @param str 중복이 있는지 검사할 문자열
     * @param idx 중복이 있는지 검사할 인덱스
     * @return 중복된 문자일 경우 true, 아닐 경우 false 반환
     */
    static boolean isDuplicate(String str, int idx) {
        if (idx > 0 && str.charAt(idx) == str.charAt(idx - 1)) {
            return true;
        } else if (idx < str.length() - 1 && str.charAt(idx) == str.charAt(idx + 1)) {
            return true;
        }

        return false;
    }

    /**
     * 중복된 문자가 제거된 문자열을 반환합니다.
     *
     * @param str 중복을 제거할 문자열
     * @return 중복이 제거된 문자열
     */
    static String deduplicate(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!isDuplicate(str, i)) {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
