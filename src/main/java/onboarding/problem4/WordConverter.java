package onboarding.problem4;

public class WordConverter {

    public String convertWord(String word) {
        StringBuilder convertedWord = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            char convertedCharacter = convertWithDictionary(letter);
            convertedWord.append(convertedCharacter);
        }
        return convertedWord.toString();
    }

    private char convertWithDictionary(char letter) {


    }
}
