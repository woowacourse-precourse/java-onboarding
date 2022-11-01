package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> friendRelation = new HashMap<>();
        Map<String, Integer> recommend = new HashMap<>();

        for (int i = 0 ; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            String First = friend.get(0);
            String Second = friend.get(1);
            if (First != user && Second != user) {
                recommend.put(First, 0);
                recommend.put(Second, 0);
            }


            if (friendRelation.containsKey(First)) {
                friendRelation.get(First).add(Second);
            } else {
                friendRelation.put(First, new ArrayList<>(List.of(Second)));
            }
            if (friendRelation.containsKey(Second)) {
                friendRelation.get(Second).add(First);
            } else {
                friendRelation.put(Second, new ArrayList<>(List.of(First)));
            }
        }

        List<String> nowFriend = friendRelation.get(user);
        for (int i = 0; i < nowFriend.size(); i++) {
            for (int j = 0; j < friendRelation.get(nowFriend.get(i)).size(); j++){
                String tmp = friendRelation.get(nowFriend.get(i)).get(j);
                if (recommend.containsKey(tmp)) {
                    recommend.put(tmp, recommend.get(tmp)+10);
                }
            }
        }

        for (int i = 0; i< visitors.size(); i++) {
            if (recommend.containsKey(visitors.get(i))) recommend.put(visitors.get(i), recommend.get(visitors.get(i))+1);
            else {
                recommend.put(visitors.get(i), 1);
            }
        }

        for (int i = 0; i < friendRelation.get(user).size(); i++) {
            recommend.remove(friendRelation.get(user).get(i));
        }
        List<String> keySet = new ArrayList<>(recommend.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return recommend.get(o2).compareTo(recommend.get(o1));
            }
        });
        for (String key : recommend.keySet()) {
            answer.add(key);
        }

        return answer;
    }
}
