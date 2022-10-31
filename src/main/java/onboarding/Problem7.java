package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); /** 정답 */
        List<String> myFriendsList = new ArrayList<>();
        List<String> recommendFriend = new ArrayList<>();
        int recommendPoint = 10;
        List<String> visitFriend = new ArrayList<>(); /** 방문 친구 목록은 필요 없나...? */
        int visitPoint = 1;
        LinkedHashMap<String, Integer> map = new LinkedHashMap();

        List<String> checkPoint = new ArrayList<>();
        List<Integer> lastValue = new ArrayList<>();
        LinkedHashSet<String> highRankFriends = new LinkedHashSet<>();


        /**
         * visitors를 새로운 배열에 저장시켜서 sort
         */
        List<String> sortVisitors = new ArrayList<>();

        for (String visitor : visitors) {
            System.out.println("visitor = " + visitor);
            sortVisitors.add(visitor);
        }

        Collections.sort(sortVisitors);

        for (String sortVisitor : sortVisitors) {
            System.out.println("sortVisitor = " + sortVisitor);
        }


        /**
         * 1. friends 목록을 받아와서 내 이름이 들어간 친구들을 추출.
         */
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                if (friends.get(i).contains(user) &&
                        !myFriendsList.contains(friends.get(i).get(j)) &&
                        !friends.get(i).get(j).equals(user)) {
                    myFriendsList.add(friends.get(i).get(j));
                }
            }
        }
        for (int i = 0; i < myFriendsList.size(); i++) {
            System.out.println("myFriendList = " + myFriendsList.get(i));
        }
        /**
         * 2. 내(user)의 친구들의 친구들 목록을 뽑는다.
         */
        if (myFriendsList.size() != 0) {
            for (int i = 0; i < friends.size(); i++) {
                for (int j = 0; j < friends.get(i).size(); j++) {
                    if (!friends.get(i).contains(user) &&
                            !myFriendsList.contains(friends.get(i).get(j))) {
                        System.out.println("friends = " + friends.get(i).get(j));
                        recommendFriend.add(friends.get(i).get(j));
                    }
                }
            }
            Collections.sort(recommendFriend);
        }
        /**
         * 3. 추천 친구들의 점수를 명당 10점씩
         */
        for (int i = 0; i < recommendFriend.size(); i++) {
            System.out.println("recommendFriend.get(i) = " + recommendFriend.get(i));
            map.put(recommendFriend.get(i),recommendPoint);
            if (map.containsKey(recommendFriend.get(i))) {
                map.put(recommendFriend.get(i),map.get(recommendFriend.get(i))+10);
            }
        }
        System.out.println("map.get(\"jun\") = " + map.get("jun"));

        /**
         * 4. 방문자 조회 ( 내 친구는 뺀 방문자를 조회 ! donut,shakevan )
         */
//        for (int i = 0; i < visitors.size(); i++) {
//            if(!myFriendsList.contains(visitors.get(i))) {
//                System.out.println("visitors = " + visitors.get(i));
//                map.put(visitors.get(i),visitPoint);
//                if (map.containsKey(visitors.get(i))) {
//                    map.put(visitors.get(i),map.get(visitors.get(i))+1);
//                }
//            }
//        }
        /**
         * 4. 방문자 조회 ( 내 친구 ( donut , shakevan )을 빼고 조회 )
         * 5. 추린 방문자를 map에 +1점씩 해주고, 추천 친구와 동일하면 거기에 누적해서 +1 더해준다.
         */

        for (int i = 0; i < sortVisitors.size(); i++) {
            if(!myFriendsList.contains(sortVisitors.get(i))) {
                System.out.println("sortVisitors = " + sortVisitors.get(i));
                if (map.containsKey(sortVisitors.get(i))) {
                    map.put(sortVisitors.get(i),map.get(sortVisitors.get(i))+1);
                }else {
                    map.put(sortVisitors.get(i), visitPoint);
                }
            }
        }
        System.out.println("map.get(\"bedi\") = " + map.get("bedi"));

        /**
         * 6. 상위 점수 5명의 이름을 출력한다
         * map의 모든 key와 value 출력을 까먹어서 검색했다.
         */
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println("key = " + keys.next() +"value = " + map.get(keys.next()));
//        }
        System.out.println("*************************************");
        /** 우와 근데 향상된 for문을 쓰면 iterator를 쓸 필요가 없구나.. */
        for (String key : map.keySet()) {
            if (map.get(key) == map.get(key)) {
                System.out.println("map.get(key) = " + map.get(key));
            }
            System.out.println("value = " + map.get(key));
            System.out.println("key = " + key);
            lastValue.add(map.get(key));
        }
        /** 내림차순은 몰라서 구글링했따. */
        Collections.sort(lastValue, Comparator.reverseOrder());


        /**
         * lastValue를 내림차순으로 정렬하고,
         * 그 정렬한 값에( 상위 5명 ) 맞춰서 key값을 중복 없에 Set에 집어넣는 과정이다.
         */
        for (int i = 0; i < lastValue.size(); i++) {
            for (String key : map.keySet()) {
                if (lastValue.get(i) == map.get(key) &&
                    !answer.contains(key) &&
                    lastValue.get(i) != 0) {
//                    answer.add(key);
//                    System.out.println("key11 = " + key + " , value = " + map.get(key));
                    highRankFriends.add(key);
//                    if (map.get(key) == map.get(key) &&
//                        !checkPoint.contains(key)) {
//                        System.out.println("map.get(key) = " + map.get(key));
//                        checkPoint.add(key);
//                    }
                }
            }
        }
        for (String hi : checkPoint) {
            System.out.println("hi = " + hi);
        }

        /**
         * 상위 5명의 값을 answer에 추가해줌 .
         * 이제 남은 거는 점수가 같을 때 이름 순으로 정렬하는 거만 남았는데..
         */
        for (String name : highRankFriends) {
            answer.add(name);
            if (answer.size() == 5) {
                break;
            }
        }

        for (String key : map.keySet()) {
            System.out.println("map.get(key)로 중복값만 따로 빼내서 먼저 배열에 추가? = " + map.get(key));
            System.out.println("key = " + key);
            checkPoint.add(key);
        }

        for (int i = 0; i < lastValue.size(); i++) {
            System.out.println("lastValue = " + lastValue.get(i));
        }

//        for (int i = 0; i < lastValue.size(); i++) {
//            System.out.println("lastValue = " + lastValue.get(i));
//            if(map.containsValue(lastValue.get(i))) {
//            }
//            if (i == 5) {
//                break;
//            }
//        }


        return answer;
    }
}
