package onboarding;

/* 기능 목록
 *
 * decode : 문자 하나를 반대로 변환한 문자를 반환
 * reverse : 범위 내에서 문자의 순서를 뒤집은 결과를 반환
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char c : word.toCharArray())
            answer += decode(c);

        return answer;
    }

    private static char decode(char c) {
        if('a' <= c && c <= 'z')
            return reverse(c, 'a', 'z');
        else if('A' <= c && c <= 'Z')
            return reverse(c, 'A', 'Z');
        return c;
    }

    private static char reverse(char c, char first, char last) {
        return (char) (last - c + first);
    }
}
