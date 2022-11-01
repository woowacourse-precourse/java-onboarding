package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        Map<String, Integer> pointMap = new HashMap<String, Integer>();
        List<String> userFriendsList = new ArrayList<String>();

        for (int i=0; i<friends.size(); i++) {
            int index = friends.get(i).indexOf(user);
            if (friends.get(i).contains(user)) {
                userFriendsList.add(friends.get(i).get(1-index));
            }
        }

        for (int i=0; i<friends.size(); i++) {
            String[] tmpName = {friends.get(i).get(0), friends.get(i).get(1)};
            if (tmpName[0].equals(user) || tmpName[1].equals(user)) continue;
            for (int j=0; j<2; j++) {
                if (userFriendsList.contains(tmpName[j]))
                    pointMap.put(tmpName[1-j], pointMap.getOrDefault(tmpName[1-j], 0) + 10);
            }
        }

        for (int i=0; i<visitors.size(); i++) {
            String visitUser = visitors.get(i);
            if (!pointMap.containsKey(visitUser))
                pointMap.put(visitUser, pointMap.getOrDefault(visitUser, 0) + 1);
        }

        for (int i=0; i<userFriendsList.size(); i++) {
            if (pointMap.containsKey(userFriendsList.get(i)))
                pointMap.remove(userFriendsList.get(i));
        }

        List<Map.Entry<String, Integer>> sortList = new ArrayList<Map.Entry<String, Integer>>(pointMap.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int sol= o2.getValue().compareTo(o1.getValue());
                return sol == 0 ? o1.getKey().compareTo(o2.getKey()) : sol;
            }
        });

        int index = 0;
        for (Map.Entry<String, Integer> ent : sortList) {
            if (index == 5)
                break;
            if (ent.getValue() != 0)
                answer.add(ent.getKey());
            index += 1;
        }

        return answer;
    }
}
