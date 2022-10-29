package onboarding.problem4;

public class GreenFrog {

    private String reverseWord;

    public GreenFrog(String word) {
        this.reverseWord = word;
    }

    public String answer(Dictionary dictionary) {
        return dictionary.reverseString(reverseWord);
    }
}
