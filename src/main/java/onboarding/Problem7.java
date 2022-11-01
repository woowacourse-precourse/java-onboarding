package onboarding;

import java.util.*;

public class Problem7 {
    public static final int KNOW_FRIEND = 10;
    public static final int TIME_LINE_VISITED = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,List<String>> friendsMap = makeMap(friends);
        HashMap<String,Integer> relationValue = new HashMap<>();
        List<String> userFriendList = new ArrayList<>();
        if (friendsMap.containsKey(user)) {
            userFriendList = friendsMap.get(user);
        }

        /* Update user friend's friend score */
        for (String userFriendName : userFriendList) {
            if (friendsMap.containsKey(userFriendName)) {
                List <String> lst = friendsMap.get(userFriendName);
                for (String name : lst) {
                    if (name.equals(user)) {
                        continue;
                    }
                    if (!relationValue.containsKey(name)) {
                        relationValue.put(name, KNOW_FRIEND);
                    } else {
                        relationValue.put(name, relationValue.get(name) + KNOW_FRIEND);
                    }
                }
            }
        }
        /* Update visitor's score */
        for (String visitor : visitors){
            if(visitor.equals(user)){
                continue;
            }
            if(!relationValue.containsKey(visitor)) {
                relationValue.put(visitor,TIME_LINE_VISITED);
            } else {
                relationValue.put(visitor, relationValue.get(visitor)+TIME_LINE_VISITED);
            }
        }
        // remove user's friends
        for(String delName : userFriendList){
            relationValue.remove(delName);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(relationValue.entrySet());

        List<String> answer = new ArrayList<>();
        int j = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if (j < 5) {
                answer.add(entry.getKey());
                j++;
            }
        }
        return answer;
    }
    private static HashMap<String,List<String>> makeMap(List<List<String>> friends){
        HashMap<String,List<String>> graph = new HashMap<>();
        for(List<String> relationship : friends) {
            String friend1 = relationship.get(0);
            String friend2 = relationship.get(1);
            if (graph.containsKey(friend1)) {
                List<String> friendList = new ArrayList<>(graph.get(friend1));
                friendList.add(friend2);
                graph.put(friend1, friendList);
            } else {
                graph.put(friend1, List.of(friend2));
            }

            if (graph.containsKey(friend2)) {
                List<String> friendList = new ArrayList<>(graph.get(friend2));
                friendList.add(friend1);
                graph.put(friend2, friendList);
            } else {
                graph.put(friend2, List.of(friend1));
            }
        }
        return graph;
    }
}
