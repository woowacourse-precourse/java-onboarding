package onboarding;


/**
 * 기능 사항
 * 1. 해당 문자를 변환하는 함수
 *
 */
public class Problem4 {


    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 1. 해당 문자를 변환하는 함수
     * @param x
     * @return 해당되는 문자열로 변환
     */
    static char translate(char x) {
        char res = x;
        if (Character.isLowerCase(x)) {
            res = lower.charAt(25 - x + 'a');
        } else if (Character.isUpperCase(x)) {
            res = upper.charAt(25 - x + 'A');
        }
        return res;
    }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
