package onboarding.problem4;

public class TreeFrog {

    private final Dictionary dictionary;

    public TreeFrog(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String makeTreeFrogWord(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Character character : input.toCharArray()) {
            stringBuilder.append(dictionary.change(character));
        }
        return stringBuilder.toString();
    }

}
