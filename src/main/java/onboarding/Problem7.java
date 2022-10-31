package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static final int knowFriend = 10;
    static final int visited = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static ArrayList<String> findFriends(String user, List<List<String>> friends){
        ArrayList<String> userFriends = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++){
            String nameA = friends.get(i).get(0);
            String nameB = friends.get(i).get(1);

            if(nameA.equals(user)){
                userFriends.add(nameB);
            }
            if(nameB.equals(user)){
                userFriends.add(nameA);
            }
        }
        return userFriends;
    }
    public static HashMap<String,Integer> CalculateFriend(String user, List<List<String>> friends, ArrayList<String> userFriends){
        HashMap<String,Integer> candidate = new HashMap<>();

        for(int i = 0; i < friends.size(); i++){
            for(int j = 0; j < userFriends.size(); j++){
                String nameA = friends.get(i).get(0);
                String nameB = friends.get(i).get(1);
                String userFriend = userFriends.get(j);
                if(nameA.equals(userFriend) && !nameB.equals(user)){
                    if(candidate.containsKey(nameB)){
                        int value = candidate.get(nameB);
                        candidate.replace(nameB,value,value + knowFriend);
                    }else{
                        candidate.put(nameB,knowFriend);
                    }
                }
                if(nameB.equals(userFriend) && !nameA.equals(user)){
                    if(candidate.containsKey(nameA)){
                        int value = candidate.get(nameA);
                        candidate.replace(nameA,value,value+knowFriend);
                    }else{
                        candidate.put(nameA,knowFriend);
                    }
                }
            }
        }
        return candidate;
    }

    public static HashMap<String,Integer> CalculateVisitor(ArrayList<String> userFriends, List<String> visitors, HashMap<String,Integer> candidate){
        for(int i = 0; i < visitors.size(); i++){
            int countNotFriend = 0;
            for(int j = 0; j < userFriends.size(); j++){
                String visitor = visitors.get(i);
                String friend = userFriends.get(j);
                if(!visitor.equals(friend)){
                    countNotFriend++;
                }
                if(countNotFriend == userFriends.size()){
                    if(candidate.containsKey(visitor)){
                        int value = candidate.get(visitor);
                        candidate.replace(visitor,value,value+visited);
                    }else{
                        candidate.put(visitor,visited);
                    }
                }
            }
        }
        return candidate;
    }

    private static List<String> sortByScore(HashMap<String,Integer> candidate){
        List<String> answer = new ArrayList<>(candidate.keySet());
        HashMap<String,Integer> finalCandidate = candidate;
        Collections.sort(answer,(value1,value2) -> (finalCandidate.get(value2).compareTo(finalCandidate.get(value1))));
        return answer;
    }

}
