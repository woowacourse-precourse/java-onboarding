package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    //user와 friends된 친구의 리스트 메소드
    public static List<String> checkFriends(String user, List<List<String>> friends){
        List<String> friendsList = new ArrayList<>();
        String friendsName1 = "";
        String friendsName2 = "";

        for(int i =0; i< friends.size();i++){
            friendsName1 = friends.get(i).get(1);
            friendsName2 = friends.get(i).get(0);
            if(friendsName1.equals(user)){
                friendsList.add(friendsName2);
            }else if (friendsName2.equals(user)){
                friendsList.add(friendsName1);
            }

        }
        return friendsList;

    }
    //checkFriends메소드를 이용해 친구의 친구의 리스트 메소드
    public static List<String> checkSecondFriends(List<String> friendsList, List<List<String>> friends){
        List<String> secondFriendList = new ArrayList<>();
        for(int i =0; i < friendsList.size(); i++ ){
            List<String> list =  checkFriends(friendsList.get(i), friends);
            secondFriendList.addAll(list);
        }

        return secondFriendList;
    }

    //중복을 제거한 친구의 친구리스트와 방문자 리스트를 Map<people, score>로 정리한 메소드
    public static Map<String, Integer> scoreEachFriendsVisotors(List<String> secondlist, List<String> duplicateVisitors){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i< secondlist.size();i++){
            String key = secondlist.get(i);
            if(hashMap.containsKey(key)){
                hashMap.replace(key,hashMap.get(key) + 10 );
            }else {
                hashMap.put(key, 10);
            }
        }
        for(int i = 0; i< duplicateVisitors.size();i++){
            String key = duplicateVisitors.get(i);
            if(hashMap.containsKey(key)){
                hashMap.replace(key,hashMap.get(key) + 1 );

            }else {
                hashMap.put(key, 1);
            }
        }return hashMap;
    }



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> firstFriendList = checkFriends(user, friends);
        List<String> secondFriendList = checkSecondFriends(firstFriendList, friends);


        HashMap<String, Integer> lastMap = (HashMap<String, Integer>) scoreEachFriendsVisotors(secondFriendList, visitors);

        lastMap.remove(user);
        for(int i=0; i<firstFriendList.size(); ++i)
            lastMap.remove(firstFriendList.get(i));

        return lastMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());

    }
}
