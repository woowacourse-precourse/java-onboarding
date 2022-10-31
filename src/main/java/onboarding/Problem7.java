package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> result = userlist(friends,visitors);

        result = friendslist(user,friends,result);

        return result;
    }

    public static List<String> userlist (List<List<String>> friends, List<String> visitors) {
        List<String> userdata = new ArrayList<>();
        for(int i=0;i< friends.size();i++) {
            userdata.add(friends.get(i).get(0));
            userdata.add(friends.get(i).get(1));

        }
        for(int j=0;j< visitors.size();j++) {
            userdata.add(visitors.get(j));
        }
        return overlap(userdata);
    }
    public static List<String> friendslist (String user, List<List<String>> friends , List<String> list) {
        List<String> other = new ArrayList<>();
        for(int i=0;i<friends.size();i++) {
            if(friends.get(i).get(0).equals(user)||friends.get(i).get(1).equals(user)){
                other.add(friends.get(i).get(0));
                other.add(friends.get(i).get(1));
            }
        }
        other = overlap(other);

        for(int j=0;j<other.size();j++) {
            for(int k=0;k<list.size();k++) {
                if(other.get(j).equals(list.get(k)))
                    list.remove(k);
            }
        }
        return list;
    }
    public static List<String> overlap (List<String> list) {
        Set<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);

        return list;
    }
}
