package onboarding;

import java.util.*;

public class Problem7 {
    private static void addScore(HashMap<String,Integer> score, String name, int point){
        int currentScore = score.get(name);
        currentScore += point;
        score.replace(name,currentScore);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> notFriend = new HashSet<>();
        HashSet<String> friend = new HashSet<>();
        HashMap<String,Integer> score = new HashMap<>();

        //set friend / not friend list
        for(int i = 0; i < friends.size(); i++){
            String firstPerson = friends.get(i).get(0);
            String secondPerson = friends.get(i).get(1);

            //both are not user
            if(!friends.get(i).contains(user)){
                notFriend.add(firstPerson);
                notFriend.add(secondPerson);
            } else {
                //if first is user
                if(firstPerson.equals(user)){
                    friend.add(secondPerson);
                    notFriend.remove(secondPerson);
                } else {
                    friend.add(firstPerson);
                    notFriend.remove(firstPerson);
                }
            }
        }

        //initialize score
        for(String name: notFriend){
            if(name != user){
                score.put(name,0);
            }
        }

        //add 1 if visited
        for(String name: visitors){
            if(!friend.contains(name)){
                if(score.get(name) == null){
                    score.put(name,1);
                } else {
                    addScore(score, name,1);
                }
            }
        }

        //add each 10 if friend's friend
        for(int j = 0; j < friends.size(); j++){
            String firstPerson = friends.get(j).get(0);
            String secondPerson = friends.get(j).get(1);

            //if first is not friend but second is friend
            if(notFriend.contains(firstPerson) && friend.contains(secondPerson)) {
                addScore(score, firstPerson,10);
            } else if (notFriend.contains(secondPerson) && friend.contains(firstPerson)){ //if first is friend and second is not friend
                addScore(score, secondPerson,10);
            }
        }

        //sort by score
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(((o1, o2) -> score.get(o2.getKey()) - score.get(o1.getKey())));

        return answer;
    }
}
