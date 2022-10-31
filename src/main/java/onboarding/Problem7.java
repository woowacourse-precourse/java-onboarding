package onboarding;

import java.util.*;

/**
 * 기능목록
 * 1. 친구 목록 생성
 * 2. 친구의 친구 목록 생성
 * 3. 방문자 중 친구들 제거
 * 4. 알고리즘 점수계산
 * 5. 추천친구 목록 생성
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> scoreBoard = new HashMap<>();
        visitors = new ArrayList<>(visitors);

        List<String> userFriends = findFriends(user,friends);
        List<String> userFOAF = findFOAF(user,friends,userFriends);
        setVisitors(visitors,userFriends);
        setScore(scoreBoard,userFOAF,10);
        setScore(scoreBoard,visitors,1);
        answer = getRecommendList(scoreBoard);
        return answer;
    }

    static List<String> findFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        addOppositeUserToList(userFriends,user,friends);
        return  userFriends;
    }

    static void addOppositeUserToList(List<String> list, String user , List<List<String>> friends){
        for(List<String> friend : friends){
            if(friend.get(0) == user){
                list.add(friend.get(1));

            } else if (friend.get(1) == user) {
                list.add(friend.get(0));
            }
        }
    }

    static List<String> findFOAF(String user, List<List<String>> friends, List<String> userFriends){
        List<String> userFOAF = new ArrayList<>();

        for(String userFriend : userFriends){
            addOppositeUserToList(userFOAF,userFriend,friends);
        }
        while (userFOAF.remove(user)) {
        }
        userFOAF.removeAll(userFriends);
        return userFOAF;
    }

    static void setVisitors(List<String> visitors, List<String> userFriends) {
        visitors.removeAll(userFriends);
    }

    static HashMap<String, Integer> setScore(HashMap<String,Integer> scoreBoard, List<String> recommendUsers, Integer score){
        for(String recommendUser : recommendUsers){
            if(scoreBoard.get(recommendUser) == null){
                scoreBoard.put(recommendUser,score);
                continue;
            }
            scoreBoard.put(recommendUser,scoreBoard.get(recommendUser)+score);
        }
        return scoreBoard;
    }

    static List<String> getRecommendList(HashMap<String,Integer> result){
        List<String> sort = new ArrayList<>();
        List<String> listKeySet = sortByScore(result);

        for(String user : listKeySet){
            if(sort.size()<5){
                sort.add(user);
            }
        }
        return sort;
    }

    static List<String> sortByScore(HashMap<String,Integer> scoreBoard){
        List<String> recommendFriends = new ArrayList<>(scoreBoard.keySet());

        Collections.sort(recommendFriends);
        Collections.sort(recommendFriends, (value1, value2) -> (scoreBoard.get(value2).compareTo(scoreBoard.get(value1))));
        return recommendFriends;
    }
}
