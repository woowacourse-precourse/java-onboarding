package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/** 기능 목록
 * solutionLogic            : 메인 솔루션
 *
 * checkValidNameLength     : 이름 길이 체크
 * checkValidFriendLength   : friend 길이 체크
 * checkValidVisitorsLength : visitors 길이 체크
 * checkLowerCase           : 아이디 소문자 확인
 *
 * [Sns] 컬렉션
 * overlappedFriends        : 겹친 친구의 수 반환
 */

public class Problem7 {
    public final int commonFriendScore = 10;
    public final int visitedTimeLineScore = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!checkLowerCase(user)) {
            return Collections.emptyList();
        }
        if(!checkValidFriendLength(friends) || !checkValidVisitorsLength(visitors)){
            return Collections.emptyList();
        }

        FriendRepository friendRepository = new FriendRepository();
        for (List<String> relationship : friends) {
            friendRepository.addRelationship(relationship.get(0), relationship.get(1));
        }
        MySns mySns = friendRepository.getUserSns(user);
        for (String visitor : visitors) {
            mySns.addVisited(visitor);
        }




        return answer;

    }

    public static boolean checkValidName(String name) {
        return checkValidNameLength(name) && checkLowerCase(name);
    }

    public static boolean checkValidNameLength(String name) {
        int len = name.length();
        return 1<= len && len <= 30;
    }

    public static boolean checkValidFriendLength(List<List<String>> friends) {
        int count = 0;
        for (List<String> friend : friends) {
            if (!checkValidInnerFriendList(friend)) {
                return false;
            }
            count += 1;
        }
        return 1<= count && count <= 10000;
    }

    public static boolean checkValidInnerFriendList(List<String> friend) {
        if (friend.size() != 2) {
            return false;
        }
        boolean a = checkValidName(friend.get(0));
        boolean b = checkValidName(friend.get(1));
        return a && b;
    }

    public static boolean checkValidVisitorsLength(List<String> visitors) {
        int len = visitors.size();
        return  len <= 10000;
    }

    public static boolean checkLowerCase(String name) {
        String compare = name.toLowerCase();
        return name.equals(compare);
    }

    static class FriendRepository{
        private final HashMap<String, MySns> world = new HashMap<>();

        private MySns getUserSns(String name) {
            return world.getOrDefault(name, new MySns());
        }

        private void addRelationship(String name1, String name2) {
            MySns name1Sns = getUserSns(name1);
            MySns name2Sns = getUserSns(name2);
            name1Sns.addFriend(name2);
            name2Sns.addFriend(name1);
            world.put(name1, name1Sns);
            world.put(name2, name2Sns);
        }

        private void addVisited(String my, String visitor) {
            MySns mySns = world.getOrDefault(my, new MySns());
            mySns.addVisited(visitor);
        }
    }

    private static class MySns {
        private final HashSet<String> friends = new HashSet<>();
        private final HashMap<String, Integer> visited = new HashMap<>();
        private final HashMap<String, Integer> recommend = new HashMap<>();

        private void addFriend(String name) {
            friends.add(name);
        }

        private HashSet<String> getMyFriends() {
            return friends;
        }

        private void addVisited(String name) {
            Integer before = visited.getOrDefault(name, 0);
            visited.put(name, before + 1);
        }

        private HashMap<String, Integer> getVisited() {
            return visited;
        }


    }
}
