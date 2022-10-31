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

    public static char letterConvert(char letter) {
        LetterType letterType = getLetterType(letter);

        switch (letterType) {
            case SMALL:
                return (char)('a' + 'z' - letter);
            case CAPITAL:
                return (char)('A' + 'Z' - letter);
            case NON_ALPHABET:
                return letter;
            default:
                throw new RuntimeException("Undefined Letter Type");
        }
    }
}
