package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        List<String> user_fr=new ArrayList<>();
        for(int i=0;i< friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                user_fr.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                user_fr.add(friends.get(i).get(0));
            }
        }
        for(int i=0;i< user_fr.size();i++){
            for(int j=0;j< friends.size();j++) {
                if(friends.get(j).get(0).equals(user)||friends.get(j).get(1).equals(user)){
                    continue;
                }
                else {
                    if (friends.get(j).get(0).equals(user_fr.get(i))) {
                        if (have_not(user_fr, friends.get(j).get(1))) {
                            map.put(friends.get(j).get(1), map.getOrDefault(friends.get(j).get(1), 0) + 10);
                        }
                    } else if (friends.get(i).get(1).equals(user_fr.get(i))) {
                        if (have_not(user_fr, friends.get(j).get(0))) {
                            map.put(friends.get(j).get(0), map.getOrDefault(friends.get(j).get(0), 0) + 10);
                        }
                    }
                }
            }
        }

        for(int i=0;i<visitors.size();i++){
            if(have_not(user_fr,visitors.get(i))) {
                map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0) + 1);
            }
        }


        return answer;
    }
    public static boolean have_not(List<String> list1,String str){
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).equals(str)){
                return false;
            }
        }
        return true;
    }
}
