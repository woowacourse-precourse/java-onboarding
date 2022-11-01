package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            answer += getConvertAlphabet(word.charAt(i));
        }

        return answer;
    }

    private static char getConvertAlphabet(char c) {
        if(c == ' ') {
            return c;
        }

        if((int)c >= 97 && (int)c <= 122) {
            return (char)(219 - (int)c);
        }
        return (char)(155 - (int)c);
    }
}
