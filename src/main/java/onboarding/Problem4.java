package onboarding;


/*
- 기능 구현사항 목록 -
1. 각 자리의 문자를 받아 규칙에 따라 변역하는 함수 구현
2. 번역된 문자를 배열로 모아두었다가 문자열로 Return
 */
public class Problem4 {
    static String upper_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower_char = "abcdefghijklmnopqrstuvwxyz";

    static char trans_char(char a) {
        char temp = a;
        if (Character.isLowerCase(a)) {
            temp = lower_char.charAt(25 - a + 'a');
        } else if (Character.isUpperCase(a)) {
            temp = upper_char.charAt(25 - a + 'A');
        }
        return temp;
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
