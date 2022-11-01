package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Problem7 {

    private static final int MIN_USER_SIZE = 1;
    private static final int MAX_USER_SIZE = 30;
    private static final int MIN_FRIENDS_SIZE = 1;
    private static final int MAX_FRIENDS_SIZE = 10000;
    private static final int REQULAR_FRIEND_RELATIONSHIP_SIZE = 2;
    private static final int MIN_ID_SIZE = 1;
    private static final int MAX_ID_SIZE = 30;
    private static final String ENGLISH_PATTERN = "^[a-z]*$";
    private static final int MAX_RECOMMENDATION_NUM = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validateUser(user);
        validateFriendsSize(friends);
        validateFriendRelationshipListSize(friends);
        validateFriendId(friends);

        List<String> userFriends = makeUserFriendsList(user, friends);
        Map<String, Integer> RecommendFriendsPoint = extractFriendPointList(user, friends, visitors, userFriends);
        List<Entry<String, Integer>> sortedFriendsList = sortedFriendsList(RecommendFriendsPoint);
        List<String> answer = addFinalRecommendation(sortedFriendsList);

        return answer;
    }

    private static List<String> addFinalRecommendation(List<Entry<String, Integer>> sortedUserList) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> sortedUserMap = new LinkedHashMap<>();
        for (Iterator<Entry<String, Integer>> iter = sortedUserList.iterator(); iter.hasNext(); ) {
            Entry<String, Integer> name = iter.next();
            sortedUserMap.put(name.getKey(), name.getValue());
        }

        sortedUserMap.forEach(
            (key, value) -> {
                if (answer.size() < MAX_RECOMMENDATION_NUM) {
                    if (value > 0) {
                        answer.add(key);
                    }
                }
            }
        );
        return answer;
    }
    private static List<Entry<String, Integer>> sortedFriendsList(Map<String, Integer> RecommendFriendsPoint) {
        List<Entry<String, Integer>> sortedUserList = new LinkedList<>(RecommendFriendsPoint.entrySet());
        Collections.sort(sortedUserList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return sortedUserList;
    }

    private static Map<String, Integer> extractFriendPointList(String user, List<List<String>> friends,
        List<String> visitors, List<String> userFriends) {
        Map<String, Integer> userPoint = new HashMap<>();
        for (List<String> friend : friends) {
            for (String userFriend : userFriends){
                if (friend.contains(userFriend)){
                    for (String name : friend){
                        if (!name.equals(user) && !userFriend.contains(name)){
                            if (!userPoint.containsKey(name)){
                                userPoint.put(name,10);
                            }else{
                                userPoint.put(name,userPoint.get(name)+10);
                            }
                        }
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)){
                if (!userPoint.containsKey(visitor)){
                    userPoint.put(visitor,1);
                }else{
                    userPoint.put(visitor,userPoint.get(visitor)+1);
                }
            }
        }
        return userPoint;
    }
    private static List<String> makeUserFriendsList(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (friend.contains(user)) {
                    if (!name.equals(user)) {
                        userFriends.add(name);
                    }
                }
            }
        }
        return userFriends;
    }
    private static void validateFriendId(List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String id : friend) {
                if (!Pattern.matches(ENGLISH_PATTERN, id)) {
                    throw new IllegalArgumentException("아이디는 영소문자로만 이루어져야 합니다");
                }
                if (id.length() < MIN_ID_SIZE || id.length() > MAX_ID_SIZE) {
                    throw new IllegalArgumentException("아이디 길이는 1이상 30 이하여야 합니다");
                }
            }
        }
    }

    private static void validateFriendRelationshipListSize(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.size() != REQULAR_FRIEND_RELATIONSHIP_SIZE) {
                throw new IllegalArgumentException("친구목록 리스트의 길이는 2여야 합니다");
            }
        }
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        if (friends.size() < MIN_FRIENDS_SIZE || friends.size() > MAX_FRIENDS_SIZE) {
            throw new IllegalArgumentException("친구목록의 길이는 1 이상 10000 이하여야 합니다");
        }
    }

    private static void validateUser(String user) {
        if (user.length() < MIN_USER_SIZE || user.length() > MAX_USER_SIZE) {
            throw new IllegalArgumentException("유저 이름 길이는 1 이상 30 이하여야 합니다");
        }
        if (!Pattern.matches(ENGLISH_PATTERN, user)) {
            throw new IllegalArgumentException("유저이름은 영소문자로만 이루어져야 합니다");
        }
    }
}
