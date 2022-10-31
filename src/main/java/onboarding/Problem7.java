package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        Set<String> friendList = new HashSet<>();
        HashMap<String, Integer> acquaintance = new HashMap<>();

        // 친구목록, 아는사람 목록 만들기
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                friendList.add(friends.get(i).get(1));

                if (acquaintance.containsKey(friends.get(i).get(1)))
                    acquaintance.remove(friends.get(i).get(1));

                continue;
            }

            if (user.equals(friends.get(i).get(1))) {
                friendList.add(friends.get(i).get(0));

                if (acquaintance.containsKey(friends.get(i).get(0)))
                    acquaintance.remove(friends.get(i).get(0));

                continue;
            }

            acquaintance.put(friends.get(i).get(0), 0);
            acquaintance.put(friends.get(i).get(1), 0);
        }
        System.out.println(friendList);

        // 친구의 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
            System.out.println(friends.get(i).get(1));

            if (friends.get(i).get(0).equals(user) || friends.get(i).get(1).equals(user))
                continue;

            if (friendList.contains(friends.get(i).get(0))) {
                acquaintance.put(friends.get(i).get(1), acquaintance.get(friends.get(i).get(1)) + 10);
            }

            if (friendList.contains(friends.get(i).get(1))) {
                acquaintance.put(friends.get(i).get(0), acquaintance.get(friends.get(i).get(0)) + 10);
            }
            System.out.println(acquaintance);
        }

        // visitor 처리
        for (int i = 0; i < visitors.size(); i++) {
            if (!acquaintance.containsKey(visitors.get(i))) {
                if(friendList.contains(visitors.get(i))) continue;

                acquaintance.put(visitors.get(i), 1);
                continue;
            }

            acquaintance.put(visitors.get(i), acquaintance.get(visitors.get(i)) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(acquaintance.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < entryList.size() && i < 5; i++) {
            answer.add(entryList.get(i).getKey());
        }


        return answer;
    }
}
