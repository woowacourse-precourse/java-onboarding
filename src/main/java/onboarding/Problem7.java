package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> key;
        List<String> friendsOfUser = new ArrayList<String>();
        HashMap<String, Integer> recommend = new HashMap<String, Integer>();

        for(List<String> frd : friends){
            int userIdx = frd.indexOf(user);
            if(userIdx != -1){
                friendsOfUser.add(frd.get(1 - userIdx));
            }
        }

        for(List<String> frd: friends){
            if(frd.contains(user)) continue;

            for(String frdUser: friendsOfUser){
                int frdIdx = frd.indexOf(frdUser);
                if(frdIdx != -1){
                    String nearby = frd.get(1-frdIdx);

                    Integer prev = recommend.get(nearby);

                    if(prev == null){
                        prev = 0;
                    }

                    recommend.put(nearby,prev+10);
                }
            }
        }



        for(String visitor: visitors){
            if(friendsOfUser.contains(visitor) || user.equals(visitor)) continue;

            Integer prev = recommend.get(visitor);
            if(prev == null){
                prev = 0;
            }
            recommend.put(visitor, prev+1);
        }

        key = new ArrayList<String>(recommend.keySet());

        key.sort(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                int result = recommend.get(o2).compareTo(recommend.get(o1));
                if(result == 0){
                    result = o1.compareTo(o2);
                }
                return result;
            }
        });

        if(key.size() > 5){
            answer = new ArrayList<String>(key.subList(0, 5));
        }
        else{
            answer = new ArrayList<String>(key);
        }

        return answer;
    }
}
