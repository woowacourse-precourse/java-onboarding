package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = wordFrog(word);
        return answer;
    }
    static String wordFrog(String s) {
        String result = "";
        for (int i=0;i<s.length();i++) {
            int c = s.charAt(i);
            if (c == ' ') {
                result += ' ';
                continue;
            }
            int d = (c<='Z')?('Z'-(c-'A')):('z'-(c-'a'));
            result += (char)d;
        }
        return result;
    }
}
