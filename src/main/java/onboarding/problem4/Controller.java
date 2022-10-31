package onboarding.problem4;

public class Controller {
    public static String getSolution(String word) {
        if (Validation.check(word)) {
            return Word.getReverseWord(word);
        }
        return Constant.EXCEPTION;
    }
}