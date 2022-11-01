package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder wordStr = new StringBuilder(word);

        for (int i = 0; i < wordStr.length(); i++) {
            wordStr.setCharAt(i, dictionary(wordStr.charAt(i)));
        }

        answer = wordStr.toString();

        return answer;
    }

    private static char dictionary(char character) {
        int charInt = character;

        if (charInt == 32) {
            return character;
        }
        if (charInt < 97) {
            character = (char) (charInt + (90 - charInt) - (charInt - 65));
        } else {
            character = (char) (charInt + (97 - charInt) - (charInt - 122));
        }

        return character;
    }
}
