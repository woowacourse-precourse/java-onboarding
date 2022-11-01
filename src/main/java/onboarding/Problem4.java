package onboarding;

/**
 * 기능
 * 1. 해당 문자를 반대로 변환하는 함수
 */
public class Problem4 {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char cur : word.toCharArray()) {
            sb.append(translate(cur));
        }
        return sb.toString();
    }

    /**
     * 1. 해당 문자를 반대로 변환하는 함수
     * @param x
     * @return 반대 문자를 반환
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


}
