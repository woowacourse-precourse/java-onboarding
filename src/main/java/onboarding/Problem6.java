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
        int[] indexs = new int[nicknameArr.length * 5];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
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
