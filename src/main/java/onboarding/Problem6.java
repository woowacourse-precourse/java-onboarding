package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static final int EMAIL_IDX = 0;
    public static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void getSimilarNicknameUser(List<List<String>> forms) {
        HashMap<String, List<Integer>> nicknameIncludingContinuousMap = new HashMap<>();

        for (int i = 0; i <= forms.size() - 1; i++) {
            String nickname = forms.get(i).get(NICKNAME_IDX);

            for (int j = 0; j <= nickname.length() - 2; j++) {
                char[] charArray = {nickname.charAt(j), nickname.charAt(j + 1)};
                String continuous = String.valueOf(charArray);

                getNicknameIncludingContinuousMap(nicknameIncludingContinuousMap, i, continuous);
            }
        }
    }

    private static void getNicknameIncludingContinuousMap(HashMap<String, List<Integer>> nicknameIncludingContinuousMap, int i, String continuous) {
        if (nicknameIncludingContinuousMap.containsKey(continuous)) {
            nicknameIncludingContinuousMap.get(continuous).add(i);
        } else {
            nicknameIncludingContinuousMap.put(continuous, new ArrayList<>(List.of(i)));
        }
    }
}
