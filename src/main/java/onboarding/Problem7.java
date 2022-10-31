package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    // 점수가 높은 순으로 5명을 리턴한다.
    // 점수가 같으면 이름순으로 정렬한다.
    // 0점이면 리턴하지 않는다
    // 함께아는 친구: 10점
    // 타임라인에 방문한 횟수: 1점

    // TODO 전체 유저 닉네임을 반환하는 메서드 -> 중복을 제거한다
    public static List<String> getUsers(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                users.add(friends.get(i).get(j));
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            users.add(visitors.get(i));
        }
        users = users.stream()
                .distinct()
                .filter(s -> !s.equals(user))
                .sorted().collect(Collectors.toList());

        return users;
    }


    // TODO user와 친구 관계인 유저들을 반환하는 메서드
    public static List<String> userFriends (String user, List<List<String>> friends) {
        List<List<String>> list = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) list.add(friends.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            friendsOfUser.addAll(list.get(i));
        }

        friendsOfUser.removeAll(Arrays.asList(user));
        Collections.sort(friendsOfUser);
        return friendsOfUser;
    }

    // TODO 뽑은 요소들에서 user와 친구인 유저를 찾는다.
        // 찾은 친구의 리스트에 담겨있는 유저에게 +10
        //  visitors를 돌며 2차원배열에 +1
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> users = getUsers(user, friends, visitors);
        List<String> friendsOfUser = userFriends(user, friends);
        return null;
    }
}
