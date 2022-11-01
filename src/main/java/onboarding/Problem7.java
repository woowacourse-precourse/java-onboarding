package onboarding;

import java.util.*;

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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<List<String>> friendList = new ArrayList<>(friends);

        // find user's friends
        List<String> myFriends = getMyFriends(user, friendList);

        // make a dictionary to give points to my friend's friend
        LinkedHashMap<String, Integer> recommendFriend = getRecommendFriend(friendList, myFriends);

        // make a dictionary to give points to visitors
        getRecommendVisitor(recommendFriend, myFriends, visitors);

        // sort recommendFriend by key and value
        Map<String, Integer> sortRecommendFriend = sortMapByKey(recommendFriend);

        // pick 5 people in the order of the highest score (if the point is zero, it will not be returned.)
        answer = recommendResult(sortRecommendFriend);
        return answer;
    }


    private static int checkIndex(int index){
        if (index == 0) return 1;
        else return 0;
    }

    private static List<String> getMyFriends(String user, List<List<String>> friendList){
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

    private static LinkedHashMap<String, Integer> getRecommendFriend(List<List<String>> friendList, List<String> myFriends){
        LinkedHashMap<String, Integer> recommendFriend = new LinkedHashMap<>();

        // find sns users who are my friend's friend
        for (List<String> friendOfFriend : friendList){
            for(String myFriend : myFriends){
                if (friendOfFriend.contains(myFriend)){
                    String recommend = friendOfFriend.get(checkIndex(friendOfFriend.indexOf(myFriend)));

                    // give 10pt to user
                    if (recommendFriend.containsKey(recommend)){
                        recommendFriend.put(recommend, recommendFriend.get(recommend) + 10);
                    }
                    else {
                        recommendFriend.put(recommend, 10);
                    }
                }
            }
        }
        return recommendFriend;
    }

    private static LinkedHashMap<String, Integer> getRecommendVisitor(LinkedHashMap<String, Integer> recommendFriend,
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

    // sort recommendFriend by key
    private static LinkedHashMap<String, Integer> sortMapByKey(Map<String, Integer> recommendFriend) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(recommendFriend.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        Collections.sort(entries, Collections.reverseOrder((o1, o2) -> o1.getValue().compareTo(o2.getValue())));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static List<String> recommendResult (Map<String, Integer> sortRecommendFriend){
        // return recommend friends
        List<String> recommend = new ArrayList<>();
        if (sortRecommendFriend.size() < 5){
            for (String key : sortRecommendFriend.keySet()){
                recommend.add(key);
            }
        }
        else {
            List<String> list = new ArrayList<>(sortRecommendFriend.keySet());
            for(int i = 0; i < 5; i++){
                recommend.add(list.get(i));

            }
        }
        return recommend;
    }

}
