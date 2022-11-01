package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static final int USER_MIN_LENGTH = 1;
    private static final int USER_MAX_LENGTH = 30;
    private static final int FRIENDS_MIN_LENGTH = 1;
    private static final int FRIENDS_MAX_LENGTH = 10000;

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

}
