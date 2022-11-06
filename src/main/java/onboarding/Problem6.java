package onboarding;

import java.util.List;

import onboarding.nicknamevalidator.NickNameValidator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NickNameValidator validator = new NickNameValidator(forms);
        return validator.getInvalidEmails();
    }
}
