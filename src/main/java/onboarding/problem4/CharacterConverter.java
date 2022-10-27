package onboarding.problem4;

public class CharacterConverter {

    public static final int LOWERCASE_SUM = 219;  // 소문자의 문자 간 합은 219입니다.
    public static final int UPPERCASE_SUM = 155;  // 대문자의 문자 간 합은 155입니다.

    public char reverseCharacter(char character) {
        if (character == ' ') {
            return character;
        }

        if (isUpperCase(character)) {
            return (char) (UPPERCASE_SUM - character);
        } else if (isLowerCase(character)) {
            return (char) (LOWERCASE_SUM - character);
        }

        throw new IllegalArgumentException("공백 혹은 알파벳만 입력할 수 있습니다.");
    }

    private boolean isUpperCase(char character) {
        return 'A' <= character && character <= 'Z';
    }

    private boolean isLowerCase(char character) {
        return 'a' <= character && character <= 'z';
    }
}
