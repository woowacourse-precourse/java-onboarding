package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> knownFriend = checkFriend(user,friends);
        Map<String,Integer> visitPoint = visitPointFriend(knownFriend,visitors);
        Map<String,Integer> friendPoint = friendPointCal(knownFriend,friends,visitPoint,user);
        

        List<String> answer= pointToList(friendPoint);
        return answer;
    }

    private static List<String> pointToList(Map<String, Integer> friendPoint) {
        List<String> result =new ArrayList<>();

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendPoint.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<String, Integer> entry : entryList){
            result.add(entry.getKey());
        }
        
        return result;
    }

    private static Map<String,Integer> friendPointCal(List<String> knownFriend, List<List<String>> friends, Map<String, Integer> visitPoint,String user) {
        Map<String, Integer> friendPoints = new HashMap<>(visitPoint);
        int friendPoint=10;
        for (List<String> frd:
             friends) {
            if(!frd.contains(user)){
                for (String name:
                        knownFriend) {
                    if (frd.contains(name)){
                        for (String f:
                             frd) {
                            if(!f.equals(name)) {
                                if(friendPoints.containsKey(f)) {
                                    int point = friendPoints.get(f);
                                    point +=friendPoint;
                                    friendPoints.put(f, point);
                                }else{
                                    friendPoints.put(f, friendPoint);
                                }
                            }
                        }
                    }
                }
            }
        }
        return friendPoints;
    }

    public static Map<String,Integer> visitPointFriend(List<String> knownFriend,List<String> visitors){
        List<String> knownFriends = new ArrayList<>(knownFriend);
        Map<String,Integer> friend = new HashMap<>();
        int visitPoint=3;
        for (String text:
             visitors) {
            if (knownFriends.contains(text))
                knownFriends.remove(text);
            else{
                if(friend.containsKey(text)){
                    int point = friend.get(text);
                    point +=visitPoint;
                    friend.put(text,point);
                }else{
                    friend.put(text,visitPoint);
                }
            }
        }

        return friend;
    }
    public static List<String> checkFriend(String user,List<List<String>> friends){
        List<String> knownFriend =new ArrayList<>();


        for (List<String> friend : friends) {
            if (friend.contains(user)){
                knownFriend.add(friend.get(0));
                knownFriend.add(friend.get(1));
                knownFriend.remove(user);
            }
        }


        return knownFriend;
    }
}
