package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriend = new ArrayList<String>();
        HashMap<String, Integer> friendsPoint = new HashMap<String, Integer>();
        for(List<String> friend : friends){
            if(friend.contains(user))
                userFriend.add(friend.get(Math.abs(1-friend.indexOf(user))));
        }

        for(List<String> friendRelationship : friends){
            for(String friend : userFriend){
                updateFriendPoint(friendsPoint, friendRelationship, friend);
            }
        }

        for(String name : visitors){
            if(friendsPoint.containsKey(name)){
                friendsPoint.put(name, friendsPoint.get(name) + 1);
            }
            else{
                friendsPoint.put(name, 1);
            }
        }
        friendsPoint.remove(user);
        for(String name : userFriend){
            friendsPoint.remove(name);
        }

        answer = new ArrayList<String>(friendsPoint.keySet());
        if(answer.size() > 5)answer = answer.subList(0, 5);
        return answer;
    }

    public static String getPartnerName(List<String> relationship, String name){
        return relationship.get(Math.abs(1-relationship.indexOf(name)));
    }

    public static void updateFriendPoint(HashMap<String, Integer> pointMap, List<String> relationship, String name){
        if(!relationship.contains(name)) return;
        if(pointMap.containsKey(name)){
            pointMap.put(getPartnerName(relationship, name), pointMap.get(getPartnerName(relationship, name) + 10));
        }
        else{
            pointMap.put(getPartnerName(relationship, name), 10);
        }
    }
}