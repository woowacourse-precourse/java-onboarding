package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Integer> fillMap(List<Map.Entry<String, Integer>> entryList){ //entryList를 Map형태로 변환시켜줌
        Map<String, Integer> keyFriend = new LinkedHashMap<>(); //정렬 결과를 보존하기 위해서 linkedhashmap사용
        for (Map.Entry<String,Integer> entry : entryList){
            keyFriend.put(entry.getKey(),entry.getValue());
        }
        return keyFriend;
    }
    private static List<Map.Entry<String,Integer>> entryReturn(Map<String,Integer> friendScore){
        return new LinkedList<>(friendScore.entrySet());
    }
    private static Map<String,Integer> sortBy(Map<String,Integer> friendScore){
        List<Map.Entry<String,Integer>> entryList = entryReturn(friendScore);
        entryList.sort(Map.Entry.comparingByKey()); //key로 한번
        friendScore=fillMap(entryList);
        entryList = entryReturn(friendScore);
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); //value로 한번
        return fillMap(entryList);
    }
    private static Map<String,Integer> plusVisit(Map<String,Integer> friendScore,List<String> visitors){

        for (String visiter: visitors){
            if (friendScore.containsKey(visiter)){ //친구관계에 존재한 user라면
                friendScore.replace(visiter,friendScore.get(visiter)+1);
            }else{
                friendScore.put(visiter,1);
            }
        }
        return friendScore;
    }
    private static Map<String,Integer> plusFriend(Map<String,List<String>> friendList,String user){
        Map<String,Integer> friendScore = new HashMap<>();
        Map<String,List<String>> newFriendList = new HashMap<>(friendList); //여기서 삭제하면 heap영역의 friendList에도 영향이 가기 때문
        List<String> userFriends=newFriendList.get(user);
        newFriendList.remove(user);
        Iterator<String> keys = newFriendList.keySet().iterator();
        for (String friend : newFriendList.keySet()) { //깊이가 너무 깊어지기 때문에 scorelist 초기화 시켜놓기
            friendScore.put(friend,0);
        }
        while (keys.hasNext()){
            String key = keys.next();
            for (String userFriend : userFriends) {
                if(newFriendList.get(key).indexOf(userFriend)!=-1){ //user을 제외한 친구리스트에서 user와 동일한 친구가 존재한다면 +10
                    friendScore.replace(key,friendScore.get(key)+10);
                }
            }
        }
        return friendScore;
    }
    private static Map<String,List<String>> friendmake(List<List<String>> friends){
        Map<String,List<String>> friendList = new HashMap<>(); //TreeMap과 HashMap중 고민했음 하지만 마지막에만 정렬해주면 되기에 전체적인 시간을 고려해 HashMap
        for (int i = 0 ;i<friends.size();i++){
            final String name1 = friends.get(i).get(0);
            final String name2 = friends.get(i).get(1);
            if (friendList.containsKey(name1)) { //name1의 친구리스트가 형성되어있는 경우
                friendList.get(name1).add(name2);
            }else{
                List<String> templist = new ArrayList<>(); //되어있지 않다면 name2를 넣은 arrayList형성후 삽입
                templist.add(name2);
                friendList.put(name1,templist);
            }
            if (friendList.containsKey(name2)) { //동일
                friendList.get(name2).add(name1);
            }else{
                List<String> templist = new ArrayList<>();
                templist.add(name1);
                friendList.put(name2,templist);
            }
        }
        return friendList;
    }
    private static void minusUserFriend(Map<String,Integer> friendScore, Map<String,List<String>> friendMap, String user){
        List<String> userFriends=friendMap.remove(user);
        for (String userFriend: userFriends){
            friendScore.remove(userFriend);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,List<String>> friendMap =friendmake(friends);
        Map<String,Integer> friendScore = plusVisit(plusFriend(friendMap,user),visitors);
        minusUserFriend(friendScore, friendMap, user);//userfriend는 제외
        friendScore = sortBy(friendScore);
        return new ArrayList<>(friendScore.keySet());
    }
}
