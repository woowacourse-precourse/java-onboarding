package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int wordLen = word.length();
        char ch;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < wordLen; i++) {
            ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z') result.append((char)('a' + ('z' - ch)));
            else if(ch >= 'A' && ch <= 'Z') result.append((char)('A' + ('Z' - ch)));
            else result.append((char)ch);
        }
        return result.toString();
    }
}