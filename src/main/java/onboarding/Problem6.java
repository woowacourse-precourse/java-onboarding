package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] nicknameArr = fillNicknameArr(forms);
        System.out.println("nicknameArr = " + Arrays.toString(nicknameArr));
        checkIndexAndNickname(nicknameArr);
        return answer;
    }

    private static void checkIndexAndNickname(String[] nicknameArr) {
        String[] duplicateNicknames = new String[nicknameArr.length];
        int checkIndex = 0;
        for (int i = 0; i < nicknameArr.length - 1; i++) {
            for (int j = 0; j < nicknameArr[i].length(); j++) {
                if (nicknameArr[i].charAt(j) == nicknameArr[i + 1].charAt(j)) {
                }
            }
        }

        System.out.println("duplicateNicknames = " + Arrays.toString(duplicateNicknames));
    }

    private static String[] fillNicknameArr(List<List<String>> forms) {
        String[] nicknames = new String[forms.size()];
        int idx = 0;
        for (List<String> i : forms) {
            if (i.get(1).length() > 1 || i.get(1).length() < 20) {
                int i1 = 19 - i.get(1).length();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i1; j++) {
                    builder.append(j);
                }
                nicknames[idx] = i.get(1) + builder;
            }
            idx++;
        }

        return nicknames;
    }
}
