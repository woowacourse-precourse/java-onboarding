package problem4;

public class LetterConverter {
    private enum LetterType{
        SMALL, CAPITAL, NON_ALPHABET,
    }

    private static LetterType getLetterType(char letter){
        if(letter>='a' && letter <= 'z') return LetterType.SMALL;
        else if(letter >= 'A' && letter <= 'Z') return LetterType.CAPITAL;
        else return LetterType.NON_ALPHABET;
    }
}
