package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        /*
                1.  유저와 이미 친구인 사용자 분류   alreadyFriends
                2.  이미 친구인 사용자와 친구인 사용자 분류  newFriends
                3.  newFriends 에 점수 +10점 부여

                4.  visitors 에 점수 +1점 부여
                5.  hashMap을 사용해서 key(친구이름)값에 value(점수)를 추가
                6.  점수순으로 정렬
                7.  동일 점수는 이름 오름차순 정렬
         */

        // 유저와 이미 친구인 사용자 분류를 위한 배열 선언
        List<String> alreadyFriends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {

            if (friends.get(i).contains(user)) {
                for (int j = 0; j < 2; j++) {

                    if (friends.get(i).get(j) == user) {
                        continue;
                    }

                    if (friends.get(i).get(j) != user) {
                        alreadyFriends.add(friends.get(i).get(j));
                    }

                }
            }
        }

        // 이미 친구인 사용자와 친구인 사용자 분류를 위한 배열 선언
        List<String> newFriends = new ArrayList<>();

        for (int i = 0; i < alreadyFriends.size(); i++) {
            String alreadyTemp = alreadyFriends.get(i);

            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(alreadyTemp)) {
                    for (int k = 0; k < 2; k++) {

                        if (friends.get(j).get(k) == user) {
                            continue;
                        }

                        if (friends.get(j).get(k) == alreadyTemp) {
                            continue;
                        }

                        if (friends.get(j).get(k) != alreadyTemp) {
                            newFriends.add(friends.get(j).get(k));
                        }

                    }
                }
            }
        }


        HashMap<String, Integer> friendsPoint = new HashMap<>();

        // newFriends 목록에 점수 +10 추가
        for (int i = 0; i < newFriends.size(); i++) {
            if (friendsPoint.containsKey(newFriends.get(i))) {
                int point = friendsPoint.get(newFriends.get(i));
                friendsPoint.put(newFriends.get(i), point + 10);
            }
            if (!friendsPoint.containsKey(newFriends.get(i))) {
                friendsPoint.put(newFriends.get(i), 10);
            }
        }

        // 방문자 점수 추가
        for (int i = 0; i < visitors.size(); i++) {
            if (friendsPoint.containsKey(visitors.get(i))) {
                int point = friendsPoint.get(visitors.get(i));
                friendsPoint.put(visitors.get(i), point + 1);
            }
            if (!friendsPoint.containsKey(visitors.get(i))) {
                friendsPoint.put(visitors.get(i), 1);
            }
        }

        // 방문자 중 이미 친구인 유저 제거
        for (int i = 0; i < alreadyFriends.size(); i++) {
            friendsPoint.remove(alreadyFriends.get(i));
        }

        // 점수 내림차순 정렬을 위한 배열 선언
        List<String> result = new ArrayList<>(friendsPoint.keySet());

        // 이름 오름차순 정렬
        Collections.sort(result);

        // 점수 내림차순으로 정렬
        Collections.sort(result, (v1, v2) -> (friendsPoint.get(v2).compareTo(friendsPoint.get(v1))));

        if (result.size() > 5) {
            result = result.subList(0, 5);
        }

        return result;
    }
}
