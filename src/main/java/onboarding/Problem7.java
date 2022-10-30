package onboarding;

import java.util.*;

public class Problem7 {

    private static Set<String> friendList = new HashSet<>();
    private static HashMap<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        findFriend(user, friends);
        getScoreInFriend(user, friends);
        getScoreInVisitors(user, visitors);

        if (score.isEmpty() == false) {
            List<String> compareList = new ArrayList<>(score.keySet());
            Collections.sort(answer, (data1, data2) -> {
                if(score.get(data1) == score.get(data2)) {
                    return data1.compareTo(data2);
                }
                return score.get(data1) - score.get(data2);
            });

            if(compareList.size() < 6) {
                answer = compareList;
            }
            else {
                for (int i = 0 ; i < 5 ; i++) {
                    answer.add(compareList.get(i));
                }
            }

        }

        return answer;
    }

    public static void findFriend(String user, List<List<String>> friends) {
        for (List<String> friendData : friends) {
            if(user.equals(friendData.get(0)) == true) {
                friendList.add(friendData.get(1));
            }
            if(user.equals(friendData.get(1)) == true) {
                friendList.add(friendData.get(0));
            }
        }
    }

    public static void getScoreInFriend(String user, List<List<String>> friends) {
        for (List<String> friendData : friends) {
            if(user.equals(friendData.get(1)) == false && friendList.contains(friendData.get(0)) == true && friendList.contains(friendData.get(1)) == false) {
                if(score.containsKey(friendData.get(1)) == false) {
                    score.put(friendData.get(1), 10);
                }
                else {
                    score.put(friendData.get(1), score.get(friendData.get(1)) + 10);
                }
            }
            if(user.equals(friendData.get(0)) == false && friendList.contains(friendData.get(1)) == true && friendList.contains(friendData.get(0)) == false) {
                if(score.containsKey(friendData.get(0)) == false) {
                    score.put(friendData.get(0), 10);
                }
                else {
                    score.put(friendData.get(0), score.get(friendData.get(0)) + 10);
                }
            }
        }
    }

    public static void getScoreInVisitors(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if(visitor.equals(user) == false && friendList.contains(visitor) == false) {
                if(score.containsKey(visitor) == false) {
                    score.put(visitor, 1);
                }
                else {
                    score.put(visitor, score.get(visitor) + 1);
                }
            }
        }
    }
}
