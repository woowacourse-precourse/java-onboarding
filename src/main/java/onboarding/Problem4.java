package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder newWord = new StringBuilder();
        for (char c : word.toCharArray()){
            if (c == ' '){
                newWord.append(' ');
                continue;
            }
            if ('A' <= c && c <= 'Z')
                newWord.append((char)('Z' - (c - 'A')));
            else if ('a' <= c && c <= 'z')
                newWord.append((char)('z' - (c - 'a')));
        }
        return newWord.toString();
    }
}
