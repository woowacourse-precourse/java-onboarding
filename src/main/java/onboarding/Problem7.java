package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> score = new HashMap<>();
        ArrayList<String> friend = new ArrayList<>();

        for (List<String> userFriends: friends){
            if (userFriends.contains(user)){
                for(String names: userFriends){
                    if(names.equals(user) == false){
                        for(List<String> friendFriends: friends){
                            if (friendFriends.contains(names)){
                                for(String name : friendFriends){
                                    if(name.equals(names) == false && name.equals(user) == false){
                                        if (friend.contains(name) == false){
                                            friend.add(names);
                                        }
                                        if(score.containsKey(name) == false){
                                            score.put(name, 10);
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
            if (score.containsKey(name)){
                score.replace(name,score.get(name) + 1);
            }
            else if(friend.contains(name) == false) {
                score.put(name, 1);
            }
        }

        ArrayList<String> sortKeys = new ArrayList<String>(score.keySet());

        Collections.sort(sortKeys);
        Collections.reverse(sortKeys);

        HashMap<String, Integer> sortedScore = new HashMap<>();

        for(String name : sortKeys){
            sortedScore.put(name, score.get(name));
        }

        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(sortedScore.entrySet());

        Collections.sort(
                list,
                new Comparator<Map.Entry<String, Integer> >() {
                    public int compare(
                            Map.Entry<String, Integer> itemA,
                            Map.Entry<String, Integer> itemB)
                    {
                        return (itemA.getValue())
                                .compareTo(itemB.getValue());
                    }
                });
        HashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> one : list) {
            result.put(one.getKey(), one.getValue());
        }


        List<String> answer = new ArrayList<>();

        for(Map.Entry<String, Integer> info : result.entrySet()){
            answer.add(info.getKey());
        }

        Collections.reverse(answer);
        return answer;
    }
}
