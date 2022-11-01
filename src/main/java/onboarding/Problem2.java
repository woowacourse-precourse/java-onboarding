/**
 * 클래스 이름
 * - 문제 2
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int strLength;
        do{
            strLength = answer.length();
            // 중복된 문자 제거
            answer = removeDuplication(answer);
        } while(strLength != answer.length());  // 제거된 문자가 없다면 복호화 완료


        return answer;
    }

    private static String removeDuplication(String cryptogram) {
        // '1'은 알파벳과 일치하지 않는 문자로 설정
        char pre = '1';
        String result = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            char curr = cryptogram.charAt(i);
            char next;

            // next 초기화
            if (i == cryptogram.length() - 1) {
                next = '1';
            } else {
                next = cryptogram.charAt(i + 1);
            }

            // 이전 문자 또는 다음 문자와 중복되지 않는다면 문자열에 추가
            if (curr != pre && curr != next) {
                result += curr;
            }
            pre=curr;
        }
        return result;
    }
}
