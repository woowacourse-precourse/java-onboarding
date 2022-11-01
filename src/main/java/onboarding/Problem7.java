package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendList = new ArrayList<>();   // 사용자의 친구 목록
        TreeMap<String, Integer> recommendedFriends = new TreeMap<>();   // 친구 추천 목록

        createFriendList(user, friends, friendList);
        checkFriendOfFriend(user, friends, friendList, recommendedFriends);
        checkVisitors(visitors, recommendedFriends);
        makeRecommendFriendsList(recommendedFriends, friendList, answer);

        return answer;
    }

    // 1. 사용자의 친구 목록 생성
    public static void createFriendList(String user, List<List<String>> friends, List<String> friendList) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (!name.equals(user)) friendList.add(name);
                }
            }
        }
    }

    // 2. 사용자의 친구 목록에 포함되어있는지 체크 ( = 사용자의 친구와 친구인지 확인 ) -> 맞으면 +10점
    public static void checkFriendOfFriend(String user, List<List<String>> friends, List<String> friendList, Map<String, Integer> recommendedFriends) {
        for (List<String> friend : friends) {
            if(friendList.contains(friend.get(0)) ||friendList.contains(friend.get(1))) {
                for (String name : friend) {
                    if (!friendList.contains(name) && !name.equals(user)) {
                        System.out.println(name);
                        if (recommendedFriends.containsKey(name)){
                            recommendedFriends.put(name, recommendedFriends.get(name) + 10);
                        }
                        else recommendedFriends.put(name, 10);
                    }
                }
            }
        }
    }

    // 3. 사용자의 타임라인에 방문했는지 체크 -> 했으면 +1점
    public static void checkVisitors(List<String> visitors, Map<String, Integer> recommendedFriends) {
        for (String visitor : visitors) {
            if (recommendedFriends.containsKey(visitor)) {
                recommendedFriends.put(visitor, recommendedFriends.get(visitor) + 1);
            }
            else recommendedFriends.put(visitor, 1);
        }
    }

    // 4. 친구 추천 목록 만들기
    public static void makeRecommendFriendsList(Map<String, Integer> recommendedFriends, List<String> friendList, List<String> answer) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recommendedFriends.entrySet());
        int cnt = 0;

        // value 값을 기준으로 내림차순 정렬 하기
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();   // 내림차순 정렬
            }
        });

        // 내림차순 정렬된 것을 answer에 넣기 (상위 5명까지만)
        for(Map.Entry<String, Integer> entry : entryList){
            if (!friendList.contains(entry.getKey()) && cnt < 5) {
                answer.add(entry.getKey());
                cnt += 1;
            }
        }
    }
}
