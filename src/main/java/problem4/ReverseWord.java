package problem4;

public class ReverseWord {
    private final String word;
    private final String lowerAlphabet;
    private final String upperAlphabet;

    public ReverseWord(String word) {
        this.word = word;
        this.lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        this.upperAlphabet = lowerAlphabet.toUpperCase();

        Validator validator = new Validator(word);
        validator.validate();
    }

    public String reverse() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char reverseCharacter = getReverseCharacter(i);
            result.append(reverseCharacter);
        }
        return result.toString();
    }

    private char getReverseCharacter(int index) {
        if(isOtherCase(index)) {
            return word.charAt(index);
        }
        if(isLowerCase(index)) {
            return reverseCharacter(lowerAlphabet, index);
        }
        return reverseCharacter(upperAlphabet, index);
    }

    private char reverseCharacter(String alphabet, int index) {
        int originalIndex = alphabet.indexOf(word.charAt(index));
        int reverseIndex = alphabet.length() - (1 + originalIndex);

        return alphabet.charAt(reverseIndex);
    }

    private boolean isOtherCase(int index) {
        return !(isLowerCase(index) || isUpperCase(index));
    }

    private boolean isLowerCase(int index) {
        char character = word.charAt(index);
        return Character.isLowerCase(character);
    }

    private boolean isUpperCase(int index) {
        char character = word.charAt(index);
        return Character.isUpperCase(character);
    }
}
