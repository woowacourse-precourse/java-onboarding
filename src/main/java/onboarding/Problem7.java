package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> allUserPoint = new HashMap<>();
        HashMap<String, List<String>> contacts = new HashMap<>();
        for (List<String> friend : friends) { // 친구 목록 만들기
            String peopleA = friend.get(0);
            String peopleB = friend.get(1);

            allUserPoint.put(peopleA, 0);
            allUserPoint.put(peopleB, 0);

            contacts.put(peopleA, makeFriendList(peopleB, contacts.get(peopleA)));
            contacts.put(peopleB, makeFriendList(peopleA, contacts.get(peopleB)));
        }

        for (String name : allUserPoint.keySet()) {
            if (isFriends(name, contacts.get(user)) || name.equals(user)) { // user의 친구 목록에 들어있고, 자기 자신이면 continue
                continue;
            }
            int point = duplicateCount(contacts.get(user), contacts.get(name));
            allUserPoint.put(name, allUserPoint.get(name)+(point*10));
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> makeFriendList(String people, List<String> friendList) {
        if (friendList==null) {
            return new ArrayList(Arrays.asList(people));
        }
        friendList.add(people);
        return friendList;
    }

    private static boolean isFriends(String name, List<String> friendList) {
        return friendList.contains(name);
    }

    private static int duplicateCount(List<String> userFriendList, List<String> otherFriendList) {
        int count = 0;
        for (String name : userFriendList) {
            if (otherFriendList.contains(name)) {
                count+=1;
            }
        }
        return count;
    }
}
