package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<String> nicknames;
    private static List<String> answer;

    public static List<String> solution(List<List<String>> forms) {
        initSystem(forms);
        checkNicknameInForms(forms);
        return answer;
    }

    private static void initSystem(List<List<String>> forms) {
        nicknames = new ArrayList<>();
        nicknames.add(forms.get(0).get(1));
        answer = new ArrayList<>();
    }

    private static void checkNicknameInForms(List<List<String>> forms) {
        for(int i=1; i<forms.size(); i++) {
            if(isNicknamesContainsNickname(forms.get(i).get(1))) {
                answer.add(forms.get(i).get(0));
            }
            nicknames.add(forms.get(i).get(1));
        }
    }

    private static boolean isNicknamesContainsNickname(String nickname) {
        for (String name : nicknames) {
            for (int i = 0; i < nickname.length(); i++) {
                if (name.charAt(i) == nickname.charAt(i)) {
                    if(name.charAt(i+1) == nickname.charAt(i+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
