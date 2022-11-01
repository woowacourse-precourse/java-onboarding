package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> scoreMap = getTotalPoints(user, friends, visitors);
        answer = makeAnswer(scoreMap);

        return answer;

        /*점수 현황 ->r HashMap(name,scoe)
         * 점수 추가 상황 -> 1. 친구의 친구다.
         *             -> 2.  방문한 기록이 있다.
         * 점수 추가 방식 -> 1. 점수 현황에 존재하지 않다. -> 점수현황에 추가. insert
         *              ->2. 이미 점수현황에 존재한다.  -> 해당 점수를 추가  update
         *
         */
    }

    static List<String> findFriends(String me, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (me.equals(friends.get(i).get(0)))
                result.add(friends.get(i).get(1));
            else if (me.equals(friends.get(i).get(1)))
                result.add(friends.get(i).get(0));
        }
        return result;
    }

    static HashMap<String, Integer> getTotalPoints(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();   //HashMap<id,score>
        List<String> friendsOfUser = findFriends(user, friends);
        for (String friend : friendsOfUser) {
            for (String friOfFri : findFriends(friend, friends)) {
                if (friOfFri.equals(user))
                    continue;
                giveFriendPoints(scoreMap, friOfFri);
            }
        }
        for (String visitor : visitors) {
            giveVisitPoints(scoreMap, visitor);
        }
        for (String friend : friendsOfUser) {
            scoreMap.remove(friend);
        }

        return scoreMap;
    }

    static void giveFriendPoints(HashMap<String, Integer> scoreMap, String target) {
        if (scoreMap.containsKey(target))
            scoreMap.replace(target, scoreMap.get(target) + 10);
        else
            scoreMap.put(target, 10);
        return;
    }

    static void giveVisitPoints(HashMap<String, Integer> scoreMap, String target) {
        if (scoreMap.containsKey(target))
            scoreMap.replace(target, scoreMap.get(target) + 1);
        else
            scoreMap.put(target, 1);
        return;
    }

    static List<String> makeAnswer(HashMap<String, Integer> scoreMap) {
        List<String> result = new ArrayList<>();
        List<HashMap.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });
        if (entryList.size() > 5)
            for (int i = 0; i < 5; i++)
                result.add(entryList.get(i).getKey());
        else {
            for (int i = 0; i < entryList.size(); i++)
                result.add(entryList.get(i).getKey());
        }
        return result;

    }


}
