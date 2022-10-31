package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Introduces friend candidates
 */
public class FriendIntroducer {

    private final String user;

    private final List<List<String>> friends;
    private final List<String> visitors;
    private final Map<String, List<String>> relationships = new HashMap<>();

    /**
     * Constructor with user, friends, visitors
     *
     * @param user     name of user
     * @param friends  friend relationship list
     * @param visitors visitor names of user sns
     */
    public FriendIntroducer(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        addRelationships();
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
     *
     * @param idA friend of idB
     * @param idB friend of idA
     */
    private void addRelationship(String idA, String idB) {
        if (relationships.containsKey(idA)) relationships.get(idA).add(idB);
        else relationships.put(idA, new ArrayList<>(List.of(idB)));
    }

    public Map<String, Friend> introduce() {
        Map<String, Friend> scores = new HashMap<>();
        List<String> userFriends = relationships.get(user);
        introduceFriends(userFriends, scores);
        introduceVisitors(userFriends, scores);
        return scores;
    }

    /**
     * Introduce new friends in current friends' friends
     *
     * @param userFriends current friend list of user
     * @param scores      map of name and score
     */
    private void introduceFriends(List<String> userFriends, Map<String, Friend> scores) {
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
     *
     * @param userFriends current friend list of user
     * @param scores      map of name and score
     */
    private void introduceVisitors(List<String> userFriends, Map<String, Friend> scores) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) break;
            scores.put(visitor, scores.getOrDefault(visitor, new Friend(visitor)).addScore(1));
        }
    }
}
