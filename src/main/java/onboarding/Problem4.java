package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static char convert(char currentChar) {

        if(!isAlphabet(currentChar))
            return currentChar;

        if(Character.isLowerCase(currentChar))
            return (char)('a' + ('z' - currentChar));

        return (char)('A' + ('Z' - currentChar));
    }

    static boolean isAlphabet(char c) {

        return ('a' <= c && c <= 'z')
                || ('A' <= c && c <= 'Z');
    }
}
