package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,Integer> userScores = initFriends(user,friends);
        //add visitor count
        for (String s : visitors) {
            if (userScores.get(s) == null) {
                userScores.put(s,1);
            }
            else if (userScores.get(s) != -1) {
                userScores.put(s,userScores.get(s)+1);
            }
        }

        List<String> answer = new ArrayList<>();
        //hashmap to arraylist > sort
        List<Map.Entry<String, Integer>> list = new LinkedList<>(userScores.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.forEach((k, v) -> {
            if (answer.size() == 5 || v == -1) return;
            answer.add(k);
        });

        return answer;
    }

    public static HashMap<String,Integer> initFriends(String user, List<List<String>> friends) {
        HashMap<String,Integer> userScores = new HashMap<>();
        for (List i : friends) {
            if (i.get(0)==user) {
                if (userScores.get(i.get(1))!=null) {
                    userScores.put(i.get(1).toString(),-1);
                }
            }
            if (i.get(1)==user) {
                if (userScores.get(i.get(0))!=null) {
                    userScores.put(i.get(0).toString(),-1);
                }
            }
            if (i.get(0)!=user && i.get(1)!=user) {
                if (userScores.get(i.get(0))==null) {
                    userScores.put(i.get(0).toString(),0);
                }
                if (userScores.get(i.get(1))==null) {
                    userScores.put(i.get(1).toString(),0);
                }
                if (userScores.get(i.get(0))!=null) {
                    userScores.put(i.get(0).toString(),
                            userScores.get(i.get(0))+10);
                }
                if (userScores.get(i.get(1))!=null) {
                    userScores.put(i.get(1).toString(),
                            userScores.get(i.get(1))+10);
                }
            }
        }
        return userScores;
    }
}
