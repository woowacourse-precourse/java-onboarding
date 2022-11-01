package onboarding;

/*

    Goal : 친구추천 알고리즘 구현하기
    Parameters: 사용자 아이디 user, 친구관계정보 friends, 사용자 타임라인 방문기록 visitors

    - 사용자와 함께 아는 친구의 수 : 10점
    - 사용자의 타임라인 방문 횟수 : 1점
    => 점수 높은 순으로 정렬하여 5명 리턴
    - 점수가 0인 경우 추천 X, 점수가 같을 경우 이름순 정렬

    To dos
    [ ] 친구 목록 구하기

    [ ] 점수 계산
    [ ] 0점 유저 제거 및 정렬
 */

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userList = new TreeMap<String, Integer>();
        Set<String> friendList = new HashSet<String>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).contains(user)) {
                    String name = friends.get(i).get(j);
                    friendList.add(name);
                }
            }
        }
        friendList.remove(user);

        for (int i = 0; i < friends.size(); i++) {

            if (!userList.containsKey(friends.get(i).get(0)) && !friendList.contains(friends.get(i).get(0))) {
                userList.put(friends.get(i).get(0), 0);
            }
            if (!userList.containsKey(friends.get(i).get(1)) && !friendList.contains(friends.get(i).get(1))) {
                userList.put(friends.get(i).get(1), 0);
            }
            if (friendList.contains(friends.get(i).get(0))) {
                userList.put(friends.get(i).get(1), userList.get(friends.get(i).get(1)) + 10);
            } else if (friendList.contains(friends.get(i).get(1))) {
                userList.put(friends.get(i).get(0), userList.get(friends.get(i).get(0)) + 10);
            }

        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!userList.containsKey(visitors.get(i)) && !(friendList.contains(visitors.get(i)))) {
                userList.put(visitors.get(i), 0);
            }
            if (userList.containsKey(visitors.get(i))) {
                userList.put(visitors.get(i), userList.get(visitors.get(i)) + 1);
            }
        }

        userList.remove(user);



        List<String> answer = new ArrayList<>(userList.keySet());


        return answer;
    }
}
