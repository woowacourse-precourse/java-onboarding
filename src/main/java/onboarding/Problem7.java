package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Set<String>> relation = new HashMap<>();
        Set<String> set = Collections.emptySet();

        for(List<String> person : friends){
            if (!relation.containsKey(person.get(0))){
                set = new HashSet<>();
                set.add(person.get(1));
                relation.put(person.get(0), set);
            }
            if(relation.containsKey(person.get(0))){
                relation.get(person.get(0)).add(person.get(1));
            }
            if (!relation.containsKey(person.get(1))){
                set = new HashSet<>();
                set.add(person.get(0));
                relation.put(person.get(1), set);
            }
            if(relation.containsKey(person.get(1))){
                relation.get(person.get(1)).add(person.get(0));
            }
            
        }
        
        HashMap<String, Integer> score = new HashMap<>();
        
        if(relation.containsKey(user)){
            for(String usersFriend : relation.get(user)){
                for(String usersFriendDouble : relation.get(usersFriend)){
                    if(!relation.get(user).contains(usersFriendDouble) && !usersFriendDouble.equals(user)){
                        if(!score.containsKey(usersFriendDouble)){
                            score.put(usersFriendDouble, 10);
                        }
                        if(score.containsKey(usersFriendDouble)){
                            score.put(usersFriendDouble, score.get(usersFriendDouble)+10);
                        }
                    }
                }
            }
        }

        for (String visit : visitors){
            if(!relation.containsKey(user)){
                if(!score.containsKey(visit)){
                    score.put(visit, 1);
                }
                if(score.containsKey(visit)){
                    score.put(visit, score.get(visit)+1);
                }
            }
            if(!relation.get(user).contains(visit)){
                if(!score.containsKey(visit)){
                    score.put(visit, 1);
                }
                if(score.containsKey(visit)){
                    score.put(visit, score.get(visit)+1);
                }
            }
        }
        
        HashMap<Integer, List<String>> scoreFriend = new HashMap<>();



        for(String person : score.keySet()){
            if(!scoreFriend.containsKey(score.get(person))){
                List<String> personList = new ArrayList<>();
                personList.add(person);
                scoreFriend.put(score.get(person), personList);
            }
            else if(scoreFriend.containsKey(score.get(person))){
                List<String> personList = scoreFriend.get(score.get(person));
                personList.add(person);
                scoreFriend.put(score.get(person), personList);
            }
        }
        
        List<Integer> pointSet = new ArrayList<>(scoreFriend.keySet());
        List<String> result = new ArrayList<>();
        Collections.sort(pointSet);
        Collections.reverse(pointSet);

        for(Integer point : pointSet){
            List<String> samePoint = new ArrayList<>();
            for(String friend : scoreFriend.get(point)){
                samePoint.add(friend);
            }
            Collections.sort(samePoint);
            
            for(int i=0; i< samePoint.size() && result.size()<5; i++){
                result.add(samePoint.get(i));
            }
        }
        
    return result;

    }
}
