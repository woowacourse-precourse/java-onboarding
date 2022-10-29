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
    private static class User {
        String name;
        List<String> friendsList = new ArrayList<>();
        HashMap<String, RecommendFriend> recommendFriendsList = new HashMap<>();


        public User(String name) {
            this.name = name;
        }

        //이미 친구인 사람을 넣음
        private void addFriends(String name) {
            friendsList.add(name);
        }

        //친구의 친구인 경우
        private void addLinkedFriendsPoint(String name) {
            //이미 친구이거나 자신인경우는 제외한다.
            if (isNotInFriendsList(name)) {
                if (!recommendFriendsList.containsKey(name)) {
                    addRecommendsFriends(name);
                }
                recommendFriendsList.get(name).addLinkedFriendPoint();
            }
        }

        private void addVisitededFriendsProint(String name) {
            if(isNotInFriendsList(name)) {
                if (!recommendFriendsList.containsKey(name)) {
                    addRecommendsFriends(name);
                }
                recommendFriendsList.get(name).addVisitedFriendPoint();
            }
        }


        //새로운 추천친구 생성
        private void addRecommendsFriends(String name) {
            recommendFriendsList.put(name, new RecommendFriend(name,0));
        }

        //이미 user의 친구이거나 객체 자신인지
        private boolean isNotInFriendsList(String name) {
            if(name.equals(this.name)) return false;
            else return !friendsList.contains(name);
        }

    }

    private static class RecommendFriend {
        String name;
        int point;

        public RecommendFriend(String name, int point) {
            this.name = name;
            this.point = point;
        }

        //친구의 친구인 경우
        private void addLinkedFriendPoint(){
            this.point+=10;
        }

        //친구가 타임라인에 방문한 경우
        private void addVisitedFriendPoint(){
            this.point+=1;
        }

    }

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
        List<String> nowUserfridendsList = nowUser.friendsList;

        //유저의 친구의 친구들에게 점수 부여
        for (String friendName : nowUserfridendsList) {
            User nowFriend  = allUsers.get(friendName);
            //친구의 친구 리스트
            List<String> nowFrienList = nowFriend .friendsList;
            for (String friendOfFriend : nowFrienList) {
                nowUser.addLinkedFriendsPoint(friendOfFriend);
            }
        }

        for (String visitorsName : visitors) {
            nowUser.addVisitededFriendsProint(visitorsName);
        }

        List<RecommendFriend> allRecommendedFriedns = new ArrayList<>();

        for(String friendName : nowUser.recommendFriendsList.keySet()){
            allRecommendedFriedns.add(nowUser.recommendFriendsList.get(friendName));
        }


        return answer;
    }

    //allUsers 테이블에 없다면 추가한다. 관계를 각각의 객체에 추가한다.
    private static void addFriends(HashMap<String, User> allUsers, String firstFriend, String secondFriend) {
        if (!allUsers.containsKey(firstFriend)) {
            allUsers.put(firstFriend, new User(secondFriend));
        }
        allUsers.get(firstFriend).addFriends(secondFriend);
    }

}
