package onboarding;

import onboarding.problem6.controller.DuplicatedNickNameSearch;
import onboarding.problem6.utils.validator.InputFormValidator;
import onboarding.problem6.utils.validator.exception.InputFormException;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new DuplicatedNickNameSearch().setNewForms(forms).checkAllCrewForm().getDuplicatedNicknameCrewEmail();
        return answer;
    }
}
