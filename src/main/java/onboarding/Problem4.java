package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return encryptByFrogDict(word);
    }

    private static String encryptByFrogDict(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            stringBuilder.append(encryptCharByFrogDict(word.charAt(i)));
        }
        return stringBuilder.toString();
    }

    private static char encryptCharByFrogDict(char plainChar) {
        if(plainChar >= 'a' && plainChar <= 'z')
            return (char) (('z' - plainChar) + 'a');
        else if(plainChar >= 'A' && plainChar <= 'z')
            return (char) (('Z' - plainChar) + 'A');
        else return plainChar;
    }
}
