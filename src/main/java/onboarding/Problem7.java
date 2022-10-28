package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = createUserList(friends, visitors);
        List<String> friendsOfUser = createFriendList(user, friends);

        Map<String, Long> recommendScore = new HashMap<>();
        for (String id : users) {
            recommendScore.put(id, 0L);
        }

        for (String id : friendsOfUser) {
            recommendScore.replace(id, recommendScore.get(id) + 10);
        }

        for (String id : visitors) {
            recommendScore.replace(id, recommendScore.get(id) + 1);
        }

        // 사용자들 뽑아내기
        // 유저의 친구들 구하기
        // 유저의 친구들의 친구 구해서 +10하기
        // 타임 라인 visitor +1하기
        // 추천 점수대로 정렬하기
        // 추천 점수가 같은 친구들 이름순으로 정렬하기

        List<String> a = new ArrayList<>();
        return a;
    }

    private static List<String> createUserList(List<List<String>> friends, List<String> visitors) {
        List<String> users = new ArrayList<>();

        for (List<String> friend : friends) {
            if(!users.contains(friend.get(0))) users.add(friend.get(0));
            if(!users.contains(friend.get(1))) users.add(friend.get(1));
        }

        for (String visitor : visitors) {
            if(!users.contains(visitor)) users.add(visitor);
        }

        return users;
    }

    private static List<String> createFriendList(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();

        for (List<String> friend : friends) {
            if(friend.get(0).equals(user)) friendsOfUser.add(friend.get(1));
            if(friend.get(1).equals(user)) friendsOfUser.add(friend.get(0));
        }

        return friendsOfUser;
    }
}
