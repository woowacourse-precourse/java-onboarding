package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> usersFriends = getUsersFriends(friends);
        Set<String> targetUserFriends = usersFriends.get(user);
        Map<String, Integer> userScore = new HashMap<>();
        for (String userName : usersFriends.keySet()){
            if (!Objects.equals(userName, user)){
                Set<String> targetUserFriendsCloned = new HashSet<>(targetUserFriends);
                Set<String> currUserFriends = usersFriends.get(userName);
                targetUserFriendsCloned.retainAll(currUserFriends);
                userScore.put(userName, 10 * targetUserFriendsCloned.size());
            }
        }
        for (String visitor : visitors){
            if (userScore.containsKey(visitor)){
                userScore.put(visitor, userScore.get(visitor) + 1);
            }
            else {
                userScore.put(visitor, 1);
            }
        }
        List<Map.Entry<String, Integer>> userScoreEntries = new ArrayList<>(userScore.entrySet());
        Collections.sort(userScoreEntries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() > o1.getValue())
                    return 1;
                else if (o2.getValue() < o1.getValue())
                    return -1;
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> userScoreEntry : userScoreEntries){
            int score = userScoreEntry.getValue();
            String userName = userScoreEntry.getKey();
            if (answer.size() == 5)
                break;
            if (score > 0 && !targetUserFriends.contains(userName)){
                answer.add(userName);
            }
            else if (score <= 0)
                break ;
        }
        return answer;
    }

    public static Map<String, Set<String>> getUsersFriends(List<List<String>> friends){
        Map<String, Set<String>> usersFriends = new HashMap<>();
        for (List<String> friend : friends){
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            if (usersFriends.containsKey(user1))
                usersFriends.get(user1).add(user2);
            else {
                usersFriends.put(user1, new HashSet<>());
                usersFriends.get(user1).add(user2);
            }
            if (usersFriends.containsKey(user2))
                usersFriends.get(user2).add(user1);
            else {
                usersFriends.put(user2, new HashSet<>());
                usersFriends.get(user2).add(user1);
            }
        }
        return usersFriends;
    }
}
