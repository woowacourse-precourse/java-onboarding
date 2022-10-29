package onboarding.problem2.utils.validator;

import onboarding.problem2.utils.validator.exception.NotEnglishException;

import java.util.regex.Pattern;

public class NotEnglishStringValidator {
    String word;

    public NotEnglishStringValidator(String word) throws NotEnglishException{
        this.word = word;

    }

    private void validateNotEnglish() throws NotEnglishException{
        String englishPattern = "^[a-zA-Z]*$";
        if(!Pattern.matches(englishPattern, word)){
            throw new NotEnglishException("영어 이외의 다른 문자가 있음");
        }
    }
}
