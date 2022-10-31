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
        if(plainChar >= 65 && plainChar <= 90)
            return (char) ((90 - plainChar) + 65);
        else if(plainChar >= 97 && plainChar <= 122)
            return (char) ((122 - plainChar) + 97);
        else return plainChar;
    }
}
