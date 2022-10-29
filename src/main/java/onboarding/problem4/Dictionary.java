package onboarding.problem4;

public class Dictionary {

    private Validation validation;

    public Dictionary(String word) {
        validation = new Validation(word);
    }

    // 로직 미구현
    public String reverseString(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word is Null!!");
        }




        return "";
    }
}
