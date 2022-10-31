package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    static Map<String, Integer> peopleMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        makePeopleMap(user, friends, visitors);

        return answer;
    }

    public static void makePeopleMap(String user, List<List<String>> friends, List<String> visitors){
        String firstFriend;
        String secondFriend;
        for (int index=0; index<friends.size(); index++){
            firstFriend = friends.get(index).get(0);
            secondFriend = friends.get(index).get(1);

            if(!user.equals(firstFriend)){
                peopleMap.put(firstFriend, 0);
            }

            if(!user.equals(secondFriend)){
                peopleMap.put(secondFriend, 0);
            }
        }

        String visitor;

        for (int index=0; index<visitors.size(); index++){
            visitor = visitors.get(index);

            if(!user.equals(visitor)){
                peopleMap.put(visitor, 0);
            }
        }
    }
}
