package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] nicknameArr = fillNicknameArr(forms);
        checkIndexAndNickname(nicknameArr);
        return answer;
    }

    private static void checkIndexAndNickname(String[] nicknameArr) {
        String[] duplicateNicknames = new String[nicknameArr.length];
        int checkIndex = 0;

        for (int i = 0; i < nicknameArr.length; i++) {
            for (int j = 0; j < nicknameArr[i].length(); j++) {
                for (int k = 0; k < nicknameArr[j].length(); k++) {

                }
            }
        }
    }

    private static String[] fillNicknameArr(List<List<String>> forms) {
        String[] nicknames = new String[forms.size()];
        int idx = 0;

        for (List<String> i : forms) {
            nicknames[idx] = i.get(1);
            idx++;
        }

        return nicknames;
    }
}
