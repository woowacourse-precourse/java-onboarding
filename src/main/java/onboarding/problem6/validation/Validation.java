package onboarding.problem6.validation;

import java.util.List;
import onboarding.problem6.NickNameSystem;

public class Validation {
    private static final int MIN_NUMBER_OF_USERS = 1;
    private static final int MAX_NUMBER_OF_USERS = 10_000;
    private static final String USERS_EXCEPTION_MESSAGE = "크루의 인원 수는 1 ~ 10,000이어야 합니다.";

    public static void validate(List<List<String>> forms) {
        validateNumberOfUsers(forms);
        for (List<String> form : forms) {
            EmailValidation.validate(form.get(NickNameSystem.EMAIL));
            NickNameValidation.validate(form.get(NickNameSystem.NICK_NAME));
        }
    }

    private static void validateNumberOfUsers(List<List<String>> forms) {
        if ((forms.size() < MIN_NUMBER_OF_USERS) || (forms.size() > MAX_NUMBER_OF_USERS)) {
            throw new IllegalArgumentException(USERS_EXCEPTION_MESSAGE);
        }
    }
}
