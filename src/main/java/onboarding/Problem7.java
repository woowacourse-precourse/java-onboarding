package onboarding;

import java.util.Collections;
import java.util.*;
class Friend implements Comparable<Friend>{
    public String name;
    public int score;

    public Friend(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Friend o){
        if(this.score==o.score) return name.compareTo(o.name);
        return o.score-this.score;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        // 친구 추천 후보 리스트 Array
        ArrayList<Friend> candidateFriend = new ArrayList<>();
        // 친구 관계 점수 HashMap
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

        // 추천 친구 후보 리스트
        for(String tmp : friendsScore.keySet()){
            getCandidateFriend(tmp,friendsScore,candidateFriend);
        }

        Collections.sort(candidateFriend);
        makeAnswer(answer,candidateFriend);

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

    public static void getCandidateFriend(String tmp, HashMap<String,Integer> friendsScore, ArrayList<Friend> candidateFriend){
        int score = friendsScore.get(tmp);
        if(score>0)
            candidateFriend.add(new Friend(tmp,score));
    }

    public static void makeAnswer(ArrayList<String> answer,ArrayList<Friend> candidateFriend){

        int count=0;
        for(Friend x : candidateFriend){
            answer.add(x.name);
            count++;
            if(count>5) break;
        }
    }
}
