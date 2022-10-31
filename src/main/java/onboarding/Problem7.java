package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.Problem7.Const.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkValidation(user, friends, visitors);

        List<String> answer = Collections.emptyList();
        Set<String> alreadyFriends = getAlreadyFriends(user, friends);

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
