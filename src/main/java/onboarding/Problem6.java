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
    }

    private static void checkNicknameInForms(List<List<String>> forms) {
        for(int i=1; i<forms.size(); i++) {
            if(isConfirmListContainsWord(forms.get(i).get(1))) {
                duplicatedEmails.add(forms.get(i).get(0));
            }
            confirm.add(forms.get(i).get(1));
        }
    }

    private static boolean isConfirmListContainsWord(String nickname) {
        for (String value : confirm) {
            for (int j = 0; j < nickname.length(); j++) {
                if (value.contains(String.valueOf(nickname.charAt(j)))) {
                    String s = nickname.substring(j, j + 2);
                    if (value.contains(s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
