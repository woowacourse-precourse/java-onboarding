package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()){
            if (c == ' '){
                answer.append(' ');
                continue;
            }
            if ('A' <= c && c <= 'Z')
                answer.append((char)('Z' - (c - 'A')));
            else if ('a' <= c && c <= 'z')
                answer.append((char)('z' - (c - 'a')));
        }
        return answer.toString();
    }
}
