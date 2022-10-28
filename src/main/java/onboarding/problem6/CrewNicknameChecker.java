package onboarding.problem6;

import static onboarding.problem6.consts.FormIndexConst.FORM_EMAIL_INDEX;
import static onboarding.problem6.consts.FormIndexConst.FORM_NICKNAME_INDEX;
import static onboarding.problem6.consts.NicknameConst.NICKNAME_DUPLICATE_START_INDEX;
import static onboarding.problem6.consts.NicknameConst.NICKNAME_MINIMUM_LENGTH;
import static onboarding.problem6.consts.NicknameConst.PART_OF_NICKNAME_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CrewNicknameChecker {

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
