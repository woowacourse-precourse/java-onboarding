package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend: friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if(user1.equals(user)) {
                userFriends.add(user2);
                continue;
            }
            if (user2.equals(user)) {
                userFriends.add(user1);
                continue;
            }
        }

        return userFriends;
    }

    public static HashMap<String, Integer> getAcquaintance (HashMap<String, Integer> listOfScore, List<String> userFriends, List<List<String>> friends) {
        for (String user: userFriends) {
            for (List<String> friend: friends) {
                String user1 = friend.get(0);
                String user2 = friend.get(1);
                if (user1.equals(user)) {
                    listOfScore.put(user2, listOfScore.getOrDefault(user2, 0) + 10);
                } else if (user2.equals(user)) {
                    listOfScore.put(user1, listOfScore.getOrDefault(user1, 0) + 10);
                }
            }
        }
        return listOfScore;
    }

    public static HashMap<String, Integer> getVisitorScore (HashMap<String, Integer> listOfScore, List<String> visitors, List<String> userFriends) {
        for(String visitor: visitors) {
            if(userFriends.contains(visitor) == false) {
                listOfScore.put(visitor, listOfScore.getOrDefault(visitor, 0) + 1);
            }
        }

        return listOfScore;
    }

    public static List<String> getTheTopFive(HashMap<String, Integer> listOfScore) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(listOfScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> user1, Map.Entry<String, Integer> user2) {
                return user1.getValue() - user2.getValue();
            }
        });

        List<String> recommendList = new ArrayList<>();
        int numOfPeople = 5;
        for(int i = 0; i < numOfPeople; i++) {
            Map.Entry<String, Integer> entry = entryList.get(i);
            recommendList.add(entry.getKey());
        }

        return recommendList;
    }
}
