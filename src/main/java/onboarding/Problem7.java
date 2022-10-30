package onboarding;

import java.util.*;

/**
 * 기능목록
 * 1. 유저 객체 생성(친구 리스트 생성, 추천친구 hash생성)
 * 2. 모든 유저의 객체 생성, 친구관계 저장
 * 3. 유저의 친구의 친구에 대해 점수 증가
 * 4. 유저의 타임라인의 방문자에게 점수부여 (이때 친구는 증가 시켜선 안된다)
 * 5. 점수가 가장 높은 순으로 정렬하여 최대 5명 출력, 같을시에는 이름순정렬
 * (0점은 해시맵에 들어오지 않은 경우여서 존재하지 않음)
 */

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, User> allUsers = new HashMap<>();

        //자신객체 생성
        allUsers.put(user, new User(user));

        //친구객체 생성 및 관계 연결
        for (List<String> tempRelation : friends) {
            String first = tempRelation.get(0);
            String second = tempRelation.get(1);

            addFriends(allUsers, first, second);
            addFriends(allUsers, second, first);
        }

        //user객체
        User nowUser = allUsers.get(user);
        //현재 유저의 친구 리스트 저장
        List<String> userFriendList = nowUser.friendsList;

        //유저의 친구의 친구들에게 점수 부여
        for (String friendName : userFriendList) {
            User nowFriend  = allUsers.get(friendName);
            //친구의 친구 리스트
            List<String> nowFriendList = nowFriend .friendsList;
            for (String friendOfFriend : nowFriendList) {
                nowUser.addLinkedFriendsPoint(friendOfFriend);
            }
        }

        //타임라인 방문유저에게 점수 부여
        for (String visitorsName : visitors) {
            nowUser.addVisitededFriendsProint(visitorsName);
        }

        List<RecommendFriend> allRecommendedFriends = SortRecommendsdFriends(nowUser.recommendFriendsHash);

        for (int i = 0; i < allRecommendedFriends.size() && i < 5; i++) {
            answer.add(allRecommendedFriends.get(i).name);
        }

        return answer;
    }

    //해쉬맵의 values 정렬
    private static List<RecommendFriend> SortRecommendsdFriends(HashMap<String, RecommendFriend> recommendFriendsHash) {
        List<RecommendFriend> allRecommendedFriends = new ArrayList<>();

        for(String friendName : recommendFriendsHash.keySet()){
            allRecommendedFriends.add(recommendFriendsHash.get(friendName));
        }

        allRecommendedFriends.sort((o1, o2) -> {
            if (o1.point == o2.point) {
                return o1.name.compareTo(o2.name);
            }
            return o2.point - o1.point;
        });
        return allRecommendedFriends;
    }

    //allUsers 테이블에 없다면 추가한다. 관계를 각각의 객체에 추가한다.
    private static void addFriends(HashMap<String, User> allUsers, String firstFriend, String secondFriend) {
        if (!allUsers.containsKey(firstFriend)) {
            allUsers.put(firstFriend, new User(secondFriend));
        }
        allUsers.get(firstFriend).addFriends(secondFriend);
    }

    public static void main(String[] args) {

    }

}
