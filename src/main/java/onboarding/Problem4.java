package onboarding;

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
