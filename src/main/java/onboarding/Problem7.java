package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendWithUserList = new ArrayList<>();
        Map<String, Integer> friendWithUserDict = new HashMap<>();
        List<String> answer = new ArrayList<>();
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
        return answer;
    }
}