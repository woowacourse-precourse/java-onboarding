package onboarding;

import java.util.*;

public class Problem7 {

    private static HashMap<String, ArrayList<String>>friendship= new HashMap<>();
    private static Map<String, Integer> scoreList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        setFriendship(friends);

        ArrayList<String> friendsOfUser =friendship.get(user);
        setScoreOfAcquaintance(user,friendsOfUser);

        setScoreOfVisitor(visitors);

        // 사용자와 친구인 경우 제거
        Iterator<Map.Entry<String, Integer>> it = scoreList.entrySet().iterator();
        while (it.hasNext()) {
            String friend = it.next().getKey();
            if(friendsOfUser.contains(friend)) {
                it.remove();
            }
        }

        List<String> scoreListKeySet = new ArrayList<>(scoreList.keySet());
        Collections.sort(scoreListKeySet, (val1, val2) -> (scoreList.get(val2).compareTo(scoreList.get(val1))));

        // 최종 top 5 반환
        if(scoreListKeySet.size() < 5)
            return scoreListKeySet;
        else
            return scoreListKeySet.subList(0,5);
    }

    private static void setFriendship(List<List<String>> friends) {
        ArrayList<String> list;
        for (List<String> friend : friends) {
            list = new ArrayList<>();
            if(friendship.containsKey(friend.get(0))) {
                list =friendship.get(friend.get(0));
                list.add(friend.get(1));
            } else {
                list.add(friend.get(1));
            }
            friendship.put(friend.get(0), list);

            list = new ArrayList<>();
            if(friendship.containsKey(friend.get(1))) {
                list =friendship.get(friend.get(1));
                list.add(friend.get(0));
            } else{
                list.add(friend.get(0));
            }
            friendship.put(friend.get(1), list);
        }
    }

    private static void setScoreOfAcquaintance(String user, List<String> friendsOfUser) {
        for(String friend : friendsOfUser) {
            for(String together :friendship.get(friend)) {
                if(together.equals(user))
                    continue;
                if(scoreList.containsKey(together))
                    scoreList.put(together, scoreList.get(together) + 10);
                else
                    scoreList.put(together, 10);
            }
        }
    }

    private static void setScoreOfVisitor(List<String> visitors) {
        for(String visitor : visitors) {
            if(scoreList.containsKey(visitor))
                scoreList.put(visitor, scoreList.get(visitor) + 1);
            else
                scoreList.put(visitor, 1);
        }
    }

}
