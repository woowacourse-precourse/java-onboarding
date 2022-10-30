package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 *
 * Class : Problem 7
 *
 * Date : 2022.10.31
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. user를 등록하고 friends를 통해 나와 친구인 사람들을 저장한다.
 * 2. friends에서 친구의 친구를 찾아 point가 10인 sns 사용자 dictionary 생성
 * 3. visitors를 통해 dictionary에 존재하지 않으면 새로 생성하고 존재하면 point 1씩 추가
 * 4. dictionary에서 point가 높은 순으로 5명 return하되 point가 0인 sns사용자는 return하지 않는다.
 * 5. 아이디는 길이가 1 이상 30 이하, friends와 visitors는 길이가 1 이상 10,000 이하인 리스트/배열로 제한한다.
 *
 * */

public class Problem7 {

    static int checkIndex(int index){
        if (index == 0) return 1;
        else return 0;
    }

    static List<String> getMyFriends(String user, List<List<String>> friendList){
        List<String> myFriends = new ArrayList<>();

        // if sns user is my friend, append to list
        for (int i = friendList.size()-1; i >= 0; i--){
            if (friendList.get(i).contains(user)){
                int indexUser = friendList.get(i).indexOf(user);
                myFriends.add(friendList.get(i).get(checkIndex(indexUser)));
                friendList.remove(friendList.get(i));
            }
        }
        return myFriends;
    }

    static HashMap<String, Integer> getRecommendFriend(List<List<String>> friendList, List<String> myFriends){
        HashMap<String, Integer> recommendFriend = new HashMap<>();

        // find sns users who are my friend's friend
        for (List<String> friendOfFriend : friendList){
            for(String myFriend : myFriends){
                if (friendOfFriend.contains(myFriend)){
                    String recommend = friendOfFriend.get(checkIndex(friendOfFriend.indexOf(myFriend)));

                    // give 10pt to user
                    recommendFriend.put(recommend, 10);
                }
            }
        }
        return recommendFriend;
    }

    static HashMap<String, Integer> getRecommendVisitor(HashMap<String, Integer> recommendFriend,
                                                        List<String> myFriends, List<String> visitors) {

        // find sns users who visit my sns
        for(String visitor : visitors){
            if (recommendFriend.containsKey(visitor)){
                recommendFriend.put(visitor, recommendFriend.get(visitor) + 1);
            }
            else {
                if (!myFriends.contains(visitor)){
                recommendFriend.put(visitor, 1);
                }
            }
        }
        return recommendFriend;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<List<String>> friendList = new ArrayList<>(friends);

        // find user's friends
        List<String> myFriends = getMyFriends(user, friendList);

        // make a dictionary to give points to my friend's friend
        HashMap<String, Integer> recommendFriend = getRecommendFriend(friendList, myFriends);

        // make a dictionary to give points to visitors
        getRecommendVisitor(recommendFriend, myFriends, visitors);

        System.out.println(recommendFriend);

        return answer;
    }


}
