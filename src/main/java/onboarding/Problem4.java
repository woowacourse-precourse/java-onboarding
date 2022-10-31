package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char eachChar = word.charAt(i);
            sb.append(changeCharter(eachChar));
        }
        return sb.toString();
    }

    private static char changeCharter(char chr) {
        if (!Character.isAlphabetic(chr)) {
            return chr;
        }
        if (Character.isUpperCase(chr)) {
            return changeUpperCaseChar(chr);
        }
        return changeLowerCaseChar(chr);
    }

    private static char changeUpperCaseChar(char chr) {
        return (char) (155 - (int) chr);
    }

    private static char changeLowerCaseChar(char chr) {
        return (char) (219 - (int) chr);
    }
}

/* 구현 로직
 * 1. 문자열의 길이만큼 순환한다.
 * 2. 각 문자가 알파벳 문자인지 확인한다.
 * 3. 알파벳 문자라면 대문자 소문자인지 확인한다.
 * 4. 문자에 맞춰서 사전을 참고해서 변환을 실행한다.
 * */

/* 구현 함수
 * 1. 한 문자씩 변경하는 메소드
 *   2. 받은 문자가 알파벳인지 확인하는 메소드
 *       3. 받은 문자가 대문자인지 소문자인지 확인하는 메소드
 *           4. 대문자인 경우 변환하는 메소드
 *           5. 소문자인 경우 변환하는 메소드
 * */