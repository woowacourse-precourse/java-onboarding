package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++)
            answer.append(change(word.charAt(i)));
        return answer.toString();
    }
    static char change(char c){
        if (isSmallLetter(c)) return (char)('a' + 'z' - c);
        if (isCapitalLetter(c)) return (char)('A' + 'Z' - c);
        return c;
    }
    static boolean isSmallLetter (char c) { return 'a' <= c && c <= 'z'; }
    static boolean isCapitalLetter (char c) { return 'A' <= c && c <= 'Z'; }
}
