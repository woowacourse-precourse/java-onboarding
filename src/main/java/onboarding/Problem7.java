package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        HashMap<String, Integer> friendsMap = new HashMap<>();
        List<String> oldFriendNames = checkOldFriends(friends, user, friendsMap, visitors);
        putNewFriends(friends, oldFriendNames, friendsMap, user);
        putVisitor(visitors, oldFriendNames, friendsMap);
        answer = hashMapToList(friendsMap);
        return answer;
    }

    private static List<String> checkOldFriends(List<List<String>> friendsList, String userName, HashMap friendsMap, List<String> visitor){
        List<String> oldFriendNames = new ArrayList<>();

        for(int i = 0; i < friendsList.size(); i++){
            int oldFriends = friendsList.get(i).indexOf(userName);
            if(oldFriends > -1) oldFriendNames.add(friendsList.get(i).get(1-oldFriends));
        }

        return oldFriendNames;
    }

    private static void putNewFriends(List<List<String>> friendsList, List<String> oldFriendName, HashMap friendsMap, String userName){
        for(int i = 0; i < friendsList.size(); i++){
            for(int j = 0; j < oldFriendName.size(); j++){
                int newFriends = friendsList.get(i).indexOf(oldFriendName.get(j));
                if(newFriends > -1 && !friendsList.get(i).get(1 - newFriends).equals(userName)){
                    String newFriendName = friendsList.get(i).get(1 - newFriends);
                    if(friendsMap.containsKey(newFriendName)) friendsMap.put(newFriendName, (int)friendsMap.get(newFriendName)+10);
                    if(!friendsMap.containsKey(newFriendName)) friendsMap.put(newFriendName, 10);
                }
            }
        }
    }

    private static void putVisitor(List<String> visitor, List<String> oldFriendName, HashMap friendsMap){
        for(int i = 0; i < visitor.size(); i++){
            String visitorName = visitor.get(i);
            if(friendsMap.containsKey(visitorName)) friendsMap.put(visitorName, (int)friendsMap.get(visitorName)+1);
            if(!friendsMap.containsKey(visitorName)) friendsMap.put(visitorName, 1);
        }
        for(int i = 0; i < oldFriendName.size(); i++){
            friendsMap.remove(oldFriendName.get(i));
        }
    }

    private static List<String> hashMapToList(HashMap recommendFriends) {
        List<String> keys = new ArrayList<>(recommendFriends.keySet());
        int topRecommend = 0;

        Collections.sort(keys);
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer value1 = (Integer) recommendFriends.get(o1);
                Integer value2 = (Integer) recommendFriends.get(o2);
                return value2.compareTo(value1);
            }
        });
        List<String> result = new ArrayList<>();

        if(keys.size() < 5){
            topRecommend = keys.size();
        }
        if(keys.size() >= 5){
            topRecommend = 5;
        }
        for(int i = 0; i < topRecommend; i++){
            result.add(String.valueOf(keys.get(i)));
        }
        return result;
    }
}
