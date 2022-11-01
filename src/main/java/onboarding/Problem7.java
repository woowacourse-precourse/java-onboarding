package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> FriendScore = FriendScore(user,friends,visitors);
        PlusFriendscore(user,FriendScore,friends,visitors);
        List<String> answer=Sort(FriendScore);

        return answer;
    }
    public static HashMap<String,Integer> FriendScore(String user,List<List<String>> friends,List<String> visitors){
        HashMap<String, Integer> FriendScore = new HashMap<>();//친구 점수를 기록하는 HashMap 생성
        for(int i=0;i< friends.size();i++){
            FriendScore.put(friends.get(i).get(0),0);
            FriendScore.put(friends.get(i).get(1),0);
        }
        for(int i=0;i< visitors.size();i++){
            FriendScore.put(visitors.get(i),0);
        }
        FriendScore.remove(user);
        return FriendScore;

    }
    public static void PlusFriendscore(String user,HashMap<String,Integer> FriendScore,List<List<String>> friends,List<String> visitors){
        ArrayList<String> recommandlist = new ArrayList<>();//친구의 친구리스트
        ArrayList<String> Friendlist = new ArrayList<>();//친구리스트
        listupdate(user, friends, Friendlist);
        for(int index=0;index<Friendlist.size();index++){
            listupdate2(Friendlist.get(index),friends,recommandlist);
        }
        for(int i=0;i<recommandlist.size();i++){
            String name=recommandlist.get(i);
            if(Friendlist.contains(name)||name.equals(user)){
                continue;
            }
            int score=FriendScore.get(name);
            score+=10;
            FriendScore.put(name,score);
        }
        VisitorScore(FriendScore,visitors);
    }
    public static String FindFriend(String user,List<String> friends) {
        int index = friends.indexOf(user);
        if (index == 1) {
            return friends.get(0);
        } else {
            return friends.get(1);
        }
    }
    public static void listupdate(String user,List<List<String>> friends,ArrayList<String> list){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                String Friend = FindFriend(user, friends.get(i));
                if(!list.contains(Friend)){
                    list.add(Friend);}
            }}
    }
    public static void listupdate2(String user,List<List<String>> friends,ArrayList<String> list){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                String Friend = FindFriend(user, friends.get(i));
                    list.add(Friend);}
            }}

    public static void VisitorScore(HashMap<String,Integer> FriendScore,List<String> visitors){
    for(int i=0;i<visitors.size();i++){
        String name=visitors.get(i);
        int score = FriendScore.get(name);
        score+=1;
        FriendScore.put(name, score);
    }
    }
    public static List<String> Sort(HashMap<String,Integer> FriendScore){
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(FriendScore.entrySet());
        List<String> answer = new ArrayList<>();
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for(int i=0;i<3;i++){
            String name=list_entries.get(i).getKey();
            if(list_entries.get(i).getValue()<=0){
                break;
            }
            answer.add(name);
        }
        return answer;
    }
}

