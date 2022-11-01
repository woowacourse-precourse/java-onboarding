package onboarding;

import java.util.*;

public class Problem7 {
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

        return answer;
    }
}
