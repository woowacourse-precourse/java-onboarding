package onboarding;

import java.util.*;

/**
 * 기능 1: 사용자의 친구 목록을 뽑는 함수 작성
 * 기능 2: 친구 추천 점수를 담을 맵 초기화 함수 작성
 * 기능 3: 사용자의 친구 목록을 사용하여 그 친구를 같이 아는 사람들에게 점수를 주는 함수 작성
 * 기능 4: 방문자에게 점수를 주는 함수 작성
 * 기능 5: 점수를 첫번째 기준으로, 이름을 두번째 기준으로 하여 내림차순으로 정렬하는 함수 작성
 * 기능 6: 이미 친구인 경우와 0점인 경우를 제외하는 함수 작성
 */
public class Problem7 {

    public static List<String> getUserFriends(List<List<String>> friends, String user) {

        List<String> userFriends = new ArrayList<>();

        // pivot을 1로 두고 user의 이름의 위치를 index로 저장하여 차이의 절대값을 구해서 user의 친구를 리스트에 담음
        final int PIVOT = 1;
        for (List<String> friendList : friends) {
            int friendIndex = friendList.indexOf(user);

            if (friendIndex != -1) {
                userFriends.add(friendList.get(Math.abs(PIVOT - friendIndex)));
            }
        }
        return userFriends;
    }

    public static Map<String, Integer> initScoreMap(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScoreMap = new HashMap<>();

        for (List<String> friendList : friends) {
            for (String name : friendList) {
                if (user != name) {
                    friendScoreMap.put(name, 0);
                }
            }
        }

        for (String visitor : visitors) {
            friendScoreMap.put(visitor, 0);
        }

        return friendScoreMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> friendScoreMap = initScoreMap(user, friends, visitors);

        return answer;
    }

}
