package onboarding;

import static onboarding.Problem6.CrewNicknameChecker.calculateDuplicateCrews;
import static onboarding.Problem6.FormIndexConst.FORM_EMAIL_INDEX;
import static onboarding.Problem6.FormIndexConst.FORM_NICKNAME_INDEX;
import static onboarding.Problem6.NicknameConst.NICKNAME_DUPLICATE_START_INDEX;
import static onboarding.Problem6.NicknameConst.NICKNAME_MINIMUM_LENGTH;
import static onboarding.Problem6.NicknameConst.PART_OF_NICKNAME_RANGE;

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

            List<Crew> crews = forms.stream()
                .map(crew -> new Crew(crew.get(FORM_EMAIL_INDEX), crew.get(FORM_NICKNAME_INDEX)))
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
            for (int i = NICKNAME_DUPLICATE_START_INDEX; i < nickname.length(); i++) {
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
            return nickname.length() < NICKNAME_MINIMUM_LENGTH;
        }

        private static String calculatePartOfNickname(String nickname, int index) {
            return nickname.substring(index - PART_OF_NICKNAME_RANGE,
                index + PART_OF_NICKNAME_RANGE);
        }
    }

    public abstract class FormIndexConst {

        public static final int FORM_EMAIL_INDEX = 0;
        public static final int FORM_NICKNAME_INDEX = 1;
    }

    public abstract class NicknameConst {

        public static final int NICKNAME_DUPLICATE_START_INDEX = 1;
        public static final int PART_OF_NICKNAME_RANGE = 1;
        public static final int NICKNAME_MINIMUM_LENGTH = 2;
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