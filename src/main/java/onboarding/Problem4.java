package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            char tmp = c;

            if ('A' <= c && c <= 'Z')
                tmp = (char) ('Z' - c + 'A');
            else if ('a' <= c && c <= 'z')
                tmp = (char) ('z' - c + 'a');

            answer += tmp;
        }
        return answer;
    }
}
