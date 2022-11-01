package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        connection = new HashMap<>();
        List<String> friendList = new ArrayList<>();
        List<List<String>> friendsGraph = new ArrayList<>();

        for (List<String> friendPair : friends) {
            if (friendPair.contains(user)) {
                friendList.add(getAnotherOne(friendPair, user));
            } else {
                friendsGraph.add(friendPair);
            }
        }

        for (String friend : friendList) {
            for (List<String> friendPair : friendsGraph) {
                if (friendPair.contains(friend)) {
                    String addPointName = getAnotherOne(friendPair, friend);
                    addConnectionPoint(addPointName, 10);
                }
            }
        }

        for (String visitor : visitors) {
            if(!friendList.contains(visitor))
                addConnectionPoint(visitor, 1);
        }

    
        answer = new ArrayList<>(connection.keySet());
    
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return connection.get(o1).compareTo(connection.get(o2));
            }
        });
        return answer;
    }

    private static Map<String,Integer> connection;

    private static void addConnectionPoint(String name, int point) {
        if (connection.containsKey(name))
            connection.put(name, connection.get(name) + 10);
        else
            connection.put(name, 10);
    }
    private static String getAnotherOne(List<String> twoList, String name) {
        if (twoList.get(0).equals(name))
            return twoList.get(1);
        else
            return twoList.get(0);
    }

}