package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static int getAscii(char c){
        return (int)c;
    }
    private static char changeWord(int c){
        if ((int)'A' <= c && c <= (int)'Z'){
            return changeBigCh(c);
        }
        if ((int)'a' <= c && c <= (int)'z') {
            return changeSmallCh(c);
        }
        return '\0';
    }
    private static char changeBigCh(int c) {
        return (char) ((-1 * (c - 65)) + (int) 'Z');
    }

    private static char changeSmallCh(int c) {
        return (char) ((-1 * (c - 97)) + (int) 'z');
    }
}
