package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        char[] characters = word.toCharArray();
        for (char character : characters) {
            char changedCharacter = change(character);
            answer.append(changedCharacter);
        }

        return answer.toString();
    }

    public static char change(char originalCharacter) {
        if (Character.isUpperCase(originalCharacter)) {
            return changeUpperCase(originalCharacter);
        } else if (Character.isLowerCase(originalCharacter)) {
            return changeLowerCase(originalCharacter);
        } else {
            return originalCharacter;
        }
    }

    public static char changeLowerCase(char originalCharacter) {
        char changedCharacter = (char) ((25 - (originalCharacter - 97)) + 97);
        return changedCharacter;
    }

    public static char changeUpperCase(char originalAlphabet) {
        char changedAlphabet = (char) ((25 - (originalAlphabet - 65)) + 65);
        return changedAlphabet;
    }
}
