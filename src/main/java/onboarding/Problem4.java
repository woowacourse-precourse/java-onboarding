package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if(c >= 'a' && c <= 'z') { // 소문자인 경우
                answer.append((char)('a' + 'z' - c));
            } else if(c >= 'A' && c <= 'Z') { // 대문자인 경우
                answer.append((char)('A' + 'Z' - c));
            } else { // 알파벳 외의 문자인 경우
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
