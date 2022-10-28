package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /* 주어진 소문자를 기능 구현 조건대로 치환하는 메서드 */
    private static char changeLowerCase(char c) {
        return (char)('z'+'a'-c);
    }

    /* 주어진 대문자를 기능 구현 조건대로 치환하는 메서드 */
    private static char changeUpperCase(char c) {
        return (char)('Z'+'A'-c);
    }
}
