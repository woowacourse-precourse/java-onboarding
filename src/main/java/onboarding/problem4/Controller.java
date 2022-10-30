package onboarding.problem4;

public class Controller {
    public static String getSolution(String word) {
        if (Validation.check(word)) {
            String result = Word.getReverseWord(word);
            return result;
        }
        return Constant.EXCEPTION;
    }
}