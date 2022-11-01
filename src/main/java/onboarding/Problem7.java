package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int USER_MIN_LENGTH = 1;
    private static final int USER_MAX_LENGTH = 30;
    private static final int FRIENDS_MIN_LENGTH = 1;
    private static final int FRIENDS_MAX_LENGTH = 10000;
    private static final int KNOW_WITH_FRIEND_SCORE = 10;
    private static final int VISIT_SCORE = 1;
    private static final String LOWERCASE_ALPHABET = "^[a-z]*$";
    private static final List<String> FRIENDS_LIST = new ArrayList<>();
    private static final Map<String, Integer> UNKNOWN_USER_SCORE = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //user의 길이가 1이상 30이하인지 검증하는 기능
    public static boolean checkUserLengthValidation(String user) {
        return USER_MIN_LENGTH <= user.length() && user.length() <= USER_MAX_LENGTH;
    }

    //friends의 길이가 1이상 10,000이하인지 검증하는 기능
    public static boolean checkFriendsLengthValidation(List<List<String>> friends) {
        return FRIENDS_MIN_LENGTH <= friends.size() && friends.size() <= FRIENDS_MAX_LENGTH;
    }

    //friends의 아이디의 길이가 1이상 30이하인지 검증하는 기능
    public static boolean checkFriendsIdLengthValidation(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (!(USER_MIN_LENGTH <= friend.get(0).length()
                && friend.get(1).length() <= USER_MAX_LENGTH)) {
                return false;
            }
        }
        return true;
    }

    //sns 사용자 아이디 모두가 알파벳 소문자로 구성되어 있는지 검증하는 기능
    public static boolean checkUserIdConsistOfLowercaseAlphabet(String user,
        List<List<String>> friends, List<String> visitors) {
        if (!user.matches(LOWERCASE_ALPHABET)) {
            return false;
        }
        for (List<String> friend : friends) {
            if (!(friend.get(0).matches(LOWERCASE_ALPHABET) || friend.get(1)
                .matches(LOWERCASE_ALPHABET))) {
                return false;
            }
        }
        for (String visitor : visitors) {
            if (!visitor.matches(LOWERCASE_ALPHABET)) {
                return false;
            }
        }
        return true;
    }

    //동일한 친구관계가 중복되어 있는지 검증하는 기능
    public static boolean checkFriendRelationshipOverlap(List<List<String>> friends) {
        Set<List<String>> deleteSameFriendRelationship = Set.copyOf(friends);
        if (!(friends.size() == deleteSameFriendRelationship.size())) {
            return false;
        }
        return true;
    }

    //입력값을 최종적으로 검증하는 기능
    public static boolean checkInputValidation(String user, List<List<String>> friends,
        List<String> visitors) {
        if (!(checkUserLengthValidation(user) && checkFriendsLengthValidation(friends)
            && checkFriendsIdLengthValidation(friends)
            && checkUserIdConsistOfLowercaseAlphabet(user, friends, visitors)
            && checkFriendRelationshipOverlap(friends))) {
            return false;
        }
        return true;
    }

    //user 친구들을 친구리스트에 구성하는 기능
    public static void putUserFriendToList(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                FRIENDS_LIST.add(friend.get(1));
            }
            if (friend.get(1).equals(user)) {
                FRIENDS_LIST.add(friend.get(0));
            }
        }
    }

    //user가 모르는 sns 사용자들을 map에 넣는 기능
    public static void putFriendsUserUnknown(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)
                || FRIENDS_LIST.contains(friend.get(0)) && FRIENDS_LIST.contains(friend.get(1))) {
                continue;
            }
            if (!FRIENDS_LIST.contains(friend.get(0))) {
                UNKNOWN_USER_SCORE.put(friend.get(0), 0);
            }
            if (!FRIENDS_LIST.contains(friend.get(1))) {
                UNKNOWN_USER_SCORE.put(friend.get(1), 0);
            }
        }
    }

    //user sns에 방문한 사용자들을 map에 넣는 기능
    public static void putVisitorUserUnknown(List<String> visitors) {
        for (String visitor : visitors) {
            if (!FRIENDS_LIST.contains(visitor)) {
                UNKNOWN_USER_SCORE.put(visitor, 0);
            }
        }
    }

    //user와 함께 아는 친구 수 점수를 산출하는 기능
    public static void plusUnknownFriendUserScore(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (FRIENDS_LIST.contains(friend.get(0)) && FRIENDS_LIST.contains(friend.get(1))
                || friend.contains(user)) {
                continue;
            }
            if (FRIENDS_LIST.contains(friend.get(0))) {
                UNKNOWN_USER_SCORE.replace(friend.get(1),
                    UNKNOWN_USER_SCORE.get(friend.get(1)) + KNOW_WITH_FRIEND_SCORE);
            }
            if (FRIENDS_LIST.contains(friend.get(1))) {
                UNKNOWN_USER_SCORE.replace(friend.get(0),
                    UNKNOWN_USER_SCORE.get(friend.get(0)) + KNOW_WITH_FRIEND_SCORE);
            }
        }
    }

    //user sns를 방문한 사람들에게 점수를 산출하는 기능
    public static void plusUnknownVisitorUserScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (!FRIENDS_LIST.contains(visitor)) {
                UNKNOWN_USER_SCORE.replace(visitor, UNKNOWN_USER_SCORE.get(visitor) + VISIT_SCORE);
            }
        }
    }

    //총 추천점수를 산출하는 기능
    public static void calcurateTotalRecommendationScore(String user, List<List<String>> friends,
        List<String> visitors) {
        putUserFriendToList(user, friends);
        putFriendsUserUnknown(user, friends);
        putVisitorUserUnknown(visitors);
        plusUnknownFriendUserScore(user, friends);
        plusUnknownVisitorUserScore(visitors);
    }

    //추천점수가 0인 사용자 제거 기능
    public static Map<String, Integer> deleteRecommendScoreZero(
        Map<String, Integer> unknownUserScore) {
        return unknownUserScore.entrySet().stream()
            .filter(e -> e.getValue() > 0)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    //추천 점수 순으로 정렬 후 같은 점수에 대해서는 사용자 아이디를 오름차순으로 정렬하는 기능
    public static List<String> sortRecommendScore(Map<String, Integer> unknownUserScore) {
        List<String> sortScoreList = new ArrayList<>(unknownUserScore.keySet());
        sortScoreList.sort((o1, o2) -> {
            int compare = (unknownUserScore.get(o1) - unknownUserScore.get(o2)) * -1;
            if (compare == 0) {
                return o1.compareTo(o2);
            }
            return compare;
        });
        return sortScoreList;
    }

    //추천 사용자를 추출하는 기능
    public static List<String> extractRecommendUserAllOrTop5(List<String> list) {
        if (list.size() >= 5) {
            return list.stream()
                .limit(5)
                .collect(Collectors.toList());
        }
        return list.stream()
            .collect(Collectors.toList());
    }
}
