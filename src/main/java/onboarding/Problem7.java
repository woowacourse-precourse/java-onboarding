package onboarding;

import java.util.*;
import java.util.Map.Entry;
public class Problem7 {
    public static Map<String, List<String>> getFriends(List<List<String>> friends){
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);

            if (map.containsKey(first)) {
                List<String> temp = map.get(first);
                temp.add(second);
                map.put(first, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(second);
                map.put(first, temp);
            }

            if (map.containsKey(second)) {
                List<String> temp = map.get(second);
                temp.add(first);
                map.put(second, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(first);
                map.put(second, temp);
            }
        }
        return map;
    }
    public static Map<String, List<String>> getNotFriends(String user, Map<String, List<String>> frdList, List<String> userFriends){
        Map<String, List<String>> notFMap = new HashMap<>();

        Iterator<String> iter = frdList.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            if (!userFriends.contains(key) && (key != user)) {
                notFMap.put(key, frdList.get(key));
            }
        }
        return notFMap;
    }

    public static Map<String, Integer> togetherFriendScore(Map<String, List<String>> notFriends, List<String> userFriends ){
        Map<String, Integer> map = new HashMap<>();
        Iterator<String> iter = notFriends.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            int fScore = 0;

            for (String userFriend : userFriends) {
                if (notFriends.get(key).contains(userFriend)) {
                    fScore += 10;
                }
                map.put(key, fScore);
            }
        }
        return map;
    }

    public static Map<String, Integer> visitorScore(Map<String, Integer> scoreMap, List<String> visitors, List<String> userFriends){
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                if (scoreMap.containsKey(visitor)) {
                    int temp = scoreMap.get(visitor);
                    temp = temp + 1;
                    scoreMap.put(visitor, temp);
                } else {
                    scoreMap.put(visitor, 1);
                }
            }
        }
        return scoreMap;
    }

    public static List<Entry<String, Integer>> sortingScore(Map<String, Integer> scoreMap) {
        List<Entry<String, Integer>> sortScoreMap = new ArrayList<Entry<String, Integer>>(scoreMap.entrySet());
        Collections.sort(sortScoreMap, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                if (obj1.getValue().compareTo(obj2.getValue()) == 0) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj1.getValue().compareTo(obj1.getValue());
            }
        });
        return sortScoreMap;
    }

    public static List<String> getFiveAns (List<Entry<String, Integer>> sortScoreMap){
        List<String> temp = new ArrayList<>();
        for (Entry<String, Integer> entry : sortScoreMap) {
            if (temp.size() == 5) {
                break;
            }
            temp.add(entry.getKey());
        }
        return temp;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> frdList = new HashMap<>(getFriends(friends));

        List<String> userFriends = new ArrayList<>(frdList.get(user));
        Map<String, List<String>> notFriends = new HashMap<>(getNotFriends(user, frdList, userFriends));

        Map<String, Integer> scoreMap = new HashMap<>(togetherFriendScore(notFriends, userFriends));
        scoreMap = visitorScore(scoreMap, visitors, userFriends);

        List<Entry<String, Integer>> sortScoreMap = new ArrayList<Entry<String, Integer>>(sortingScore(scoreMap));

        answer = getFiveAns(sortScoreMap);

        return answer;
    }

}

/**
 * 기능 요구사항
 * 1. friends별 친구 저장
 * 2. score 계산
 *  - 함께 아는 친구 score 계산
 *  - 방문자 score 계산
 *      - user의 친구 제외해야함
 * 3. 추천 친구 정렬
 * **/