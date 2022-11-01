package onboarding;

public class Problem4 {
    private static boolean isAlphabet(char c) {
        return (c >= (int)'a' && c <= (int)'z') || (c >= (int)'A' && c <= (int)'Z');
    }
    private static char transferChar(char c) {
        if(!isAlphabet(c)) return c;
        boolean upper = Character.isUpperCase(c);

        // transfer letter
        int letterIdx = 25 - (Character.toLowerCase(c) - 'a');
        c = (char)('a' + letterIdx);

        if(upper) c = Character.toUpperCase(c);
        return c;
    }
    public static String solution(String word) {
        String answer = "";
        for(char c: word.toCharArray()) {
            answer += transferChar(c);
        }
        return answer;
    }
}
