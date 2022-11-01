package onboarding;

import java.text.CollationElementIterator;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendsMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for(int i = 0; i < friends.size(); i++) {
            String idA = friends.get(i).get(0);
            String idB = friends.get(i).get(1);
            if(friendsMap.get(idA) == null) {
                List<String> list = new ArrayList<>();
                list.add(idB);
                friendsMap.put(idA,list);
            } else {
                friendsMap.get(idA).add(idB);
            }
            if(friendsMap.get(idB) == null) {
                List<String> list = new ArrayList<>();
                list.add(idA);
                friendsMap.put(idB,list);
            } else {
                friendsMap.get(idB).add(idA);
            }
        }
        for(int i = 0; i < friendsMap.get(user).size(); i++) {
            String usersFriend = friendsMap.get(user).get(i);
            for(int j = 0; j < friendsMap.get(usersFriend).size(); j++) {
                String id = friendsMap.get(usersFriend).get(j);
                if(id == user) {
                    continue;
                } else {
                    if(scoreMap.get(id) == null) {
                        scoreMap.put(id, 10);
                    } else {
                        int curScore = scoreMap.get(id);
                        scoreMap.replace(id,curScore + 10);
                    }
                }
            }
        }

        for(int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if(friendsMap.get(user).contains(visitor)) {
                continue;
            } else {
                if(scoreMap.get(visitor) == null) {
                    scoreMap.put(visitor, 1);
                } else {
                    int curScore = scoreMap.get(visitor);
                    scoreMap.replace(visitor, curScore + 1);
                }
            }
        }
        List<String> keySetList = new ArrayList<>(scoreMap.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scoreMap.get(o2) - scoreMap.get(o1);
            }
        });
        for(int i = 0; i < keySetList.size() ; i++) {
            if(i == 5) {
                break;
            } else {
                answer.add(keySetList.get(i));
            }
        }
        return answer;
    }
}
