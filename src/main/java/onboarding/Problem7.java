package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String,Integer> foaf = new HashMap<>();
    static Set<String> userfriends = new HashSet<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Set<String> friendsWithUser(List<List<String>> friends,String user) {
        Set<String> userfriends = new HashSet<>();
        for(List<String> strings : friends) {
            if(strings.get(0).equals(user)) {
                userfriends.add(user + strings.get(1));
            }
            else if(strings.get(1).equals(user)) {
                userfriends.add(strings.get(0) + user);
            }
        }
        return userfriends;
    }

    public static void insertMapValue(String strings,Integer value,String user) {
        if(foaf.get(strings) == null) {
            if(!userfriends.contains(strings + user)) { foaf.put(strings,value);}
        }
        else {
            int v = value + foaf.get(strings);
            foaf.put(strings,v);
        }
    }

}
