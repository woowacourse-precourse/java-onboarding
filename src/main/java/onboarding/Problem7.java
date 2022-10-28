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
    public static HashMap<String, HashSet<String>> friendBook = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
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

    private static class Sns {
        private HashSet<String> friends = new HashSet<>();

    }
}
