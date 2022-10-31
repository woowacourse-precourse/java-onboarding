package onboarding;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    private static final Map<String, Integer> nicknameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        saveNicknameToMap(forms);

        List<String> answer = List.of("answer");
        return answer;
    }

    private static void saveNicknameToMap(List<List<String>> forms) {
        for (List<String> crew : forms) {
            String nickname = crew.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subStr = nickname.substring(i, i + 2);
                if (!nicknameMap.containsKey(subStr)) {
                    nicknameMap.put(subStr, 1);
                } else {
                    nicknameMap.put(subStr, nicknameMap.get(subStr) + 1);
                }
            }
        }
    }

}
