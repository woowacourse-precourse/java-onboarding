package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String,Integer> friendScore = new HashMap<>();
        HashMap<String,String[]> friendMap = makeFriendMap(friends);

        friendScore = makeFriendScoreFriendMap(user,friendMap);
        friendScore = addVisitorScore(visitors,friendScore);

        answer = sortScore(friendScore,friendMap.get(user));

        return answer;
    }

    public static String[] arrAdd(String[] array,String str){
        String[] strArr = new String[array.length + 1];
        for(int i=0;i<array.length;i++){
            strArr[i] = array[i];
        }
        strArr[array.length] = str;
        return strArr;
    }

    public static HashMap<String,String[]> makeFriendMap(List<List<String>> friends){
        HashMap<String,String[]> friendMap = new HashMap<>();
        for(List<String> friend: friends){
            if(friendMap.containsKey(friend.get(0))){
                String[] newArray = arrAdd(friendMap.get(friend.get(0)),friend.get(1));
                friendMap.put(friend.get(0),newArray);
            }else{
                String[] newArray = new String[1];
                newArray[0] = friend.get(1);
                friendMap.put(friend.get(0),newArray);
            }

            if(friendMap.containsKey(friend.get(1))){
                String[] newArray = arrAdd(friendMap.get(friend.get(1)),friend.get(0));
                friendMap.put(friend.get(1),newArray);
            }else{
                String[] newArray = new String[1];
                newArray[0] = friend.get(0);
                friendMap.put(friend.get(1),newArray);
            }
        }
        return friendMap;
    }

    public static HashMap<String,Integer> addVisitorScore(List<String> visitors,HashMap<String,Integer> friendScore){
        for(String visitor:visitors){
            if(friendScore.containsKey(visitor)){
                friendScore.put(visitor,friendScore.get(visitor) + 1);
            }
            else{
                friendScore.put(visitor,1);
            }
        }
        return friendScore;
    }

    public static HashMap<String,Integer> makeFriendScoreFriendMap(String user,HashMap<String,String[]> friendMap){
        HashMap<String,Integer> friendScore = new HashMap<>();
        String[] userFriends = friendMap.get(user);
        if(userFriends == null){
            return friendScore;
        }
        for(String friend: friendMap.keySet()){
            friendScore.put(friend,0);
            if(!friend.equals(user)){
                for(String otherFriend:friendMap.get(friend)){
                    for(String userFriend:userFriends){
                        if(otherFriend.equals(userFriend)){
                            friendScore.put(friend, friendScore.get(friend) + 10);
                        }
                    }
                }
            }
        }
        return friendScore;
    }


    public static List<String> sortScore(HashMap<String,Integer> friendScore,String[] userFriendArr) {
        List<String> result = new ArrayList<>();
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(friendScore.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int i = 0;
        if (userFriendArr != null) {
            List<String> userFriendList = new ArrayList<>(Arrays.asList(userFriendArr));
            for (Map.Entry<String, Integer> entry : entries) {
                if ((i > 5) | entry.getValue() < 1) {
                    return result;
                }
                if (!userFriendList.contains(entry.getKey())) {
                    result.add(entry.getKey());
                    i++;
                }

            }
        } else {
            for (Map.Entry<String, Integer> entry : entries) {
                if ((i > 5) | entry.getValue() < 1) {
                    return result;
                }
                result.add(entry.getKey());
                i++;
            }
        }
        return result;
    }
}
