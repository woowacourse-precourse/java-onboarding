package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriendList = findUserFriend(user,friends);
        Map<String,Integer> recommendFriend = knowingTogetherScore(userFriendList,friends,user);
        return answer;
    }

    //friends 배열을 통해 함께 아는 친구 가중치 계산 기능
    public static Map<String,Integer> knowingTogetherScore(List<String> userFriendList, List<List<String>> friends,String user){
        Map<String,Integer> recommendFriend = new HashMap<>();
        for(int i=0; i<friends.size(); i++) { //전체 친구 목록을 돌면서
            List<String> nowFriendship = friends.get(i);
            for(int j=0; j<userFriendList.size(); j++){ //유저의 친구 목록과 비교
                String nowUserFriend = userFriendList.get(j);
                if (Objects.equals(nowFriendship.get(1), nowUserFriend) && !nowFriendship.contains(user)) { //유저의 친구의 친구일때
                    String newUserName = nowFriendship.get(0);
                    if (recommendFriend.containsKey(newUserName)){ //key가 존재한다면
                        int userScore = recommendFriend.get(newUserName);
                        recommendFriend.put(newUserName,userScore+10);
                        continue;
                    }else{//새로 map에 등록하는 경우
                        recommendFriend.put(newUserName,10);
                        continue;
                    }
                }
                if (Objects.equals(nowFriendship.get(0), nowUserFriend) && !nowFriendship.contains(user)) { //유저의 친구의 친구일때
                    String newUserName = nowFriendship.get(1);
                    if (recommendFriend.containsKey(newUserName)){ //key가 존재한다면
                        int userScore = recommendFriend.get(newUserName);
                        recommendFriend.put(newUserName,userScore+10);
                    }else{//새로 map에 등록하는 경우
                        recommendFriend.put(newUserName,10);
                    }
                }
            }
        }
        return recommendFriend;
    }

    //user와 친구인 사용자 추려내는 기능
    public static List<String> findUserFriend(String user, List<List<String>> friends){
        List<String> userFriendList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if (Objects.equals(friends.get(i).get(0), user)){
                userFriendList.add(friends.get(i).get(1));
            }else if(Objects.equals(friends.get(i).get(1), user)){
                userFriendList.add(friends.get(i).get(0));
            }
        }
        return userFriendList;
    }
}
