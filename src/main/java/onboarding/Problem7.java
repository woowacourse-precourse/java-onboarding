package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            if(!isCorrectInputs(user,friends,visitors)) {
                throw new Exception("제한사항에 위배되는 input값입니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> recommendFriendToPointMap = new HashMap<>();
        HashMap<String, List<String>> friendsMap = makeFriends(friends);

        setPointsForFriendsMap(user, friendsMap, recommendFriendToPointMap);
        setPointsForVisitorMaps(visitors, recommendFriendToPointMap);

        List<String> usersFriendsList = friendsMap.get(user);
        removeMapUsersFriends(usersFriendsList, recommendFriendToPointMap);

        List<String> sortedRecommendList = sortByRestrictions(recommendFriendToPointMap);

        return sortedRecommendList;
    }

    private static boolean isCorrectInputs(String user, List<List<String>> friends, List<String> visitors) {
        if(user.length()<1||user.length()>30) return false;
        if(friends.size()<1||friends.size()>10000) return false;
        for (List<String> friend : friends) {
            if(friend.size()!=2) return false;
            String friend1 = friend.get(0);
            String friend2 = friend.get(0);
            if((friend1.length()<1||friend1.length()>30)) return false;
            if(friend2.length()<1||friend2.length()>30) return false;
        }
        if(visitors.size()<0||visitors.size()>10000) return false;

        return true;
    }

    private static HashMap<String, List<String>> makeFriends(List<List<String>> friends) {
        HashMap<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            List<String> friend1List = friendsMap.getOrDefault(friend1, new ArrayList<String>());
            friend1List.add(friend2);
            friendsMap.put(friend1, friend1List);

            List<String> friend2List = friendsMap.getOrDefault(friend2, new ArrayList<String>());
            friend2List.add(friend1);
            friendsMap.put(friend2, friend2List);
        }

        return friendsMap;
    }

    private static void setPointsForFriendsMap(String user, HashMap<String,List<String>> friendsMap, HashMap<String, Integer> recommendFriendToPointMap) {
        List<String> usersFriendsList = friendsMap.get(user);
        for (String usersFriend : usersFriendsList) {
            List<String> friendsToFriendsList = friendsMap.get(usersFriend);
            for (String friendsToFriend : friendsToFriendsList) {
                if(friendsToFriend==user) continue; //친구의 친구가 user인경우는 skip
                Integer beforePoint = recommendFriendToPointMap.getOrDefault(friendsToFriend, 0);
                recommendFriendToPointMap.put(friendsToFriend, beforePoint + 10);
            }
        }
    }

    private static void setPointsForVisitorMaps(List<String> visitors, HashMap<String,Integer> recommendFriendToPointMap) {
        for (String visitor : visitors) {
            Integer beforePoint = recommendFriendToPointMap.getOrDefault(visitor, 0);
            recommendFriendToPointMap.put(visitor, beforePoint + 1);
        }
    }

    private static void removeMapUsersFriends(List<String> usersFriends, HashMap<String, Integer> recommendFriendToPointMap) {
        for (String usersFriend : usersFriends) {
            recommendFriendToPointMap.remove(usersFriend);
        }
    }

    private static List<String> sortByRestrictions(HashMap<String, Integer> recommendFriendToPointMap ) {
        // Map.Entry 리스트 작성
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(recommendFriendToPointMap.entrySet());

        //점수 내림차순 정렬
       Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
           @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
               // 오름 차순 정렬 + 점수가 같은경우 알파벳순 정렬
               if (obj1.getValue() > obj2.getValue()) {
                   return -1;
               } else if (obj1.getValue() == obj2.getValue()) {
                   return obj1.getKey().compareTo(obj2.getKey());
               }else return 1;
            }
        });

        List<String> sortedRecommendList = new ArrayList<>();
        for (Map.Entry<String, Integer> listEntry : listEntries) {
            sortedRecommendList.add(listEntry.getKey());
            if(sortedRecommendList.size()==5) break;
        }
        return sortedRecommendList;
    }

}

