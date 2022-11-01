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
    
        ArrayList<String> sortKeys = new ArrayList<String>(scoreList.keySet());
    
        Collections.sort(sortKeys);
        Collections.reverse(sortKeys);
        
        HashMap<String, Integer> sortedScore = new HashMap<>();
        
        for(String name : sortKeys){
            sortedScore.put(name, scoreList.get(name));
        }
        
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(sortedScore.entrySet());
        
        Collections.sort(
                list,
                new Comparator<Map.Entry<String, Integer> >() {
                    public int compare(
                            Map.Entry<String, Integer> object1,
                            Map.Entry<String, Integer> object2)
                    {
                        return (object1.getValue())
                                .compareTo(object2.getValue());
                    }
                });
        HashMap<String, Integer> result
                = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }
        
        System.out.println(friendList);
        
        System.out.println(scoreList);
    
        System.out.println(result);
        
        List<String> answer = new ArrayList<>();
        
        for(Map.Entry<String, Integer> m : result.entrySet()){
            answer.add(m.getKey());
        }
        
        Collections.reverse(answer);
        
        return answer;
    }
}
