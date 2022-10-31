package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * user에게 추천할 수 있는 사람들을 모아 map으로 반환하는 함수
     */
    private static Map<String,Integer> recommendationFriendsMap(String user, List<List<String>> friends){
        List<String> userFriendList = userFriends(user, friends);
        Map<String, Integer> friendsMap = listToMap(friends);
        return removeKnown(friendsMap,userFriendList,user);
    }

    /**
     * user의 친구들을 반환하는 함수
     */
    private static List<String> userFriends(String user, List<List<String>> friends){
        List<String> userFriendList = new ArrayList<>();
        for (int i=0;i<friends.size();i++){
            userFriendList = isUserFriend(user,friends.get(i),userFriendList);
        }
        return userFriendList;
    }

    /**
     * user의 친구를 찾아주는 함수
     */
    private static List<String> isUserFriend(String user, List<String> friend,List<String> userFriendList){
        if (friend.contains(user)){
            int friendIndex = (friend.indexOf(user) + 1)%2;
            userFriendList.add(friend.get(friendIndex));
        }
        return userFriendList;
    }

    /**
     * friends의 사람들을 Map에 저장하는 함수
     */
    private static Map<String,Integer> listToMap(List<List<String>> friends){
        Map<String, Integer> friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            friendsMap.put(friend.get(0),0);
            friendsMap.put(friend.get(1),0);
        }
        return friendsMap;
    }

    /**
     * user의 친구와 user friendsMap에서 제거
     */
    private static Map<String,Integer> removeKnown(Map<String,Integer> friendsMap, List<String> userFriendList, String user){
        friendsMap.remove(user);
        for (String userFriend : userFriendList) {
            friendsMap.remove(userFriend);
        }
        return friendsMap;
    }

    /**
     * user의 친구와 친구인지 확인하는 함수
     */
    private static boolean isFriend(String target, String userFriend,List<List<String>> friends){
        for (List<String> friend : friends) {
            if (friend.contains(target) && friend.contains(userFriend)) return true;
        }
        return false;
    }

    /**
     * user와 함께 아는 친구 수를 구하는 함수
     */
    private static int countFriend(String target,List<String> userFriendList,List<List<String>> friends){
        int count = 0;
        for (String userFriend : userFriendList) {
            if(isFriend(target,userFriend,friends)) count++;
        }
        return count;
    }

    /**
     * 사용자와 함께 아는 친구의 수 * 10점 주는 함수
     */
    private static Map<String,Integer> addTenPoint(Map<String,Integer> friendsMap,List<String> userFriendList,List<List<String>> friends){
        for (String target : friendsMap.keySet()) {
            friendsMap.replace(target,countFriend(target,userFriendList,friends)*10);
        }
        return friendsMap;
    }

    /**
     * visitors에게 1점 주는 함수
     */
    private static Map<String,Integer> addOnePoint(Map<String,Integer> friendsMap,List<String> userFriendList,List<String> visitors){
        for (String visitor : visitors) {
            if(!friendsMap.containsKey(visitor) && !userFriendList.contains(visitor)) friendsMap.put(visitor,1);
            else friendsMap.replace(visitor,friendsMap.get(visitor) + 1);
        }
        return friendsMap;
    }

}
