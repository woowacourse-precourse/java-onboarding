package onboarding;

public class Problem4 {

    private boolean isAlphabet(char s) {
        if (Character.isLowerCase(s))
            return ('a' <= s) && (s <= 'z');
        else
            return ('A' <= s) && (s <= 'Z');
    }
    public char getFrogChar(char s) { // 26
        if (!isAlphabet(s))
            return s;

        if (Character.isLowerCase(s))
            return (char)('z' - (s - 'a'));
        else
            return (char)('Z' - (s - 'A'));
    }
    public static String solution(String word) {
        Problem4 prob = new Problem4();
        String answer = "";

        for(int i = 0; i < word.length(); i++)
        answer += Character.toString(prob.getFrogChar(word.charAt(i)));

        return answer;
    }
}
