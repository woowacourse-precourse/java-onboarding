package onboarding.problem6;

import java.util.*;

public class Crews {

    private final int MAX_CREWS_SIZE = 10_000;

    private List<Crew> crews;

    public Crews() {
        crews = new LinkedList<>();
    }

    public boolean add(Crew crew) {

        if (crews.size() == MAX_CREWS_SIZE) return false;

        crews.add(crew);
        return true;
    }

    private Map<String, Set<Crew>> getDuplicateNicknameMap() {
        Map<String, Set<Crew>> map = new HashMap<>();

        for (Crew crew : crews) {
            List<String> partOfNickname = crew.getPartOfNickname();
            for (String nickname : partOfNickname) {
                if (!map.containsKey(nickname)) {
                    map.put(nickname, new HashSet<>());
                }
                map.get(nickname).add(crew);
            }
        }

        return map;
    }
}
