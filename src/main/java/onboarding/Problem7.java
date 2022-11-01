package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<HashMap<String, Object>> list = new ArrayList<>();

        // 추천할 수 있는 친구 목록
        Map<String, Integer> friendMap = friendLists(user, friends, visitors);

        // 포인트 적립
        friendMap = setPoint(friends, visitors, friendMap);

        // 정렬
        list = sorted(list, friendMap);

        for(HashMap<String, Object> o : list) {
            if(answer.size() > 5) break;
            if((Integer) o.get("point") == 0) continue;
            answer.add((String) o.get("name"));
        }
        return answer;
    }

    /**
     * 추천 친구 목록을 생성
     * @param user
     * @param friends
     * @param visitors
     * @return
     */
    public static Map<String, Integer> friendLists(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendMap = new HashMap<>();

        // 나를 제외한 모든 친구를 저장
        friends.forEach(friend -> {
            if(friend.get(0) != user) friendMap.putIfAbsent(friend.get(0), 0);
            if(friend.get(1) != user) friendMap.putIfAbsent(friend.get(1), 0);
        });

        visitors.forEach(visitor -> {
            if(visitor != user) friendMap.putIfAbsent(visitor, 0);
        });

        // 목록에서 내 친구를 삭제한 뒤 반환
        return myFriendLists(user, friends, friendMap);
    }

    /**
     * 친구 목록에서 내 친구를 삭제
     * @param user
     * @param friends
     * @param friendMap
     * @return
     */
    public static Map<String, Integer> myFriendLists(String user, List<List<String>> friends, Map<String, Integer> friendMap) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                friendMap.remove(friend.get(0));
                friendMap.remove(friend.get(1));
            }
        }
        return friendMap;
    }

    /**
     * 추천 점수 계산
     * - 함께하는 친구 수 당 10점 부여
     * - 타임라인에 방문한 횟수 당 1점 부여
     * @param friends
     * @param visitors
     * @param friendMap
     * @return
     */
    private static Map<String, Integer> setPoint(List<List<String>> friends, List<String> visitors, Map<String, Integer> friendMap) {
        for(Map.Entry<String, Integer> friend : friendMap.entrySet()) {
            int point = 0;
            // 함께아는 친구
            for (List<String> fs : friends) {
                if(fs.contains(friend.getKey())){
                    point += 10;
                }
            }
            // 타임라인 방문
            for (String visitor : visitors) {
                if(visitor.equals(friend.getKey())) {
                    point++;
                }
            }
            friend.setValue(point);
        }
        return friendMap;
    }

    /**
     * 추천도가 높은 순으로 정렬
     * - 추천점수가 높을 수록 우선순위를 가지며, 점수가 같은 경우에는 이름순으로 정렬
     * @param list
     * @param friendMap
     * @return
     */
    private static List<HashMap<String, Object>> sorted(List<HashMap<String, Object>> list, Map<String, Integer> friendMap) {

        for(Map.Entry<String, Integer> friend : friendMap.entrySet()) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("name",friend.getKey());
            map1.put("point",friend.getValue());
            list.add(map1);
        }
        Collections.sort(list, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                Integer point1 = (Integer) o1.get("point");
                Integer point2 = (Integer) o2.get("point");

                if(point1 == point2) {
                    // 점수가 같은 경우 이름 오름차순
                    String name1 = (String) o1.get("name");
                    String name2 = (String) o2.get("name");
                    return name1.compareTo(name2);
                }
                // 점수 내림차순
                return point2.compareTo(point1);
            }
        });
        return list;
    }
}
