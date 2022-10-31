package onboarding;

import java.util.*;

/**
 * 문제 분석
 * 1. 친구 추천 알고리즘의 우선순위 부여 조건을 제시해 주고있는 문제로 보인다.
 *          즉, 정렬을 사용하고 이를 위한 클래스를 정의해야한다.
 *          class Users
 *              1. 이름 (String)
 *              2. 점수 (Integer)
 *              3. 친구들 (List<Users>)
 *          conpareto 조건
 *              - 점수순 정렬
 *              - 점수가 같다면 이름순 정렬
 * 2. 친구 관계를 설졍 한후 점수를 부여해야한다.
 *          1. 친구 관계 설정
 *              -> 양방향으로 A.친구들 ,B.친구들 각각의 리스트에 넣어줘야한다.
 *          2. 점수 설정
 *              1. 함께 아는 친구의 수 에 대한 점수 카운트
 *              2. 타임라인 방문 횟수 카운트
 *              3. 단, 이미 친구인 유저는 점수를 카운트 하지 않는다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Users> hs = new HashMap<>();
        Set<String> check = new HashSet<>();
        hs.put(user, new Users(user));
        // 친구 관계 설정
        for (int i = 0; i < friends.size(); i++) {
            String aName = friends.get(i).get(1);
            String bName = friends.get(i).get(0);
            if (!hs.containsKey(aName)) {
                hs.put(aName, new Users(aName));
            }
            if (!hs.containsKey(bName)) {
                hs.put(bName, new Users(bName));
            }
            Users userA = hs.get(aName);
            Users userB = hs.get(bName);
            userA.addFriends(userB);
            userB.addFriends(userA);
        }

        // 점수 측정 && user 와 이미 친구인 사용자를 check 에 저장
        Users target = hs.get(user);
        check.add(user);
        // 친구의 친구들 점수 측정
        for (int i = 0; i < target.friends.size(); i++) {
            Users friend = target.friends.get(i);
            check.add(friend.name);
            for (int j = 0; j < friend.friends.size(); j++) {
                friend.friends.get(j).point += 10;
            }
        }
        // 방문자 점수 측정
        for (String str : visitors) {
            if (!hs.containsKey(str)) {
                hs.put(str, new Users(str));
            }
            hs.get(str).point += 1;
        }
        // 정렬
        ArrayList<Users> recommendFriends = new ArrayList<>(hs.values());
        Collections.sort(recommendFriends);
        for (int i = 0; i < recommendFriends.size(); i++) {
            String name = recommendFriends.get(i).name;
            if (answer.size() >= 5 || recommendFriends.get(i).point == 0) {
                break;
            }
            if (!check.contains(name)) {
                answer.add(name);
            }
        }
        return answer;
    }
}

class Users implements Comparable<Users> {
    String name;
    int point = 0;
    List<Users> friends = new ArrayList<>();

    public void addFriends(Users users) {
        this.friends.add(users);
    }

    public Users(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Users o) {
        if (this.point == o.point) {
            return this.name.compareTo(o.name);
        }
        return o.point - this.point;
    }
}
