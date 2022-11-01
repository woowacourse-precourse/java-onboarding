package onboarding;


import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * 문제 풀이 방식 & 기능 목록서는
 * docs/PROBLEM4.md 의 하단에 기술되어 있습니다
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            sb.append(convertChar(word.charAt(i)));
        }
        return sb.toString();
    }

    private static char convertChar(char character) {
        if(isLowerCase(character)) return convertLowerCase(character);
        else if(isUpperCase(character))return convertUpperCase(character);
    }

    private static char convertUpperCase(char character) {
        int gap = character - 'A';
        int newChar = 'Z' - gap;
        return (char) newChar;
    }

    private static char convertLowerCase(char character) {
        int gap = character - 'a';
        int newChar = 'z' - gap;
        return (char) newChar;
    }


}
