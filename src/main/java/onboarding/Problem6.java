package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static Map<String, String> createNicknameMap(List<List<String>> forms) {
        HashMap<String, String> nicknameMap = new HashMap<>();

        for (List<String> emailNickname: forms) {
            String email = emailNickname.get(0);
            String nickname = emailNickname.get(1);

            nicknameMap.put(email, nickname);
        }

        return nicknameMap;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
