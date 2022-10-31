package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char ch;

        for (int i=0; i<word.length(); i++) {
            ch = word.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                answer += 'z' - ch + 'a';
            }
            else if ('A' <= ch && ch <= 'Z') {
                answer += 'Z' - ch + 'A';
            }
            else {
                answer += ch;
            }
        }

        return answer;
    }
}
