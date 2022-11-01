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
        
        
        
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
