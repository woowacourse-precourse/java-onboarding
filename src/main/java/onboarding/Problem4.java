package onboarding;

public class Problem4 {
    public static String solution(String word) {

        return null;
    }

    private static char getAlphabat(char character) {
        if ('A' <= character && character <= 'Z') {
            return (char)(155 - character);
        }
        if ('a' <= character && character <= 'z') {
            return (char)(219 - character);
        }

        return character;
    }
}
