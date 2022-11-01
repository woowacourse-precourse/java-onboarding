package onboarding;

public class Problem2 {
    public static String removeDuplicatedCharacters(String cryptogram) {
        int index = 0;
        while (index < cryptogram.length() - 1) {
            char currentCharacter = cryptogram.charAt(index);
            char nextCharacter = cryptogram.charAt(index + 1);
            if (currentCharacter == nextCharacter) {
                cryptogram = cryptogram.replaceFirst(cryptogram.substring(index, index + 2), "");
                index -= 2;
            }
            index++;
        }

        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicatedCharacters(cryptogram);

        return answer;
    }
}
