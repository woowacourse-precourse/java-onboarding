package onboarding;

import java.util.*;
import java.util.Map.Entry;
public class Problem7 {
    
    // 모든 사람에 대한 친구 목록을 받는다.
    public static Map<String, List<String>> getFriends(List<List<String>> friends){
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);
            
            // 각 사람에 대한 원래 목록이 존재하는 경우와 존재하지 않는 경우를 나누어 받는다.
            if (map.containsKey(first)) {
                // 원래 친구 목록에 새로 들어온 친구를 추가한다. 동일한 친구관계는 중복해서 들어오지 않기 때문에 단순히 추가하면 된다.
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
    
    // user와 친구가 아닌 사람 목록을 구별하기 위해 notFriends Map을 생성하고, 해당 사람의 친구 관계까지 받는 메소드
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

    // user와 친구가 아닌 사람들 중 함께 아는 친구가 몇명인지 파악하고 1명당 10점을 부여하는 메소드
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

    // 빙문자 점수를 부여하는 메소드
    public static Map<String, Integer> visitorScore(Map<String, Integer> scoreMap, List<String> visitors, List<String> userFriends){
        for (String visitor : visitors) {
            // visitor가 user친구 목록에 없을 경우만 다룬다.
            if (!userFriends.contains(visitor)) {
                // 원래 점수가 부여되어있을 경우와 점수가 0점인 경우를 나누어 점수를 부여한다.
                if (scoreMap.containsKey(visitor)) {
                    int temp = scoreMap.get(visitor);
                    temp = temp + 1;
                    scoreMap.put(visitor, temp);
                } else{
                    // 즉, 처음 등장한 visitor이라면 1점 부여
                    scoreMap.put(visitor, 1);
                }
            }
        }
        return scoreMap;
    }

    // Score의 기준으로 추천할 사람들을 정렬하고, 점수가 같을 경우 이름을 기준으로 정렬하는 메소드
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

    // 추천할 수 있는 사람의 목록이 5명 이상일 경우 5명까지만 받아오는 메소드
    // 이미 정렬되어있기 때문에 단순히 앞에서부터 짜르면 된다.
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

        // 모든 사람에 대한 친구 관계 리스트를 생성한다.
        Map<String, List<String>> frdList = new HashMap<>(getFriends(friends));

        // user의 친구 목록을 받는다.
        List<String> userFriends = new ArrayList<>(frdList.get(user));
        // user와 친구가 아닌 사람들에 대한 친구 관계 리스트를 생성한다.
        Map<String, List<String>> notFriends = new HashMap<>(getNotFriends(user, frdList, userFriends));

        // 친구 관계에 대한 score을 부여한다.
        Map<String, Integer> scoreMap = new HashMap<>(togetherFriendScore(notFriends, userFriends));
        // visitor에 대한 score을 부여한다.
        scoreMap = visitorScore(scoreMap, visitors, userFriends);

        // 추천 가능한 사람의 목록을 점수와 이름을 기준으로 정렬한다.
        List<Entry<String, Integer>> sortScoreMap = new ArrayList<Entry<String, Integer>>(sortingScore(scoreMap));

        // 추천할 사람을 5명 받아온다.
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