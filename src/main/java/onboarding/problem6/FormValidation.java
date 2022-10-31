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
        int formsSize = forms.size();
        // Email 의 중복을 제거하고 오름 차순으로 정렬하기 위해 TreeSet을 사용
        Set<String> duplicationCrewEmail = new TreeSet<>();
        for (int i = 0; i < formsSize - 1; i++) {
            for (int j = i + 1; j < formsSize; j++) {
                if (hasCommonSubString(forms.get(i).get(1), forms.get(j).get(1))) {
                    duplicationCrewEmail.add(forms.get(i).get(0));
                    duplicationCrewEmail.add(forms.get(j).get(0));
                }
            }
        }
        return duplicationCrewEmail.stream().collect(Collectors.toList());
    }

    private boolean hasCommonSubString(String srcString, String destString) {
        for (int i = 0; i < srcString.length() - 1; i++) {
            for (int j = 0; j < destString.length() - 1; j++) {
                if (srcString.charAt(i) == destString.charAt(j)
                        && srcString.charAt(i + 1) == destString.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
