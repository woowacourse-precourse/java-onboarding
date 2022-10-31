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
    private final Map<String, Friend> scores = new HashMap<>();


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
        addRelationships();
        
        List<String> userFriends = relationships.get(user);
        introduceFriends(userFriends);
        introduceVisitors(userFriends);
        // Create candidate list sorted by score(name if same)
        // Create new friend list(maximum 5) and return
        return new ArrayList<>();
    }

    /**
     * Search relationships in friend list and add relationships
     */
    private void addRelationships() {
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

    /**
     * Introduce new friends in current friends' friends
     * @param userFriends current friend list of user
     */
    private void introduceFriends(List<String> userFriends) {
        for (String name : relationships.keySet()) {
            if (userFriends.contains(name)) {
                List<String> nameFriends = relationships.get(name);
                for (String nameFriend : nameFriends) {
                    if (nameFriend.equals(user) || userFriends.contains(nameFriend)) continue;
                    scores.put(nameFriend, scores.getOrDefault(nameFriend, new Friend(nameFriend)).addScore(10));
                }
            }
        }
    }

    /**
     * Introduce visitors of user's SNS
     * @param userFriends current friend list of user
     */
    private void introduceVisitors(List<String> userFriends) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) break;
            scores.put(visitor, scores.getOrDefault(visitor, new Friend(visitor)).addScore(1));
        }
    }
}
