package onboarding.problem6;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FormValidation {
    private final static int EMAIL_MIN_LENGTH = 11;
    private final static int NICK_NAME_MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 20;
    private List<List<String>> forms;

    private FormValidation(List<List<String>> forms) {
        validateFormData(forms);
        this.forms = forms;
    }

    public static FormValidation from(List<List<String>> forms) {
        return new FormValidation(forms);
    }

    private void validateFormData(List<List<String>> forms) {
        int next = 0;
        String email;
        String nickName;
        while (next < forms.size()) {
            email = forms.get(next).get(0);
            nickName = forms.get(next).get(1);
            if (!validateEmail(email) || !validateNickName(nickName)) {
                forms.remove(next);
            } else {
                next += 1;
            }
        }
        for (List<String> form : forms) {
            System.out.println("form = " + form.toString());;
        }
    }

    private boolean validateEmail(String email) {
        if (email.length() < EMAIL_MIN_LENGTH || email.length() >= MAX_LENGTH){
            return false;
        }
        String pattern = "^[a-zA-Z0-9]+@email.com$";
        return email.matches(pattern);
    }

    private boolean validateNickName(String nickName) {
        if (nickName.length() < NICK_NAME_MIN_LENGTH || nickName.length() >= MAX_LENGTH){
            return false;
        }
        return nickName.matches("^[가-힣]*$");
    }


    public List<String> findEmailHavingDuplicationNickName() {
        // TODO: 공통으로 연속된 문자열을 가지는 닉네임을 찾는 기능
        return null;
    }

    private boolean hasCommonSubString(String srcString, String destString) {
        // TODO: 두 문자열이 2개 이상의 연속된 공통 문자열을 가지는지 검증하는 기능 
        return false;
    }
}
