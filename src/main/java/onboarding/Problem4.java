package onboarding;


/*
- 기능 구현사항 목록 -
1. 각 자리의 문자를 받아 규칙에 따라 변역하는 함수 구현
2. 번역된 문자를 배열로 모아두었다가 문자열로 Return
 */
public class Problem4 {
    static String UPPER_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String LOWER_CHAR = "abcdefghijklmnopqrstuvwxyz";

    static char trans_char(char a) {
        if (Character.isLowerCase(a)) a = LOWER_CHAR.charAt(25 - a + 'a');
        if (Character.isUpperCase(a)) a = UPPER_CHAR.charAt(25 - a + 'A');
        return a;
    }

    private static void joinString(String word, StringBuilder answer) {
        for(char unit : word.toCharArray()) {
            answer.append(trans_char(unit));
        }
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        joinString(word, answer);
        return answer.toString();
    }
}
