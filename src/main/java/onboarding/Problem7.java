package onboarding;

import java.util.*;

/** 기능 목록
 * solution                 : 메인 솔루션
 * checkValidName           : 이름 길이 & 소문자 체크
 * checkValidNameLength     : 이름 길이 체크
 * checkValidFriendLength   : friend 길이 체크
 * checkValidVisitorsLength : visitors 길이 체크
 * checkValidInnerFriendList: friend 내부 체크
 * checkLowerCase           : 아이디 소문자 확인
 *
 * [FriendRepository]
 * getUserSns               : 유저 Sns 반환
 * addVisitor               : 유저 방문자 추가
 * addRelationship          : 2 유저 관계 추가
 * getFriendRecommendation  : 유저의 추천 친구 반환
 * getSortedRecommend       : 추천 친구 정렬
 * getAllUsers              : 모든 유저 반환
 * getNotMyFriends          : 친구 아닌 유저 반환
 * getScore                 : 관계 점수 반환
 * scoreOverLapped          : 겹친 친구 점수 반환
 * scoreVisitor             : 방문 횟수 점수 반환
 *
 * [Sns] 컬렉션
 * addFriend                : 내 Sns 친구 추가
 * getMyFriends             : 내 Sns 친구 반환
 * addVisited               : 내 Sns 방문자 추가
 * getVisited               : 내 Sns 방문자 반환
 */

public class Problem7 {

    public static final int commonFriendScore = 10;
    public static final int visitedTimeLineScore = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!checkLowerCase(user)) {
            throw new IllegalArgumentException("제한사항 위반 [유저 이름 소문자]");
        }
        if(!checkValidFriendLength(friends) || !checkValidVisitorsLength(visitors)){
            throw new IllegalArgumentException("제한사항 위반");
        }
        FriendRepository friendRepository = new FriendRepository();
        for (List<String> relationship : friends) {
            friendRepository.addRelationship(relationship.get(0), relationship.get(1));
        }
        for (String visitor : visitors) {
            friendRepository.addVisitor(user, visitor);
        }
        return friendRepository.getFriendRecommendation(user);
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
                throw new IllegalArgumentException("제한사항 위반");
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

        private void addVisitor(String user, String visitor) {
            Set<String> allUsers = getAllUsers();
            MySns userSns = getUserSns(user);
            userSns.addVisited(visitor);
            if (!allUsers.contains(visitor)) {
                world.put(visitor, new MySns());
            }
        }

        private void addRelationship(String name1, String name2) {
            MySns name1Sns = getUserSns(name1);
            MySns name2Sns = getUserSns(name2);
            name1Sns.addFriend(name2);
            name2Sns.addFriend(name1);
            world.put(name1, name1Sns);
            world.put(name2, name2Sns);
        }

        private List<String> getFriendRecommendation(String user) {
            Map<String, Integer> result = new HashMap<>();
            Set<String> notMyFriends = getNotMyFriends(user);
            for (String other : notMyFriends) {
                int score = getScore(user, other);
                result.put(other, score);
            }
            return getSortedRecommend(result);
        }

        private List<String> getSortedRecommend(Map<String, Integer> map) {
            List<String> result = new ArrayList<>();
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((o1, o2) ->
                    Objects.equals(o1.getValue(), o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());
            for (int i = 0; i < Math.min(5, entryList.size()); i++) {
                result.add(entryList.get(i).getKey());
            }
            return result;
        }

        private Set<String> getAllUsers() {
            return world.keySet();
        }

        private Set<String> getNotMyFriends(String user) {
            MySns mySns = world.get(user);
            Set<String> allUsers = getAllUsers();
            HashSet<String> myFriends = mySns.getMyFriends();
            Set<String> result = new HashSet<>(allUsers);
            result.removeAll(myFriends);
            result.remove(user);
            return result;
        }

        private int getScore(String user, String other) {
            Set<String> userFriends = getUserSns(user).getMyFriends();
            Set<String> otherFriends = getUserSns(other).getMyFriends();
            return scoreOverLapped(userFriends, otherFriends) + scoreVisitor(user, other);
        }

        private int scoreOverLapped(Set<String> A, Set<String> B) {
            Set<String> compare = new HashSet<>(A);
            compare.retainAll(B);
            return compare.size() * commonFriendScore;
        }

        private int scoreVisitor(String user, String visited) {
            MySns userSns = getUserSns(user);
            HashMap<String, Integer> visitedMap = userSns.getVisited();
            return visitedMap.getOrDefault(visited, 0) * visitedTimeLineScore;
        }
    }

    private static class MySns {

        private final HashSet<String> friends = new HashSet<>();
        private final HashMap<String, Integer> visited = new HashMap<>();

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
