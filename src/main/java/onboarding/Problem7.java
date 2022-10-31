package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> friendList = new HashSet<>();
        HashMap<String, Integer> score = new HashMap<>();

        findFriend(user, friends, friendList);
        getScoreInFriend(user, friends, friendList, score);
        getScoreInVisitors(user, visitors, friendList, score);

        if (score.isEmpty() == true) {
            return answer;
        }

        List<String> compareList = new ArrayList<>(score.keySet());

        Collections.sort(compareList, (o1, o2) -> {
            if (score.get(o1) != score.get(o2)) {
                return score.get(o2).compareTo(score.get(o1));
            } else {
                return o1.compareTo(o2);
            }
        });

        for (String compareData : compareList) {
            if (answer.size() > 5)
                return answer;
            answer.add(compareData);
        }

        return answer;
    }

    public static void findFriend(String user, List<List<String>> friends, Set<String> friendList) {
        for (List<String> friendData : friends) {
            if (user.equals(friendData.get(0)) == true) {
                friendList.add(friendData.get(1));
            }
            if (user.equals(friendData.get(1)) == true) {
                friendList.add(friendData.get(0));
            }
        }
    }

    public static void getScoreInFriend(String user, List<List<String>> friends, Set<String> friendList, HashMap<String, Integer> score) {
        for (List<String> friendData : friends) {
            if (user.equals(friendData.get(1)) == false && friendList.contains(friendData.get(0)) == true && friendList.contains(friendData.get(1)) == false) {
                if (score.containsKey(friendData.get(1)) == false) {
                    score.put(friendData.get(1), 10);
                } else {
                    score.put(friendData.get(1), score.get(friendData.get(1)) + 10);
                }
            }
            if (user.equals(friendData.get(0)) == false && friendList.contains(friendData.get(1)) == true && friendList.contains(friendData.get(0)) == false) {
                if (score.containsKey(friendData.get(0)) == false) {
                    score.put(friendData.get(0), 10);
                } else {
                    score.put(friendData.get(0), score.get(friendData.get(0)) + 10);
                }
            }
        }
    }

    public static void getScoreInVisitors(String user, List<String> visitors, Set<String> friendList, HashMap<String, Integer> score) {
        for (String visitor : visitors) {
            if (visitor.equals(user) == false && friendList.contains(visitor) == false) {
                if (score.containsKey(visitor) == false) {
                    score.put(visitor, 1);
                } else {
                    score.put(visitor, score.get(visitor) + 1);
                }
            }
        }
    }
}
