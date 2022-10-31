package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreList = new HashMap<>();
        HashMap<String, ArrayList<String>> sns = new HashMap<>();

        // 친구 관계  넣기
        for (List<String> friend : friends) {
            ArrayList<String> list = new ArrayList<>();
            if(sns.containsKey(friend.get(0))) {
                list = sns.get(friend.get(0));
                list.add(friend.get(1));
            } else {
                list.add(friend.get(1));
            }
            sns.put(friend.get(0), list);
            list = new ArrayList<>();
            if(sns.containsKey(friend.get(1))) {
                list = sns.get(friend.get(1));
                list.add(friend.get(0));
            } else{
                list.add(friend.get(0));
            }
            sns.put(friend.get(1), list);
        }

        // 친구의 친구에 점수 부여
        ArrayList<String> friendsOfUser = sns.get(user);
        for(String friend : friendsOfUser) {
            for(String together : sns.get(friend)) {
                if(together.equals(user))
                    continue;
                if(scoreList.containsKey(together))
                    scoreList.put(together, scoreList.get(together) + 10);
                else
                    scoreList.put(together, 10);
            }
        }

        // 방문자에 점수 부여
        for(String visitor : visitors) {
            if(scoreList.containsKey(visitor))
                scoreList.put(visitor, scoreList.get(visitor) + 1);
            else
                scoreList.put(visitor, 1);
        }

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
}
