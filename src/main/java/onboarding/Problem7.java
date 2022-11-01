package onboarding;

import java.util.Collections;
import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> friendsScore = new HashMap<>();

        // 친구 관계를 표시할 HashMap
        HashMap<String, ArrayList<String>> friendsMap = new HashMap<>();

        // 친구 관계 만들기
        for(List<String> tmp : friends){
            makeFriendsMap(tmp, friendsMap);
        }

        // 친구들의 Score 초기화
        for(String friend : friendsMap.keySet()){
            makeFriendsScore(friend,user,friendsScore);
        }

        // 함께 아는 친구 점수 추가
        for(String friend : friendsScore.keySet()){
            if(isUserFriend(user,friend,friendsMap)) continue;
            addSameFriendScore(user,friend,friendsMap,friendsScore);
        }

        // 방문한 친구 점수 추가
        for(String visitor : visitors){
            if(isUserFriend(user,visitor,friendsMap)) continue;
            addVisitFriendScore(visitor,friendsScore);
        }

        

        return answer;
    }

    public static void makeFriendsMap(List<String> tmp, HashMap<String, ArrayList<String>> friendsMap){

        String friend1 = tmp.get(0);
        String friend2 = tmp.get(1);

        if(friendsMap.containsKey(friend1)){
            friendsMap.get(friend1).add(friend2);
        }
        else{
            friendsMap.put(friend1, new ArrayList<>(Arrays.asList(friend2)));
        }

        if (friendsMap.containsKey(friend2)) {
            friendsMap.get(friend2).add(friend1);
        }
        else{
            friendsMap.put(friend2, new ArrayList<>(Arrays.asList(friend1)));
        }

    }

    public static void makeFriendsScore(String friend, String user, HashMap<String, Integer> friendsScore){
        if(friend.equals(user)) return;
        friendsScore.put(friend,0);
    }

    public static boolean isUserFriend(String user, String friend, HashMap<String, ArrayList<String>> friendsMap){
        for(String tmp : friendsMap.get(user)){
            if(tmp.equals(friend)) return true;
        }
        return false;
    }

    public static void addSameFriendScore(String user, String friend, HashMap<String, ArrayList<String>>friendsMap, HashMap<String,Integer> friendsScore){
        // 한 친구의 점수 매기기

        int score = 0;
        for(String tmp : friendsMap.get(user)){
            if(friendsMap.get(tmp).contains(friend)) score+=10;
        }
        friendsScore.put(friend, score);
    }

    public static void addVisitFriendScore(String visitor, HashMap<String,Integer> friendsScore){
        friendsScore.put(visitor, friendsScore.getOrDefault(visitor,0)+1);
    }
}
