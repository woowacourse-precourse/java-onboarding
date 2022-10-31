package onboarding;

import java.util.*;

public class Problem7 {

    private static HashMap<String, ArrayList<String>> friendship = new HashMap<>();
    private static Map<String, Integer> scoreList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        for (List<String> friend : friends) {
            setFriendship(friend.get(0), friend.get(1));
            setFriendship(friend.get(1), friend.get(0));
        }

        // 친구의 친구에 점수 부여
        ArrayList<String> friendsOfUser = friendship.get(user);
        for(String friend : friendsOfUser) {
            for(String together : friendship.get(friend)) {
                if(together.equals(user))
                    continue;
                if(scoreList.containsKey(together))
                    scoreList.put(together, scoreList.get(together) + 10);
                else
                    scoreList.put(together, 10);
            }
        }

        // 방문자에 점수 부여
        setScoreOfVisitor(visitors);


        // 사용자와 친구인 경우 제거
        Iterator<Map.Entry<String, Integer>> it = scoreList.entrySet().iterator();
        while (it.hasNext()) {
            String friend = it.next().getKey();
            if(friendsOfUser.contains(friend)) {
                it.remove();
            }
        }

        // user와 친구인 애들 지우기
        List<String> scoreListKeySet = new ArrayList<>(scoreList.keySet());
        Collections.sort(scoreListKeySet, (val1, val2) -> (scoreList.get(val2).compareTo(scoreList.get(val1))));


        // 최종 top 5 반환
        if(scoreListKeySet.size() < 5)
            return scoreListKeySet;
        else
            return scoreListKeySet.subList(0,5);
    }

    private static void setFriendship(String userA, String userB) {
        ArrayList<String> list = new ArrayList<>();
        if(friendship.containsKey(userA)) {
            list = friendship.get(userA);
            list.add(userA);
        } else {
            list.add(userB);
        }
        friendship.put(userA, list);
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
