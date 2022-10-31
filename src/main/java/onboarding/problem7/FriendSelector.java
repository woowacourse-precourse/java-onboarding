package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FriendSelector {

    private final Map<String, Friend> candidateMap;

    public FriendSelector(Map<String, Friend> candidateMap) {
        this.candidateMap = candidateMap;
    }

    public List<String> select() {
        List<Friend> candidates = sortCandidates();
        List<String> friends = new ArrayList<>();
        for (Friend candidate : candidates) {
            friends.add(candidate.getName());
            if (friends.size() == 5) break;
        }
        return friends;
    }

    private List<Friend> sortCandidates() {
        ArrayList<Friend> candidates = new ArrayList<>(candidateMap.values());
        candidates.sort((o1, o2) -> o1.getScore() == o2.getScore() ? o1.getName().compareTo(o2.getName()) : o2.getScore() - o1.getScore());
        return candidates;
    }
}
