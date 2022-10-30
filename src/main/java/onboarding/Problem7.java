package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static boolean checkAlpha(String s) {
        char index;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            index = s.charAt(i);
            if (!('a' <= index && index <= 'z')) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUser(String user) {
        int length = user.length();

        if (length == 0 || length > 30) {
            return true;
        } else {
            return checkAlpha(user);
        }
    }

    private static boolean checkUserList(List<String> userList) {
        String user;
        int size = userList.size();

        for (int i = 0; i < size; i++) {
            user = userList.get(i);
            if (checkUser(user)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFriends(List<List<String>> friends) {
        List<String> indexList;
        String index;
        int size = friends.size();

        if (size == 0 || size > 10000) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            indexList = friends.get(i);
            if (checkUserList(indexList)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkParam(String user, List<List<String>> friends, List<String> visitors) {
        if (user == null || friends == null || visitors == null) {
            return true;
        } else if (checkUser(user)) {
            return true;
        } else if (checkFriends(friends)) {
            return true;
        } else {
            return checkUserList(visitors);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
