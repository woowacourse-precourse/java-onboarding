package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<String> confirm;
    private static List<String> duplicatedEmails;

    public static List<String> solution(List<List<String>> forms) {
        initSystem(forms);
        checkNicknameInForms(forms);
        return duplicatedEmails;
    }

    private static void initSystem(List<List<String>> forms) {
        confirm = new ArrayList<>();
        confirm.add(forms.get(0).get(1));
        duplicatedEmails = new ArrayList<>();
        duplicatedEmails.add(forms.get(0).get(0));
    }

    private static void checkNicknameInForms(List<List<String>> forms) {
        for(int i=1; i<forms.size(); i++) {
            for(int j=0; j<forms.get(i).size(); j++) {
                //TODO : checkConfirmListWordContains 구현
            }
        }
    }
}
