package onboarding;

import java.util.*;

/*
 * 함께 아는 친구의 수 - 10점
 * 사용자의 타임라이넹 방문한 횟수 - 1점
 *
 * 사용자 user, 친구 관계 정보 friends, 방문기록 visitors
 * 점수 높은순 5명 반환, 0점은 리턴하지 않는다.
 *
 * [A,B] A와 B는 친구이며, 중복해서 주어지지 않고, 추천할 친구가 없는 경우 주어지지 않는다.
 *
 * user의 친구는 return하지 않아도 됨.
 *
 * 방법 1
 * 1. 유저와 친구인 사람을 Set을 사용하여 추린다.
 * 2. 추린 사람들과 친구인 사람들을 해시맵으로 생성 후 10점씩 추가.
 * 3. 방문한 친구들 점수 추가.
 *
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p = new Problem7();
        List<String> answer = Collections.emptyList();
        Set<String> userSFriend = p.userSFriendInit(user, friends);

        System.out.println(userSFriend.toString());
        return answer;
    }

    // 유저랑 친구인 사람들은 Set으로 초기화
    public Set<String> userSFriendInit(String user, List<List<String>> friends) {
        Set<String> userSFriend = new HashSet<>();

        for (List<String> friendArr : friends) {
            String friendA = friendArr.get(0);
            String friendB = friendArr.get(1);
            if (!friendA.equals(user) && !friendB.equals(user)) {
                continue;
            } else if (friendA.equals(user)) {
                userSFriend.add(friendB);
            } else {
                userSFriend.add(friendA);
            }
        }
        return userSFriend;
    }


    // Set과 비교하여 유저랑 친구가 아닌 사람들은 HashMap으로 name, value로 초기화한다.
    public Map<String, Integer> initScore(List<List<String>> friends) {
        Map<String, Integer> initScore = new HashMap<>();
        return initScore;
    }

    // 함께 아는 친구 점수 추가

    // visitors 점수 추가

    // result 반환


}
