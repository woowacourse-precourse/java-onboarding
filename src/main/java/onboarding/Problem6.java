package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static class CrewNicknameChecker {

        private static Map<String, String> partOfNicknameMap = new HashMap<>();
        private static Set<String> duplicateNicknameCrewSet = new HashSet<>();

        private static void processDuplicateCrewNickname(Crew crew) {
            String nickname = crew.getNickname();
            int nicknameLength = nickname.length();

            if (nicknameLength < 2) {
                return;
            }
            for (int i = 1; i < nicknameLength; i++) {
                String partOfNickname = nickname.substring(i - 1, i + 1);

                if (partOfNicknameMap.containsKey(partOfNickname)) {
                    duplicateNicknameCrewSet.add(partOfNicknameMap.get(partOfNickname));
                    duplicateNicknameCrewSet.add(crew.getEmail());
                    continue;
                }
                partOfNicknameMap.put(partOfNickname, crew.getEmail());
            }
        }
    }
}

class Crew {

    private String email;
    private String nickname;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}