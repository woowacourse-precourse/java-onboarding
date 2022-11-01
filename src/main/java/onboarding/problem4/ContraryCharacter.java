package onboarding.problem4;

public class ContraryCharacter {
    private final Character character;

    public ContraryCharacter(final Character character) {
        this.character = this.reverse(character);
    }

    private Character reverse(final char character) {
        if (!Character.isAlphabetic(character)) {
            return character;
        }
        int convertedCharacter = (int) character;
        if (Character.isLowerCase(character)) {
            return (char) (122 - (convertedCharacter - 97));
        }
        if (Character.isUpperCase(character)) {
            return (char) (90 - (convertedCharacter - 65));
        }
        return character;
    }

    public Character character() {
        return character;
    }
}
