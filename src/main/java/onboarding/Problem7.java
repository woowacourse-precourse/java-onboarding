package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.Problem7.Const.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkValidation(user, friends, visitors);

        List<String> answer = Collections.emptyList();
        Set<String> alreadyFriends = getAlreadyFriends(user, friends);
        Map<String, Integer> recomFriends = getRecomFriends(user, alreadyFriends, friends);

        setVisitPoint(recomFriends, alreadyFriends, visitors);

        answer = getSortedResult(new ArrayList<>(recomFriends.entrySet()));

        return answer;
    }

    private static Set<String> getAlreadyFriends(String user, List<List<String>> friends){
        Set<String> alreadyFriend = new HashSet<>();

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if (name1.equals(user)){
                alreadyFriend.add(name2);
            }

            if (name2.equals(user)){
                alreadyFriend.add(name1);
            }
        }

        return alreadyFriend;
    }

    private static Map<String, Integer> getRecomFriends(String user, Set<String> alreadyFriends, List<List<String>> friends){
        Map<String, Integer> recomFriends = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (isNotEqual(user, friend2) && isNotAlreadyFriend(alreadyFriends, friend2)){
                setFriendPoint(alreadyFriends, friend1, recomFriends, friend2);
            }

            if (isNotEqual(user, friend1) && isNotAlreadyFriend(alreadyFriends, friend1)){
                setFriendPoint(alreadyFriends, friend2, recomFriends, friend1);
            }
        }

        return recomFriends;
    }

    private static boolean isNotAlreadyFriend(Set<String> alreadyFriends, String friend) {
        return !alreadyFriends.contains(friend);
    }

    private static void setFriendPoint(Set<String> alreadyFriends, String alreadyFriend, Map<String, Integer> recomFriends, String recomFriend) {
        if (alreadyFriends.contains(alreadyFriend)){
            if (!recomFriends.containsKey(recomFriend)){
                recomFriends.put(recomFriend, FRIEND_POINT);

            } else{
                Integer curPoint = recomFriends.get(recomFriend);
                recomFriends.replace(recomFriend, curPoint + FRIEND_POINT);
            }
        }
    }

    private static boolean isNotEqual(String user, String recomFriend){
        return !user.equals(recomFriend);
    }

    private static void setVisitPoint(Map<String, Integer> recomFriends, Set<String> alreadyFriends, List<String> visitors){
        for (String visitor  : visitors) {
            addVisitPoint(recomFriends, alreadyFriends, visitor);
        }
    }

    private static void addVisitPoint(Map<String, Integer> recomFriends, Set<String> alreadyFriends, String visitor) {
        if (!alreadyFriends.contains(visitor)){
            if (recomFriends.containsKey(visitor)){
                Integer curPoint = recomFriends.get(visitor);
                recomFriends.replace(visitor, curPoint + 1);
            } else{
                recomFriends.put(visitor, 1);
            }
        }
    }

    private static List<String> getSortedResult(List<Map.Entry<String, Integer>> entryList) {
        Comparator<Map.Entry<String, Integer>> valueComparator = (e1, e2) -> {
            if(e1.getValue() == e2.getValue()){
                return e1.getKey().compareTo(e2.getKey());
            }

            return e2.getValue().compareTo(e1.getValue());
        };


        return entryList.stream()
                .sorted(valueComparator)
                .map(Map.Entry::getKey)
                .limit(RESULT_OFFSET)
                .collect(Collectors.toList());
    }

    private static void checkValidation(String user, List<List<String>> friends, List<String> visitors) {
        if (isUserWrongLength(user)){
            throw new IllegalArgumentException("user 길이는 1이상 30이하 입니다.");
        }

        if (isFriendsWrongSize(friends)){
            throw new IllegalArgumentException("friends 길이는 1이상 10,000이하 입니다.");
        }

        if (isVisitorsWrongSize(visitors)){
            throw new IllegalArgumentException("visitor 길이는 0이상 10,000이하 입니다.");
        }

        friends.forEach(friend -> {
            if(isFriendWrongSize(friend)){
                throw new IllegalArgumentException("friends 각 원소는 길이가 2이어야 합니다.");
            }
        });
    }

    private static boolean isUserWrongLength(String userName){
        int length = userName.length();
        return (length < USER_MIN_LENGTH || length > USER_MAX_LENGTH);
    }

    private static boolean isFriendsWrongSize(List<List<String>> friends){
        int size = friends.size();
        return (size < FRIENDS_MIN_LENGTH || size > FRIENDS_MAX_LENGTH);
    }

    private static boolean isFriendWrongSize(List<String> friend){
        return (friend.size() != FRIEND_ARRAY_SIZE);
    }

    private static boolean isVisitorsWrongSize(List<String> visitors){
        int size = visitors.size();
        return (size < VISITOR_MIN_LENGTH || size > VISITOR_MAX_LENGTH);
    }


    static class Const{
        public static final int USER_MIN_LENGTH = 1;
        public static final int USER_MAX_LENGTH = 30;

        public static final int FRIENDS_MIN_LENGTH = 1;
        public static final int FRIENDS_MAX_LENGTH = 10000;

        public static final int FRIEND_ARRAY_SIZE = 2;

        public static final int VISITOR_MIN_LENGTH = 0;
        public static final int VISITOR_MAX_LENGTH = 10000;

        public static final int FRIEND_POINT = 10;

        public static final int RESULT_OFFSET = 5;
    }
}
