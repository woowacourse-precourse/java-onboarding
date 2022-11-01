package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] array = word.toCharArray();
        for (char character : array) {
            answer += reverseAlphabet(character);
        }

        return answer;
    }

    private static char reverseAlphabet(char character) {
        if ((65 <= character && character <= 90) || (97 <= character && character <= 122)) {
            if (Character.isUpperCase(character)) {
                character = (char)(65 + 90 - character);
            } else {
                character = (char)(97 + 122 - character);
            }
        }
        return character;
    }
}
