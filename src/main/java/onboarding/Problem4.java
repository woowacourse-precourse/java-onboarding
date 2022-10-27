package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            answer.append(encryptChar(word.charAt(i)));
        }
        return answer.toString();
    }

    private static char encryptChar(char plainChar) {
        if(plainChar >= 65 && plainChar <= 90)
            return (char) ((90 - plainChar) + 65);
        else if(plainChar >= 97 && plainChar <= 122)
            return (char) ((122 - plainChar) + 97);
        else return plainChar;
    }
}
