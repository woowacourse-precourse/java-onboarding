package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                c = daemunja(c);
            }
            if(c >= 'a' && c <= 'z') {
                c = somunja(c);
            }
            answer += c;
        }

        return answer;
    }

    public static char daemunja(char c) {
        c = (char)('Z' - c + 'A');

        return c;
    }

    public static char somunja(char c) {
        c = (char)('z' - c + 'a');

        return c;
    }
}
