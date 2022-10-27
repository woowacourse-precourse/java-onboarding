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

            if (validateNickname(nickname)) {
                return;
            }
            for (int i = 1; i < nickname.length(); i++) {
                String partOfNickname = calculatePartOfNickname(nickname, i);

                if (partOfNicknameMap.containsKey(partOfNickname)) {
                    addDuplicateCrew(crew, partOfNicknameMap.get(partOfNickname));
                    continue;
                }
                partOfNicknameMap.put(partOfNickname, crew.getEmail());
            }
        }

        private static void addDuplicateCrew(Crew crew, String email) {
            duplicateNicknameCrewSet.add(email);
            duplicateNicknameCrewSet.add(crew.getEmail());
        }

        private static boolean validateNickname(String nickname) {
            return nickname.length() < 2;
        }

        private static String calculatePartOfNickname(String nickname, int index) {
            return nickname.substring(index - 1, index + 1);
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