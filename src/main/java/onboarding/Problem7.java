package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> GET_ALREADY_KNOWN(String user, List<List<String>> friends){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).contains(user)){
                result.add(friends.get(i).get(0));
            }
        }
        return result;
    }
    public static HashMap<String, List<String>> GET_FRIENDS_KNOWN(String user, List<String> Already_Known, List<List<String>> friends){
        HashMap<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < friends.size(); i++){
            for(int j = 0; j < Already_Known.size(); j++){
                if(friends.get(i).contains(Already_Known.get(j)) && !friends.get(i).contains(user)){
                    List<String> tmp = new ArrayList<>();
                    if(result.containsKey(Already_Known.get(j))){
                        tmp = result.get(Already_Known.get(j));
                    }
                    if(friends.get(i).get(0) == Already_Known.get(j)){
                        tmp.add(friends.get(i).get(1));
                    } else {
                        tmp.add(friends.get(i).get(0));
                    }
                    result.put(Already_Known.get(j), tmp);
                }
            }
        }
        return result;
    }

    public static HashMap<String, Integer> GET_SCORE(List<String> user_friends, HashMap<String, List<String>>friends_known, List<String> visitors){
        HashMap<String, Integer> result = new HashMap<>();
        for(String key: friends_known.keySet()){
            List<String> tmp = friends_known.get(key);
            for(int i = 0; i < tmp.size(); i++){
                result.put(tmp.get(i), 0);
            }
        }
        for(int i = 0; i < visitors.size(); i++){
            String tmp = visitors.get(i);
            if(!user_friends.contains(tmp)){
                int tmp_score = 0;
                if(result.containsKey(tmp)){
                    tmp_score = result.get(tmp);
                }
                tmp_score += 1;
                result.put(tmp, tmp_score);
            } else {
                for(String name: friends_known.get(tmp)){
                    int tmp_score = 0;
                    if(result.containsKey(name)){
                        tmp_score = result.get(name);
                    }
                    tmp_score += 10;

                    result.put(name, tmp_score);
                }
            }
        }


        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        List<String> user_friends = GET_ALREADY_KNOWN(user, friends);
        HashMap<String, List<String>> friends_known = GET_FRIENDS_KNOWN(user, user_friends, friends);
        HashMap<String, Integer>score = GET_SCORE(user_friends, friends_known, visitors);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue() == o1.getValue()){
                     return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }

            }
        });
        System.out.println(entryList);
        for(int i = 0; i < entryList.size(); i++){
            answer.add(entryList.get(i).getKey());
        }
        System.out.println(answer);
        return answer;
    }
}
