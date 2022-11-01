package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Problem7 {

    private static final int USER_MIN_LENGTH = 1;
    private static final int USER_MAX_LENGTH = 30;
    private static final int FRIENDS_MIN_LENGTH = 1;
    private static final int FRIENDS_MAX_LENGTH = 10000;
    private static final String LOWERCASE_ALPHABET = "^[a-z]*$";

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
        List<List<String>> friends) {
        if (!user.matches(LOWERCASE_ALPHABET)) {
            return false;
        }
        for (List<String> friend : friends) {
            if (!(friend.get(0).matches(LOWERCASE_ALPHABET) || friend.get(1)
                .matches(LOWERCASE_ALPHABET))) {
                return false;
            }
        }
        return true;
    }

    //동일한 친구관계가 중복되어 있는지 검증하는 기능
    public static boolean checkFriendRelationshipOverlap(List<List<String>> friends) {
        Set<List<String>> deleteSameFriendRelationship = Set.copyOf(friends);
        if(!(friends.size() == deleteSameFriendRelationship.size())) {
            return false;
        }
        return true;
    }
}
