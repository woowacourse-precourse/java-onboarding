package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendRecommender {

    private final CandidateIntroducer introducer;
    private final Map<String, List<String>> relationships = new HashMap<>();

    public FriendRecommender(String user, List<List<String>> friends, List<String> visitors) {
        addRelationships(friends);
        introducer = new CandidateIntroducer(user, visitors, relationships);
    }

    public List<String> recommend() {
        Map<String, Friend> candidateMap = introducer.introduce();
        FriendSelector selector = new FriendSelector(candidateMap);
        return selector.select();
    }

    private void addRelationships(List<List<String>> friends) {
        for (List<String> relationship : friends) {
            String idA = relationship.get(0);
            String idB = relationship.get(1);
            addRelationship(idA, idB);
            addRelationship(idB, idA);
        }
    }

    private void addRelationship(String idA, String idB) {
        if (relationships.containsKey(idA)) relationships.get(idA).add(idB);
        else relationships.put(idA, new ArrayList<>(List.of(idB)));
    }
}
