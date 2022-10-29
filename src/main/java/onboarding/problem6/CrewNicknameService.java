package onboarding.problem6;

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

public class CrewNicknameService {

    private final Map<String, String> partOfNicknameMap;
    private final Set<String> duplicateNicknameCrewSet;
    private final CrewRepository crewRepository;

    public CrewNicknameService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
        this.partOfNicknameMap = new HashMap<>();
        this.duplicateNicknameCrewSet = new HashSet<>();
    }

    public List<String> calculateDuplicateCrews() {
        crewRepository.findAllCrewStream().forEach(this::processDuplicateCrewNickname);

        return getAscSortedCrewEmails();
    }

    private void processDuplicateCrewNickname(Crew crew) {
        String nickname = crew.getNickname();

        if (validateNickname(nickname)) {
            return;
        }
        for (int i = NICKNAME_DUPLICATE_START_INDEX; i < nickname.length(); i++) {
            String partOfNickname = calculatePartOfNickname(nickname, i);

            checkDuplicateCrewNickname(crew, partOfNickname);
        }
    }

    private void checkDuplicateCrewNickname(Crew crew, String partOfNickname) {
        if (partOfNicknameMap.containsKey(partOfNickname)) {
            addDuplicateCrew(crew, partOfNicknameMap.get(partOfNickname));
            return;
        }
        partOfNicknameMap.put(partOfNickname, crew.getEmail());
    }

    private void addDuplicateCrew(Crew crew, String email) {
        duplicateNicknameCrewSet.add(email);
        duplicateNicknameCrewSet.add(crew.getEmail());
    }

    private boolean validateNickname(String nickname) {
        return nickname.length() < NICKNAME_MINIMUM_LENGTH;
    }

    private String calculatePartOfNickname(String nickname, int index) {
        return nickname.substring(index - PART_OF_NICKNAME_RANGE, index + PART_OF_NICKNAME_RANGE);
    }

    private List<String> getAscSortedCrewEmails() {
        List<String> duplicateCrewEmail = new ArrayList<>(duplicateNicknameCrewSet);

        Collections.sort(duplicateCrewEmail);
        return duplicateCrewEmail;
    }
}
