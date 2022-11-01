package problem6.validator;

import java.util.Map;

public class ValidatorFactory {
    private final Map<String, String> forms;

    public ValidatorFactory(Map<String, String> froms) {
        this.forms = froms;
    }

    public void validate(int inputSize) {
        validateEmail(inputSize);
        validateNickName();
    }

    private void validateEmail(int inputSize) {
        EmailValidator emailValidator = new EmailValidator(forms);
        emailValidator.validate(inputSize);
    }

    private void validateNickName() {
        NickNameValidator nickNameValidator = new NickNameValidator(forms);
        nickNameValidator.validate();
    }
}
