package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        // 대문자 'A' 와 'Z' 의 아스키코드를 더한다.
        char upper = 'A'+'Z';
        // 소문자 'a' 와 'z' 의 아스키코드를 더한다.
        char lower = 'a'+'z';

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);

            //문자를 바꾸어 준다.
            sb.append(changeChar(c, upper, lower));
        }

        return sb.toString();
    }

    // 문자를 바꾸는 메소드
    private static Character changeChar(Character c, char upper, char lower) {
        if ('A' <= c && c <= 'Z') return (char)(upper - c);
        if ('a' <= c && c <= 'z') return (char)(lower - c);
        return c;
    }
}
