package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> all = new HashSet<>();
        Set<String> friendSet = new HashSet<>();
        List<String> recommendList = new ArrayList<>();
        Map<String, Integer> recommend = new HashMap<>();
        for(int i = 0; i < friends.size(); i++){
            List<String> tmp;
            tmp = friends.get(i);
            if(tmp.contains("mrko")){
                friendSet.add(tmp.get(0));
                friendSet.add(tmp.get(1));
            }
            all.add(tmp.get(0));
            all.add(tmp.get(1));
        }
        for(int i = 0; i < visitors.size(); i++) {
            all.add(visitors.get(i));
        }

        all.remove("mrko");
        friendSet.remove("mrko");

        List<String> friendList = new ArrayList<>(friendSet);
        List<String> allList = new ArrayList<>(all);
        Collections.sort(allList);
        for(int i = 0; i < allList.size(); i++){
            String tmp = allList.get(i);
            if(friendList.contains(tmp)){
                continue;
            }
            recommendList.add(tmp);
//            recommend.put(tmp, 0);
        }

        for(int i = 0; i < recommendList.size(); i++){
            int score = 0;
            String name = recommendList.get(i);
            for(int j = 0; j < friends.size(); j++){
                List<String> tmp = friends.get(j);
                if(tmp.contains(name)){
                    for(int k = 0; k < tmp.size(); k++) {
                        if(friendList.contains(tmp.get(k))){
                            score += 10;
                        }
                    }
                }
            }
            recommend.put(name, score);
        }

        List<String> keySetList = new ArrayList<>(recommend.keySet());
        Collections.sort(keySetList, (o1, o2) -> (recommend.get(o2).compareTo(recommend.get(o1))));

        Iterator<String> keys = recommend.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            answer.add(key);
        }

        return answer;
    }
}
