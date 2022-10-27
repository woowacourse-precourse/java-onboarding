package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeCharacterFromDictionary(word);
        return answer;
    }

    private static String changeCharacterFromDictionary(String word) {

        for (int i = 0; i < word.length(); i++) {
            searchForReverseCharacter(word.charAt(i));
        }
    }

    private static Character searchForReverseCharacter(char character) {
        if ((int) 'a' <= (int) character && (int) character <= (int) 'z') {
            return (char)((int)'a' + (int)'z' - (int)character);
        }

        if (((int) 'A' <= (int) character && (int) character <= (int) 'Z')) {
            return (char) ((int)'A' + (int)'Z' - (int)character);
        }
        return character;
    }
}
