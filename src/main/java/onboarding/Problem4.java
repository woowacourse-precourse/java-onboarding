package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            stringBuffer.append(classifyCharacter(word.charAt(i)));
        }

        return stringBuffer.toString();
    }

    /* 주어진 소문자를 기능 구현 조건대로 치환하는 메서드 */
    private static char changeLowerCase(char c) {
        return (char)('z' + 'a' - c);
    }

    /* 주어진 대문자를 기능 구현 조건대로 치환하는 메서드 */
    private static char changeUpperCase(char c) {
        return (char)('Z' + 'A' - c);
    }

    /* 대문자인지, 소문자인지, 모두 아닌지 구분해서 결과 리턴하는 메서드 */
    private static char classifyCharacter(char c) {
        if (c >= 'a' && c <= 'z') {
            return changeLowerCase(c);
        }

        if (c >= 'A' && c <= 'Z') {
            return changeUpperCase(c);
        }

        return c;
    }
}
