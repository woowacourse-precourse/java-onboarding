package onboarding;

import java.util.*;

/**
 * 기능목록 <br>
 * 1. 유저 객체 생성(친구 리스트 생성, 추천친구 hash생성) <br>
 * 2. 모든 유저의 객체 생성, 친구관계 저장  <br>
 * 3. 유저의 친구의 친구에 대해 점수 증가  <br>
 * 4. 유저의 타임라인의 방문자에게 점수부여 (이때 이미 친구인 관계는 증가 시켜선 안된다) <br>
 * 5. 점수가 가장 높은 순으로 정렬하여 최대 5명 출력, 같을시에는 이름순으로 정렬 <br>
 * (0점은 해시맵에 들어오지 않은 경우여서 존재하지 않음) <br>
 * <p>
 * RecommendFriend.Java,User.Java 클래스 생성
 */

public class Problem7 {
    private static final HashMap<String, User> allUsers = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //모든 유저와 친구관계를 저장한다.
        addAllFriendsRelation(friends);

        //찾고자 하는 user의 모든 추천친구리스트 반환한다.
        List<RecommendFriend> usersRecommendedList = findUsersRecommendedList(user, visitors);

        //최대 5명까지의 추천친구의 이름을 리턴한다.
        int wantRankNum = 5;
        return highPointRecommendedFriendsNameList(usersRecommendedList, wantRankNum);
    }

    //친구객체를 생성하고, 친구관계를 생성한다.
    private static void addAllFriendsRelation(List<List<String>> friends) {
        for (List<String> tempRelation : friends) {
            String first = tempRelation.get(0);
            String second = tempRelation.get(1);

            addFriends(first, second);
            addFriends(second, first);
        }
    }

    //찾고자 하는 user의 모든 추천친구리스트 반환한다.
    private static List<RecommendFriend> findUsersRecommendedList(String user, List<String> visitors) {
        //찾고자 하는 user객체를 찾는다
        User nowUser = allUsers.get(user);

        //현재 유저와 친구인 관계리스트를 저장한다.
        List<String> userFriendList = nowUser.friendsList;

        addFriendsFriendsPoint(nowUser, userFriendList);
        addVisitedFriendsPoint(nowUser, visitors);

        //정렬된 추천 친구 리스트를 반환한다.
        return sortRecommendFriends(nowUser.recommendFriendsHash);

    }

    //친구의 친구인 경우에 점수를 부여한다.
    private static void addFriendsFriendsPoint(User nowUser, List<String> userFriendList) {
        for (String friendName : userFriendList) {
            User nowFriend = allUsers.get(friendName);
            //친구의 친구 리스트
            List<String> nowFriendList = nowFriend.friendsList;
            for (String friendOfFriend : nowFriendList) {
                nowUser.addLinkedFriendsPoint(friendOfFriend);
            }
        }
    }

    //타임라인에 방문한 친구에게 점수를 부여한다.
    private static void addVisitedFriendsPoint(User nowUser, List<String> visitors) {
        for (String visitorsName : visitors) {
            nowUser.addVisitededFriendsProint(visitorsName);
        }
    }

    //최대 maxNum명까지 추천친구의 이름을 정렬하여 리턴한다.
    private static List<String> highPointRecommendedFriendsNameList(List<RecommendFriend> allRecommendedFriends, int maxNum) {
        List<String> recommendedFriendsList = new ArrayList<>();
        for (int i = 0; i < allRecommendedFriends.size() && i < maxNum; i++) {
            recommendedFriendsList.add(allRecommendedFriends.get(i).name);
        }
        return recommendedFriendsList;
    }

    //추천친구 해시맵의 value를 점수와 이름순 정렬한다.
    private static List<RecommendFriend> sortRecommendFriends(HashMap<String, RecommendFriend> recommendFriendsHash) {
        List<RecommendFriend> allRecommendedFriends = new ArrayList<>();

        for (String friendName : recommendFriendsHash.keySet()) {
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

    //친구관계를 추가한다
    private static void addFriends(String firstFriend, String secondFriend) {
        User firstUser = findUser(firstFriend);
        firstUser.addFriends(secondFriend);
    }

    //특정 유저를 찾는다
    private static User findUser(String name) {
        if (!allUsers.containsKey(name)) {
            allUsers.put(name, new User(name));
        }
        return allUsers.get(name);
    }

}
