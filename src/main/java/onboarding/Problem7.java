package onboarding;

import java.lang.invoke.CallSite;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();
        List<String> nowFriends = new ArrayList<>(); // 현재 친구
        // 사용자의 친구 리스트를 저장.
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (!(name.equals(user))) {
                        nowFriends.add(name);
                    }
                }
            }
        }
        // 사용자의 친구와 친구인사람들을 Map에 등록하며 점수 추가
        for (List<String> friend : friends) {
            for (String nowFriend : nowFriends) {
                if (friend.contains(nowFriend)) {
                    for (String name : friend) {
                        if (!(name.equals(nowFriend))) {
                            if (map.containsKey(name)) {
                                map.put(name, map.get(name) + 10);
                            } else {
                                map.put(name, 10);
                            }
                        }
                    }
                }
            }
        }
        // 방문 점수 추가.
        for (String visitor : visitors) {
            if (map.containsKey(visitor)) {
                map.put(visitor, map.get(visitor) + 1);
            } else {
                map.put(visitor, 1);
            }
        }
        // Map Key로 친구추천 리스트 만들기
        List<String> list = new ArrayList<>(map.keySet());
        // 추천 리스트에서 user, nowFriends 제거
        list.remove(user);
        for (String nowFriend : nowFriends) {
            list.remove(nowFriend);
        }
        // 리스트 정렬
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (map.get(list.get(i)) < map.get(list.get(j))) {
                    String tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        // 출력
        List<String> answer;
        if(list.size() < 5){
            answer = list.subList(0, list.size());
        }else {
            answer = list.subList(0, 5);
        }

        return answer;
    }
}
