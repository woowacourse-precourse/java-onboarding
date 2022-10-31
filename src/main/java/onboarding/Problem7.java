package onboarding;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Problem7 problem = new Problem7();
        HashMap<String, Integer> listpeople;
        ArrayList<String> userfriendslist;

        listpeople = problem.extractPeople(user, friends, visitors);
        userfriendslist = problem.extractUserFriend(user, friends);

        return answer;
    }

    public HashMap<String, Integer> extractPeople(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> result = new HashMap<>();

        for(List e : friends) {
            for(Object s : e) {
                result.put((String) s, 0);
            }
        }

        for(String e : visitors) {
            result.put(e, 0);
        }

        result.remove(user);

        return result;
    }

    public ArrayList<String> extractUserFriend(String user, List<List<String>> friends) {
        HashSet<String> resulthash = new HashSet<>();
        ArrayList<String> resultarray;

        for(List e : friends) {
            if(e.contains(user)) {
                resulthash.add((String) e.get(0));
                resulthash.add((String) e.get(1));
            }
        }

        resulthash.remove(user);
        resultarray = new ArrayList<>(resulthash);

        return resultarray;
    }
}
