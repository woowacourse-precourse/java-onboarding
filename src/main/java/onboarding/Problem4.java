package onboarding;

public class Problem4 {

    /** 문자를 반대로 변환하는 함수 */
    private static char replaceChar(char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return (char)('z' - (ch - 'a'));
        } else if(ch >= 'A' && ch <= 'Z') {
            return (char)('Z' - (ch - 'A'));
        } else {
            return ch;
        }
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i < word.length(); i++) {
            char ch = word.charAt(i);

            answer.append(replaceChar(ch));
        }

        return answer.toString();
    }
}
