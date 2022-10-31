package onboarding.problem6.finder;

import onboarding.problem6.crew.Crew;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateWarningCrewFinder implements CrewFinder {
    private Map<String, Set<String>> nicknameSubsetEmailMap;
    private Set<String> warningEmailSet;

    @Override
    public List<String> findCrews(List<Crew> crews) {
        nicknameSubsetEmailMap = new HashMap<>();
        warningEmailSet = new HashSet<>();

        for (Crew crew : crews) {
            updateNicknameSubsetEmailMap(crew);
        }

        for (String key : nicknameSubsetEmailMap.keySet()) {
            updateWarningEmailSet(key);
        }

        return new ArrayList<>(warningEmailSet)
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private Set<String> getNickNameSubset(String nickname) {
        if (nickname.length() == 1) {
            return new HashSet<>(List.of(nickname));
        }

        Set<String> nickNameSubset = new HashSet<>();
        String[] splitNickname = nickname.split("");
        for (int index = 0; index < splitNickname.length - 1; index++) {
            nickNameSubset.add(splitNickname[index] + splitNickname[index + 1]);
        }

        return nickNameSubset;
    }

    private void updateNicknameSubsetEmailMap(Crew crew) {
        Set<String> nicknameSubset = getNickNameSubset(crew.getNickname());
        for (String word : nicknameSubset) {
            Set<String> emailSet = nicknameSubsetEmailMap.getOrDefault(word, new HashSet<>());
            emailSet.add(crew.getEmail());
            nicknameSubsetEmailMap.put(word, emailSet);
        }
    }

    private void updateWarningEmailSet(String key) {
        Set<String> emails = nicknameSubsetEmailMap.get(key);
        if (emails.size() > 1) {
            warningEmailSet.addAll(emails);
        }
    }

}
