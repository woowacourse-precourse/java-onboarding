package onboarding.problem2.utils.validator;

import onboarding.problem2.utils.validator.exception.NotLowerEnglishException;
import java.util.regex.Pattern;

public class NotLowerEnglishValidator {
    String word;

    public NotLowerEnglishValidator(String word) throws NotLowerEnglishException{
        this.word = word;
        validateNotEnglish();
    }

    private void validateNotEnglish() throws NotLowerEnglishException{
        String englishPattern = "^[a-z]*$";
        if(!Pattern.matches(englishPattern, word)){
            throw new NotLowerEnglishException("영어 이외의 다른 문자가 있음");
        }
    }
}
