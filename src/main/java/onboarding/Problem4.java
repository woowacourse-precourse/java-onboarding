package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer result = new StringBuffer();
        char ch;
        for(int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z') result.append((char)('a' + ('z' - ch)));
            else if(ch >= 'A' && ch <= 'Z') result.append((char)('A' + ('Z' - ch)));
            else result.append((char)ch);
        }
        String answer = result.toString();
        return answer;
    }
}
