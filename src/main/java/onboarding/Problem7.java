package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendWithUserList = new ArrayList<>();
        Map<String, Integer> friendWithUserDict = new HashMap<>();
        // 사용자와 친구인 유저의 이름 배열에 담기
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user))
                    friendWithUserList.add(friend.get(1));
                else
                    friendWithUserList.add(friend.get(0));
            } else {
                friendWithUserDict.put(friend.get(0), 0);
                friendWithUserDict.put(friend.get(1), 0);
            }
        }

        for (String f : friendWithUserList)
            friendWithUserDict.remove(f);
        // 사용자와 함께 아는 친구의 이름 10점 주기
        friendWithUserDict.forEach((key, value) -> {
            for (List<String> friend : friends) {
                if (friend.contains(key))
                    friendWithUserDict.computeIfPresent(key, (k, v) -> v + 10);
            }
        });

        // 방문한 유저를 1점 주기 이미 값이 있다면 1점 추가
        for (String visit : visitors) {
            if (!friendWithUserList.contains(visit)) {
                friendWithUserDict.putIfAbsent(visit, 0);
                friendWithUserDict.computeIfPresent(visit, (k, v) -> v + 1);
            }
        }
        // 해쉬맵을 value값으로 내림차순 정렬 후 retun
        return friendWithUserDict.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())
                )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}