package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String,Integer> friendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0) == user){
                userFriends.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1) == user){
                userFriends.add(friends.get(i).get(0));
            }
        }

        for(List<String> friend : friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(user == friend1 || user == friend2) continue;
            if(userFriends.contains(friend1) && !userFriends.contains(friend2)){
                addScore(friend2,10);
            }
            else if(userFriends.contains(friend2) && !userFriends.contains(friend1)){
                addScore(friend1,10);
            }
        }

        for(String visitor : visitors){
            if(userFriends.contains(visitor)) continue;
            addScore(visitor,1);
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(friendScore.entrySet());

        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int cnt = 5;

        for(Map.Entry<String,Integer> entry : entryList){
            answer.add(entry.getKey());
            cnt --;
            if(cnt<=0){
                break;
            }
        }

        return answer;
    }

    public static void addScore(String name, int score){
        //System.out.println("friendscore"+friendScore.get(name));
        if(friendScore.containsKey(name)){
            score += friendScore.get(name);
        }
        friendScore.put(name,score);
    }
}
