package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Select new friends from candidates
 */
public class FriendSelector {

    private final Map<String, Friend> candidateMap;

    /**
     * Constructor with candidates
     *
     * @param candidateMap new friend candidates
     */
    public FriendSelector(Map<String, Friend> candidateMap) {
        this.candidateMap = candidateMap;
    }

    /**
     * Select maximum 5 friends
     *
     * @return new friend list
     */
    public List<String> select() {
        List<Friend> candidates = sortCandidates();
        List<String> friends = new ArrayList<>();
        for (Friend candidate : candidates) {
            friends.add(candidate.getName());
            if (friends.size() == 5) break;
        }
        return friends;
    }

    /**
     * Extract candidate list from candidate map and sort(descending order of score -> if same ascending order of name)
     *
     * @return list of friend candidates sorted
     */
    private List<Friend> sortCandidates() {
        ArrayList<Friend> candidates = new ArrayList<>(candidateMap.values());
        candidates.sort((o1, o2) -> o1.getScore() == o2.getScore() ? o1.getName().compareTo(o2.getName()) : o2.getScore() - o1.getScore());
        return candidates;
    }
}
