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
            //공백 처리
            if (isSpace(c)) {
                result += ' ';
                continue;
            }
            //소문자, 대문자 별로 아스키 값을 이용해 뒤집음
            int d = (c<='Z')?('Z'-(c-'A')):('z'-(c-'a'));
            result += (char)d;
        }
        return result;
    }

    static boolean isSpace(int c) {return (c == ' ')?true :false;}
}
