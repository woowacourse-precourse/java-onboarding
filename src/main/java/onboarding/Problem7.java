package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> friendsList = new ArrayList<>();
        HashMap<String,Integer> scoreMap = new HashMap<>();
        int score = 0;
        setFriendsList(user, friends, friendsList);
        setFriendOfFriendsList(user, friends, friendsList, scoreMap, score);
        giveOnePoint(visitors, friendsList, scoreMap, score);
        List<String> keyList = new ArrayList<>(scoreMap.keySet());
        List<Integer> valueList = new ArrayList<>(scoreMap.values());
        List<Item> items = new ArrayList<>();
        setListSort(answer, keyList, valueList, items);
        return answer;
    }

    private static void setFriendsList(String user, List<List<String>> friends, ArrayList<String> friendsList) {
        for(int i = 0; i< friends.size(); i++){
            for(int j=0; j<2; j++){
                if(friends.get(i).get(j) == user){
                    friendsList.add(friends.get(i).get(1-j));
                }
            }
        }
    }
    private static void setFriendOfFriendsList(String user, List<List<String>> friends, ArrayList<String> friendsList, HashMap<String, Integer> scoreMap, int score) {
        for(int i = 0; i< friends.size(); i++){
            for(int j=0; j<2; j++){
                if(friendsList.contains(friends.get(i).get(1-j))){
                    if(friends.get(i).get(j) != user){
                        //score세팅
                        setScore1(scoreMap, friends.get(i), j, 10);
                    }
                }
            }
        }
    }
    private static void setScore1(HashMap<String, Integer> scoreMap, List<String> friends, int j, int x) {
        int score;
        if(scoreMap.containsKey(friends.get(j))){
            score = scoreMap.get(friends.get(j)) + x;
            scoreMap.put(friends.get(j), score);
        }
        else{
            score = x;
            scoreMap.put(friends.get(j), score);
        }
    }
}
