package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Recommends maximum 5 new friends
 */
public class FriendRecommender {

    private String user;
    private List<List<String>> friends;
    private List<String> visitors;

    private final Map<String, List<String>> relationships = new HashMap<>();

    /**
     * Constructor with user, friends, visitors
     * @param user name of user
     * @param friends friend relationship list
     * @param visitors visitor names of user sns
     */
    public FriendRecommender(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }

    /**
     * Recommend new SNS friends (maximum 5)
     * @return new friend list
     */
    public List<String> recommend() {
        searchRelationships();
        Map<String, Friend> scores = new HashMap<>();
        List<String> userFriends = relationships.get(user);
        // Check user friends' friend list
        // Check visitors
        // Create candidate list sorted by score(name if same)
        // Create new friend list(maximum 5) and return
        return new ArrayList<>();
    }

    /**
     * Search relationships in friend list and add relationships
     */
    private void searchRelationships() {
        for (List<String> relationship : friends) {
            String idA = relationship.get(0);
            String idB = relationship.get(1);
            addRelationship(idA, idB);
            addRelationship(idB, idA);
        }
    }

    /**
     * Add friend idB to relationship list of friend idA
     * @param idA friend of idB
     * @param idB friend of idA
     */
    private void addRelationship(String idA, String idB) {
        if (relationships.containsKey(idA)) relationships.get(idA).add(idB);
        else relationships.put(idA, new ArrayList<>(List.of(idB)));
    }
}
