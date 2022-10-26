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
            if ('A' <= c && c <= 'Z') sb.append((char)(upper - c));
            else if ('a' <= c && c <= 'z') sb.append((char)(lower - c));
            else sb.append(c);
        }

        return sb.toString();
    }
}
