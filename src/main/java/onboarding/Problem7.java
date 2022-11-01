package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); /* 정답 */
        List<String> myFriendsList = new ArrayList<>();
        List<String> recommendFriend = new ArrayList<>();
        int recommendPoint = 10;
        int visitPoint = 1;
        LinkedHashMap<String, Integer> map = new LinkedHashMap();

        List<Integer> lastValue = new ArrayList<>();
        LinkedHashSet<String> highRankFriends = new LinkedHashSet<>();

        /* visitors를 새로운 배열에 저장시켜서 sort */
        List<String> sortVisitors = new ArrayList<>();

        for (String visitor : visitors) {
            sortVisitors.add(visitor);
        }
        Collections.sort(sortVisitors);

        /* 1. friends 목록을 받아와서 내 이름이 들어간 친구들을 추출. */
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                if (friends.get(i).contains(user) &&
                        !myFriendsList.contains(friends.get(i).get(j)) &&
                        !friends.get(i).get(j).equals(user)) {
                    myFriendsList.add(friends.get(i).get(j));
                }
            }
        }

        /* 2. 내(user)의 친구들의 친구들 목록을 뽑는다. */
        if (myFriendsList.size() != 0) {
            for (int i = 0; i < friends.size(); i++) {
                for (int j = 0; j < friends.get(i).size(); j++) {
                    if (!friends.get(i).contains(user) &&
                            !myFriendsList.contains(friends.get(i).get(j))) {
                        recommendFriend.add(friends.get(i).get(j));
                    }
                }
            }
            Collections.sort(recommendFriend);
        }

        /* 3. 추천 친구들의 점수를 명당 10점씩 */
        for (int i = 0; i < recommendFriend.size(); i++) {
            map.put(recommendFriend.get(i),recommendPoint);
            if (map.containsKey(recommendFriend.get(i))) {
                map.put(recommendFriend.get(i),map.get(recommendFriend.get(i))+10);
            }
        }

        /* 4. 방문자 조회 ( 내 친구 ( donut , shakevan )을 빼고 조회 )
           5. 추린 방문자를 map에 +1점씩 해주고, 추천 친구와 동일하면 거기에 누적해서 +1 더해준다. */
        for (int i = 0; i < sortVisitors.size(); i++) {
            if(!myFriendsList.contains(sortVisitors.get(i))) {
                if (map.containsKey(sortVisitors.get(i))) {
                    map.put(sortVisitors.get(i),map.get(sortVisitors.get(i))+visitPoint);
                }else {
                    map.put(sortVisitors.get(i), visitPoint);
                }
            }
        }

        /* 6. 상위 점수 5명의 이름을 출력한다
           map의 모든 key와 value 출력을 까먹어서 검색했다. */
        /* 우와 근데 향상된 for문을 쓰면 iterator를 쓸 필요가 없구나.. */
        for (String key : map.keySet()) {
            lastValue.add(map.get(key));
        }
        /* 내림차순은 몰라서 구글링했따. */
        Collections.sort(lastValue, Comparator.reverseOrder());


        /* lastValue를 내림차순으로 정렬하고,
           그 정렬한 값에( 상위 5명 ) 맞춰서 key값을 중복 없에 Set에 집어넣는 과정이다. */
        for (int i = 0; i < lastValue.size(); i++) {
            for (String key : map.keySet()) {
                if (lastValue.get(i) == map.get(key) &&
                    !answer.contains(key) &&
                    lastValue.get(i) != 0) {
                    highRankFriends.add(key);
                }
            }
        }

        /* 상위 5명의 값을 answer에 추가해줌 . */
        for (String name : highRankFriends) {
            answer.add(name);
            if (answer.size() == 5) {
                break;
            }
        }

        return answer;
    }
}
