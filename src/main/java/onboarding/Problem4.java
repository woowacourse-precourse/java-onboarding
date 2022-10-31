package onboarding;

public class Problem4 {
    public static char changeChar(char c, String alphabets) {
        int charIndex = alphabets.indexOf(c);
        int changeCharIndex = alphabets.length() - 1 - charIndex;

        return alphabets.charAt(changeCharIndex);
    }
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int index = 0; index < word.length(); index++) {
            char originChar = word.charAt(index);
            char newChar = originChar;

            if (Character.isUpperCase(originChar))
                newChar = changeChar(originChar, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            else if (Character.isLowerCase(originChar))
                newChar = changeChar(originChar, "abcdefghijklmnopqrstuvwxyz");
            answer.append(newChar);
        }
        return answer.toString();
    }
}
