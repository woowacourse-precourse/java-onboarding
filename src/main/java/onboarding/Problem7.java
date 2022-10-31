package onboarding;

import java.util.*;

public class Problem7 {
    static Set<String> friendList = new HashSet<>();
    static HashMap<String, Integer> acquaintance = new HashMap<>();

    //public static
    /*public static Set<String> makeFriendList(String user, List<List<String>> friends) {
        Set<String> friendList = new HashSet<>();
    }*/

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();


        // 친구목록, 아는사람 목록 만들기
        //friendList = makeFriendList(user, friends);
        for (int i = 0; i < friends.size(); i++) {
            String firstName = friends.get(i).get(0);
            String secondName = friends.get(i).get(1);

            if (user.equals(firstName)) {
                friendList.add(secondName);

                // 친구가 된 경우 acquaintance에서 빼야 함
                if (acquaintance.containsKey(secondName))
                    acquaintance.remove(secondName);

                continue;
            }

            if (user.equals(secondName)) {
                friendList.add(firstName);
                if (acquaintance.containsKey(firstName))
                    acquaintance.remove(firstName);
                continue;
            }
            acquaintance.put(friends.get(i).get(0), 0);
            acquaintance.put(friends.get(i).get(1), 0);
        }
        //System.out.println(friendList);

        // 친구의 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            String firstName = friends.get(i).get(0);
            String secondName = friends.get(i).get(1);
            //System.out.println(friends.get(i));
            //System.out.println(friends.get(i).get(1));

            if (friends.get(i).get(0).equals(user) || friends.get(i).get(1).equals(user))
                continue;

            if (friendList.contains(firstName)) {
                acquaintance.put(secondName, acquaintance.get(secondName) + 10);
            }

            if (friendList.contains(secondName)) {
                acquaintance.put(firstName, acquaintance.get(firstName) + 10);
            }
            //System.out.println(acquaintance);
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
