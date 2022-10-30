package problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final List<List<String>> friendsInfo;

    private final Map<String, List<String>> adjacentList = new HashMap<>();

    public Graph(List<List<String>> friendsInfo) {
        this.friendsInfo = friendsInfo;

        construct();
    }

    private void construct() {
        for (List<String> pair : friendsInfo) {
            String friend1 = pair.get(0);
            String friend2 = pair.get(1);

            addFriend(friend1, friend2);
            addFriend(friend2, friend1);
        }
    }

    private void addFriend(String friend1, String friend2) {
        if(!adjacentList.containsKey(friend1))
            adjacentList.put(friend1, new ArrayList<>());
        adjacentList.get(friend1).add(friend2);
    }

    public Map<String, List<String>> getAdjacentList() {
        return adjacentList;
    }
}
