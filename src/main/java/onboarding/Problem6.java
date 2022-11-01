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

    private static void getRepeatedSubnicknamesInNickname(List<List<String>> forms, String nickName,
        List<String> answer) {
        for (int elementLength = 2; elementLength <= nickName.length(); ++elementLength) {
            for (int index = 0; index < nickName.length() - (elementLength - 1); index++) {
                String subNickName = "";
                subNickName = nickName.substring(index, index + elementLength);
                getReapeatedMatchedNicknameInForms(answer, forms, subNickName);
            }
        }
    }
}
