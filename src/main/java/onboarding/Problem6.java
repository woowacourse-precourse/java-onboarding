package onboarding;

import static onboarding.Problem6.CrewNicknameChecker.calculateDuplicateCrews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return calculateDuplicateCrews(forms);
    }

    public static class CrewNicknameChecker {

        private static Map<String, String> partOfNicknameMap = new HashMap<>();
        private static Set<String> duplicateNicknameCrewSet = new HashSet<>();

        public static List<String> calculateDuplicateCrews(List<List<String>> forms) {
            partOfNicknameMap.clear();
            duplicateNicknameCrewSet.clear();

            List<Crew> crews = forms.stream().map(crew -> new Crew(crew.get(0), crew.get(1)))
                .collect(Collectors.toList());

            for (Crew crew : crews) {
                processDuplicateCrewNickname(crew);
            }
            return getAscSortedCrewEmails();
        }

        private static List<String> getAscSortedCrewEmails() {
            List<String> duplicateCrewEmail = new ArrayList<>(duplicateNicknameCrewSet);

            Collections.sort(duplicateCrewEmail);
            return duplicateCrewEmail;
        }

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