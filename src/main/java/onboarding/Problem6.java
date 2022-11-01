package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        getRepeatedNicknamesInForms(forms, answer);

        return answer;
    }

    private static void getRepeatedNicknamesInForms(List<List<String>> forms, List<String> answer) {
        for (List<String> form : forms) {
            String nickName = form.get(1);
            if (nickName.length() >= 2) {
                getRepeatedSubnicknamesInNickname(forms, nickName, answer);
            }
        }
    }
}
