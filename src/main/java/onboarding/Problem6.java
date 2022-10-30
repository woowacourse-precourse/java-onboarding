package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> crewInfo = new HashMap<>();
        Map<String, Integer> duplicatedNicknameCandidate = new HashMap<>();

        initializationCrewInfo(forms, crewInfo);

        for (String nickname : crewInfo.keySet()) {
            initializationDuplicatedNicknameCandidate(nickname, duplicatedNicknameCandidate);
        }

        return answer;
    }

    private static void initializationCrewInfo(List<List<String>> forms,
                                               Map<String, String> crewInfo) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            crewInfo.put(nickname, email);
        }
    }

    private static void initializationDuplicatedNicknameCandidate(String nickname,
                                                                  Map<String, Integer> duplicatedNicknameCandidate) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String substring = nickname.substring(i, j);

                duplicatedNicknameCandidate.put(substring,
                        duplicatedNicknameCandidate.getOrDefault(substring, 0) + 1);
            }
        }
    }
}
