package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 예외처리
 *   1) user 길이 체크
 *   2) friends 배열 길이 체크
 *   3) friends의 각 원소 길이 체크
 *   4) visitors 길이 체크
 *   5) 각 user 이름 길이 알파벳 소문자인지 각 아이디가 길이에 맞는지 체크
 *
 * 2. 핵심로직
 *   1) 친구 네트워크 생성 ( key(string) : value(list)) 형태
 *   2) 친구 추천 점수 생성( key(String) : value(Integer))형태 : 일단 본인까지 추천 점수에 넣어줌
 *   3) 친구 네트워크를 조사하면서, 본인과 본인 직접친구 제외 친구의 친구만 10점씩 점수 올려줌
 *   4) visitors에서 친구 추천 점수 칸에 없는 방문자를 먼저 0점으로 초기화 해준 후 visitors를 1점씩 추가 시켜줌
 *
 */
public class Problem7 {

    private static Map<String, List<String>> relationshipMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validate(user, friends, visitors);
        makeRelationship(friends);
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void makeRelationship(final List<List<String>> friends) {
        for (List<String> friend : friends) {
            addRelationship(friend.get(0), friend.get(1));
            addRelationship(friend.get(1), friend.get(0));
        }
    }

    private static void addRelationship(final String user1, final String user2) {
        if (!relationshipMap.containsKey(user1)) {
            relationshipMap.put(user1, new ArrayList<>(List.of(user2)));
            return;
        }
        List<String> relation = relationshipMap.get(user1);
        relation.add(user2);
        relationshipMap.put(user1, relation);
    }

    private static void validate(final String user, final List<List<String>> friends, final List<String> visitors) {
        Advice.validate(user, friends, visitors);

    }

    static class Advice{

        private static final int A_LOWER_CASE_ASCII = 97;
        private static final int Z_LOWER_CASE_ASCII = 122;
        private Advice (){}

        public static void validate(String user, List<List<String>> friends, List<String> visitors) {
            checkUserNameValid(user);
            checkFriendsSizeRange(friends);
            checkVisitorsSizeRange(visitors);
        }
        private static void checkUserNameValid(String user) {
            if (user.length() < 1 || user.length() > 30) {
                throw new IllegalArgumentException();
            }
            checkUsernameToLowercase(user);
            checkUsernameComposedInEnglish(user);
        }
        private static void checkUsernameToLowercase(String user) {
            if (!user.equals(user.toLowerCase())) {
                throw new IllegalArgumentException();
            }
        }

        private static void checkUsernameComposedInEnglish(String user) {
            String[] splitUser = user.split("");
            for (String step : splitUser) {
                int ascii = step.charAt(0);
                if (ascii < A_LOWER_CASE_ASCII || ascii > Z_LOWER_CASE_ASCII) {
                    throw new IllegalArgumentException();
                }
            }
        }
        private static void checkFriendsSizeRange(List<List<String>> friends) {
            if (friends.size() < 1 || friends.size() > 10000) {
                throw new IllegalArgumentException();
            }
            for (List<String> friend : friends) {
                checkFriendsElementLength(friend);

            }
        }

        private static void checkFriendsElementLength(List<String> friend) {
            if (friend.size() != 2) {
                throw new IllegalArgumentException();
            }
            checkUserNameValid(friend.get(0));
            checkUserNameValid(friend.get(1));
        }


        private static void checkVisitorsSizeRange(List<String> visitors) {
            if (visitors.size() < 1 || visitors.size() > 10000) {
                throw new IllegalArgumentException();
            }
            for (String visitor : visitors) {
                checkUserNameValid(visitor);
            }
        }
    }

}
