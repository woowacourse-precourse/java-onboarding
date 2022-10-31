package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    
        HashMap<String, Integer> scoreList = new HashMap<>();
        ArrayList<String> friendList = new ArrayList<>();
        
        for (List<String> userFriends: friends){
            if (userFriends.contains(user)){
                for(String names: userFriends){
                    if(names.equals(user) == false){
                        for(List<String> friendFriends: friends){
                            if (friendFriends.contains(names)){
                                for(String name : friendFriends){
                                    if(name.equals(names) == false && name.equals(user) == false){
                                        if (friendList.contains(name) == false){
                                            friendList.add(names);
                                        }
                                        if(scoreList.containsKey(name) == false){
                                            scoreList.put(name, 10);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(String name: visitors){
            if (scoreList.containsKey(name)){
                scoreList.replace(name,scoreList.get(name) + 1);
            }
            else if(friendList.contains(name) == false) {
                scoreList.put(name, 1);
            }
        }
        
        
        
        System.out.println(friendList);
        
        System.out.println(scoreList);
        
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
