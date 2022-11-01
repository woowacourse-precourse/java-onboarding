package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for(List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(friend1.equals(user)) {
                friendList.add(friend2);
            } else if(friend2.equals(user)) {
                friendList.add(friend1);
            }
        }

        return friendList;
    }

    public static Map<String, List<String>> getMutualFriends(String user, List<List<String>> friends, List<String> friendList) {

        Map<String, List<String>> mutualFriends = new HashMap<>();

        for(List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(friend1.equals(user) || friend2.equals(user)) {
                continue;
            }

            if(friendList.contains(friend1)) {
                if(!mutualFriends.containsKey(friend1)) {
                    List<String> val = new ArrayList<>();
                    val.add(friend2);
                    mutualFriends.put(friend1, val);
                } else if(mutualFriends.containsKey(friend1)) {
                    List<String> val = mutualFriends.get(friend1);
                    val.add(friend2);
                    mutualFriends.put(friend1, val);
                }
            } else if(friendList.contains(friend2)) {
                if(!mutualFriends.containsKey(friend2)) {
                    List<String> val = new ArrayList<>();
                    val.add(friend1);
                    mutualFriends.put(friend2, val);
                } else if(mutualFriends.containsKey(friend2)) {
                    List<String> val = mutualFriends.get(friend2);
                    val.add(friend1);
                    mutualFriends.put(friend2, val);
                }
            }
        }

        return mutualFriends;
    }

    public static Map<String, Integer> plusMutualFriendsScore(Map<String, List<String>> mutualFriends) {
        Map<String, Integer> recScore = new HashMap<>();

        for(String key : mutualFriends.keySet()) {
            for(String value : mutualFriends.get(key)) {
                if(!recScore.containsKey(value)) {
                    recScore.put(value, 10);
                } else if(recScore.containsKey(value)) {
                    recScore.put(value, recScore.get(value) + 10);
                }
            }
        }

        return recScore;
    }

    public static Map<String, Integer> plusVisitorsScore(List<String> visitors, List<String> friendList, Map<String, Integer> recScore) {
        for(String visitor : visitors) {
            if(!friendList.contains(visitor)){
                if(!recScore.containsKey(visitor)) {
                    recScore.put(visitor, 1);
                } else if(recScore.containsKey(visitor)) {
                    recScore.put(visitor, recScore.get(visitor) + 1);
                }
            }
        }

        return recScore;
    }

    public static Map<String, Integer> sortRecScore(Map<String, Integer> recScore) {
        Map<String, Integer> sortedRecScore = recScore.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue)
                        .reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        return sortedRecScore;
    }

    public static List<String> getAnswer(Map<String, Integer> sortedRecScore) {
        List<String> result = new ArrayList<>();
        int cnt = 0;

        for(String id : sortedRecScore.keySet()) {
            if(cnt >= 5) {
                break;
            }
            result.add(id);
            cnt++;
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendList = getFriendList(user, friends);
        Map<String, List<String>> mutualFriends = getMutualFriends(user, friends, friendList);

        Map<String, Integer> recScore;
        recScore = plusMutualFriendsScore(mutualFriends);
        recScore = plusVisitorsScore(visitors, friendList, recScore);


        Map<String, Integer> sortedRecScore = sortRecScore(recScore);

        List<String> answer = getAnswer(sortedRecScore);

        return answer;
    }
}
