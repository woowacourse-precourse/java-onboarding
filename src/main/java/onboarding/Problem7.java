package onboarding;

import java.util.*;
import java.util.Map.Entry;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        Map<String, List<String>> frdList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);

            if (frdList.containsKey(first)) {
                List<String> temp = frdList.get(first);
                temp.add(second);
                frdList.put(first, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(second);
                frdList.put(first, temp);
            }

            if (frdList.containsKey(second)) {
                List<String> temp = frdList.get(second);
                temp.add(first);
                frdList.put(second, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(first);
                frdList.put(second, temp);
            }
        }

        Map<String, Integer> scoreMap = new HashMap<>();

        List<String> userFriends = new ArrayList<>();
        Map<String, List<String>> notFriends = new HashMap<>();

        userFriends = frdList.get(user);

        Iterator<String> iter = frdList.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            if (!userFriends.contains(key) && (key != user)) {
                notFriends.put(key, frdList.get(key));
            }
        }

        Iterator<String> iter2 = notFriends.keySet().iterator();
        while (iter2.hasNext()) {
            String key = iter2.next();
            int fscore = 0;

            for (String userFriend : userFriends) {
                if (notFriends.get(key).contains(userFriend)) {
                    fscore += 10;
                }
                scoreMap.put(key, fscore);
            }
        }

        Iterator<String> iter3 = scoreMap.keySet().iterator();

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
        List<Entry<String, Integer>> sortScoreMap = new ArrayList<Entry<String, Integer>>(scoreMap.entrySet());
        Collections.sort(sortScoreMap, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                if (obj1.getValue().compareTo(obj2.getValue()) == 0) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj1.getValue().compareTo(obj1.getValue());
            }
        });

//        Iterator<String> iter4 = sortScoreMap.keySet().iterator();


        for (Entry<String, Integer> entry : sortScoreMap) {
            if (answer.size() == 5) {
                break;
            }
            answer.add(entry.getKey());
        }



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