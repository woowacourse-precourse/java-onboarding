package onboarding.problem7;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserGraph {

    private final Map<String, Set<String>> adjLists;

    public UserGraph(List<List<String>> friends) {
        this.adjLists = new HashMap<>();

        for (int size = friends.size(), i = 0; i < size; i++) {
            List<String> relation = friends.get(i);
            String id1 = relation.get(0);
            String id2 = relation.get(1);
            setCompleteEdge(id1, id2);
        }
    }

    public void setCompleteEdge(String id1, String id2) {
        adjLists.putIfAbsent(id1, new HashSet<>());
        adjLists.putIfAbsent(id2, new HashSet<>());

        adjLists.get(id1)
                .add(id2);

        adjLists.get(id2)
                .add(id1);
    }

    public Set<String> getFriends(String id) {
        return adjLists.getOrDefault(id, Collections.emptySet());
    }

}
