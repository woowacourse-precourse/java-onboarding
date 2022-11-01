package onboarding;

public class Problem4 {

    private static final String spelling = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Character convert(Character originalChar) {
        if (!isAlphabat(originalChar)) {
            return originalChar;
        }
        Integer position = spelling.indexOf(Character.toUpperCase(originalChar));
        Character convertCharacter = spelling.charAt((spelling.length()-1) - position);
        return convertCase(originalChar, convertCharacter);
    }

    public static Character convertCase(Character originalChar, Character convertedChar) {
        if (Character.isUpperCase(originalChar)) {
            return Character.toUpperCase(convertedChar);
        }
        return Character.toLowerCase(convertedChar);
    }

    public static boolean isAlphabat (Character character) {
        return (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z');
    }

    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length(); i++) {
            answer += convert(word.charAt(i));
        }
        return answer;
    }

}
