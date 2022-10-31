package onboarding;

import java.util.*;

public class Problem6 {
    public static final int EMAIL_IDX = 0;
    public static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerSet = new HashSet<>();
        getSimilarNicknameUser(forms, answerSet);

        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }

    private static void getSimilarNicknameUser(List<List<String>> forms, Set answerSet) {
        HashMap<String, List<Integer>> nicknameIncludingContinuousMap = new HashMap<>();

        for (int i = 0; i <= forms.size() - 1; i++) {
            String nickname = forms.get(i).get(NICKNAME_IDX);

            for (int j = 0; j <= nickname.length() - 2; j++) {
                char[] charArray = {nickname.charAt(j), nickname.charAt(j + 1)};
                String continuous = String.valueOf(charArray);

                getNicknameIncludingContinuousMap(nicknameIncludingContinuousMap, i, continuous);
            }
        }

        getSimilarNicknameEmailList(forms, answerSet, nicknameIncludingContinuousMap);
    }

    private static void getNicknameIncludingContinuousMap(HashMap<String, List<Integer>> nicknameIncludingContinuousMap, int i, String continuous) {
        if (nicknameIncludingContinuousMap.containsKey(continuous)) {
            nicknameIncludingContinuousMap.get(continuous).add(i);
        } else {
            nicknameIncludingContinuousMap.put(continuous, new ArrayList<>(List.of(i)));
        }
    }

    private static void getSimilarNicknameEmailList(List<List<String>> forms, Set answerSet, HashMap<String, List<Integer>> nicknameIncludingContinuousMap) {
        Iterator<String> iterator = nicknameIncludingContinuousMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            List<Integer> indices = nicknameIncludingContinuousMap.get(key);

            if (indices.size() >= 2) {
                for (int index : indices) {
                    answerSet.add(forms.get(index).get(EMAIL_IDX));
                }
            }
        }
    }

}
