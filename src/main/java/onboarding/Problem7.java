package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = checkUserFriends(user, friends);
        HashMap<String, Integer> friendsData = checkFriends(user, userFriends, friends);
        friendsData = checkVisitors(friendsData, visitors, userFriends);


        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(friendsData.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() > o2.getValue()){
                    return -1;
                }
                else if(o1.getValue() < o2.getValue()){
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> answer = new ArrayList<>();
        if(entryList.size() <= 5){
            for(Map.Entry<String, Integer> entry : entryList){
                answer.add(entry.getKey());
            }
        }
        else{
            for(int i = 0; i < 5; i++){
                answer.add(entryList.get(i).getKey());
            }
        }

        return answer;
    }

    static List<String> checkUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                userFriends.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                userFriends.add(friends.get(i).get(0));
            }
        }
        return userFriends;
    }

    static HashMap<String, Integer> checkFriends(String user, List<String> userFriends, List<List<String>> friends){
        HashMap<String, Integer> friendsData = new HashMap<>();

        for(int i = 0; i < friends.size(); i++){
            if(isFriendsName(userFriends, friends.get(i).get(0)) && !user.equals(friends.get(i).get(1))){
                String key = friends.get(i).get(1);
                if(isNameInMap(friendsData, key)){
                    friendsData.put(key, friendsData.get(key) + 10);
                }
                else{
                    friendsData.put(key, 10);
                }
            }
            else if(isFriendsName(userFriends, friends.get(i).get(1)) && !user.equals(friends.get(i).get(0))){
                String key = friends.get(i).get(0);
                if(isNameInMap(friendsData, key)){
                    friendsData.put(key, friendsData.get(key) + 10);
                }
                else{
                    friendsData.put(key, 10);
                }
            }
        }
        return friendsData;
    }

    static HashMap<String, Integer> checkVisitors(HashMap<String, Integer> friendsData, List<String> visitors, List<String> userFriends){
        for(String name : visitors){
            String key = name;
            if(!isFriendsName(userFriends, name)){
                if(isNameInMap(friendsData, name)){
                    friendsData.put(key, friendsData.get(key) + 1);
                }
                else{
                    friendsData.put(key, 1);
                }
            }
        }
        return friendsData;
    }
    static boolean isFriendsName(List<String> userFriends, String name){
        for(String friendsName : userFriends)
            if(friendsName.equals(name))
                return true;
        return false;
    }

    static boolean isNameInMap(HashMap<String, Integer> friendsData, String name) {
        for (String key : friendsData.keySet())
            if (key.equals(name))
                return true;
        return false;
    }
}
