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
            if(isConfirmListContainsWord(forms.get(i).get(1))) {
                answer.add(forms.get(i).get(0));
            }
            nicknames.add(forms.get(i).get(1));
        }
    }

    private static boolean isConfirmListContainsWord(String nickname) {
        for (String value : nicknames) {
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
