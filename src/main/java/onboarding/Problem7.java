package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, List<String>> friendsMap = new HashMap<>();
        HashMap<String, Integer> userGradeMap = new HashMap<>();

        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);

            List<String> friendListA = friendsMap.getOrDefault(idA, new ArrayList<>());
            friendListA.add(idB);
            friendsMap.put(idA, friendListA);

            List<String> friendListB = friendsMap.getOrDefault(idB, new ArrayList<>());
            friendListB.add(idA);
            friendsMap.put(idB, friendListB);

            userGradeMap.putIfAbsent(idA, 0);
            userGradeMap.putIfAbsent(idB, 0);
        }

        for (String visitor : visitors) {
            Integer grade = userGradeMap.getOrDefault(visitor, 0);
            userGradeMap.put(visitor, grade + 1);
        }

        for (String friendWithUser : friendsMap.get(user)) {
            for (String friend : friendsMap.get(friendWithUser)) {
                Integer grade = userGradeMap.get(friend);
                userGradeMap.put(friend, grade + 10);
            }
        }

        return userGradeMap.keySet().stream()
                .filter(u -> !friendsMap.get(user).contains(u) && !u.equals(user))
                .sorted((a, b) -> {
                    if (userGradeMap.get(a) > userGradeMap.get(b)) {
                        return -1;
                    } else if (Objects.equals(userGradeMap.get(a), userGradeMap.get(b))) {
                        return a.compareTo(b);
                    }
                    return 1;
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
