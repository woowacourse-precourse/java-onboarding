package onboarding.domain.problem4;

public class Frog {
    private Word word;
    public Frog(String word) {
        this.word = new Word(word);
    }

    public char change(char alphabet) {
        if (Character.isUpperCase(alphabet))
            return (char)(155 - alphabet);
        return (char)(219 - alphabet);
    }
}
