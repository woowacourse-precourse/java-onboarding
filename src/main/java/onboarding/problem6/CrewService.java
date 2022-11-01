package onboarding.problem6;

import java.util.*;

public class CrewService {
    private final Map<String, Crew> crewRepository;
    private final Map<String, Integer> usingNicknameRepository;

    public CrewService() {
        crewRepository = new HashMap<>();
        usingNicknameRepository = new HashMap<>();
    }

    public void saveAll(List<Crew> crewList) {
        crewList.forEach(crew -> crewRepository.put(crew.getEmail(), crew));
        crewList.forEach(this::saveSplitNickname);
        crewList.forEach(this::countUsingNickname);
    }

    private void saveSplitNickname(Crew crew) {
        String nickname = crew.getNickname();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String splitNickname = nickname.substring(i, i + 2);
            usingNicknameRepository.put(splitNickname, 0);
        }
    }

    private void countUsingNickname(Crew crew) {
        for (String splitNickname : usingNicknameRepository.keySet()) {
            if (crew.containSplitNickname(splitNickname)) {
                Integer count = getUsingCount(splitNickname);
                usingNicknameRepository.put(splitNickname, count + 1);
            }
        }
    }

    private Integer getUsingCount(String splitNickname) {
        return usingNicknameRepository.get(splitNickname);
    }

    public List<Crew> findDuplicateCrewList() {
        Set<Crew> duplicateCrewList = new HashSet<>();

        usingNicknameRepository.keySet().stream()
                .filter(usingNickname -> getUsingCount(usingNickname) > 1)
                .forEach(usingNickname -> {
                    crewRepository.values().stream()
                            .filter(crew -> crew.containSplitNickname(usingNickname))
                            .forEach(duplicateCrewList::add);
                });

        return new ArrayList<>(duplicateCrewList);
    }

}
