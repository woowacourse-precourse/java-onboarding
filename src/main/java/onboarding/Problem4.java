/*
 *기능목록
 * 1. 문자 변환하는 함수
 */
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char charReturnConvert(char c) {
        if (c >= 65 && c <= 90) {
            return (char) (155 - c);
        } else if (c >= 97 && c <= 122) {
            return (char) (219 - c);
        }
        return c;
    }
}
