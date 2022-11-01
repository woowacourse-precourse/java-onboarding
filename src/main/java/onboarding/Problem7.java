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
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validate(user, friends, visitors);
        RelationShip relationShip = new RelationShip(friends);

        UserScore userScore = new UserScore(user, visitors, relationShip);

        Result result = new Result();
        List<String> answer = result.calculateResult(userScore, relationShip, user);
        return answer;
    }
    private static void validate(final String user, final List<List<String>> friends, final List<String> visitors) {
        Advice.validate(user, friends, visitors);
    }

    static class Result{
        private List<String> result;

        public Result() {
            this.result = new ArrayList<>();
        }

        public List<String> calculateResult(final UserScore userScore, final RelationShip relationShip,
            final String user) {
            List<String> userOfFriendFromRelation = getUserOfFriendFromRelation(relationShip, user);
            Map<String, Integer> sortedMap = sortUserScore(userScore);
            this.result = calculateRank(userOfFriendFromRelation, sortedMap, user);
            return result;
        }

        public Map<String, Integer> sortUserScore(final UserScore userScore) {
            return userScore.sortUserScoreMap();
        }

        private List<String> getUserOfFriendFromRelation(final RelationShip relationShip, final String user){
            return relationShip.getUserOfFriend(user);
        }

        private List<String> calculateRank(final List<String> userFriends, final Map<String, Integer> sortUserScoreMap,
            final String user) {
            List<String> result = new ArrayList<>();
            for (String userName : sortUserScoreMap.keySet()) {
                if (user.equals(userName) || userFriends.contains(userName)) {
                    continue;
                }
                if (sortUserScoreMap.get(userName) != 0) {
                    result.add(userName);
                }
            }
            return calculateTopFive(result);
        }

        private List<String> calculateTopFive(final List<String> result) {
            if (result.size() <= 5) {
                return result;
            }
            return result.subList(0, 5);
        }
    }

    static class UserScore{
        private static final int VISITANT = 1;
        private final Map<String, Integer> userScoreMap;

        public UserScore(Map<String, Integer> userScoreMap) {
            this.userScoreMap = userScoreMap;
        }

        public UserScore(final String user, final List<String> visitors, final RelationShip relationShip){
            this.userScoreMap = makeInitUserScoreMap(relationShip, user);
            addUserScoreMapByVisitor(visitors);
        }
        private Map<String, Integer> makeInitUserScoreMap(final RelationShip relationShip, final String user) {
            return relationShip.makeInitUserScoreMapByRelationShip(user);
        }

        private void addUserScoreMapByVisitor(final List<String> visitors) {
            if (visitors.size() == 0) return;

            for (String visitor : visitors) {
                if (!this.userScoreMap.containsKey(visitor)){
                    this.userScoreMap.put(visitor, 0);
                }
                this.userScoreMap.put(visitor, this.userScoreMap.get(visitor) + VISITANT);
            }
        }

        private Map<String, Integer> sortUserScoreMap(){
            List<Map.Entry<String, Integer>> list = new LinkedList<>(userScoreMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int comparison = (o1.getValue() - o2.getValue()) * -1;
                    return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
                }
            });
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
                Map.Entry<String, Integer> entry = iter.next();
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            return sortedMap;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            UserScore userScore = (UserScore)o;
            return Objects.equals(userScoreMap, userScore.userScoreMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userScoreMap);
        }

        @Override
        public String toString() {
            return "UserScore{" +
                "userScoreMap=" + userScoreMap +
                '}';
        }
    }

    static class RelationShip {
        private static final int FRIEND_OF_FRIEND = 10;
        private Map<String, List<String>> relationShipMap;

        public RelationShip(){
            this.relationShipMap = new HashMap<>();
        }

        public RelationShip(Map<String, List<String>> relationShipMap) {
            this.relationShipMap = relationShipMap;
        }

        public RelationShip(final List<List<String>> friends) {
            this.relationShipMap = new HashMap<>();
            makeRelationship(friends);
        }

        public Map<String, Integer> makeInitUserScoreMapByRelationShip(final String user){
            Map<String, Integer> userScoreMap = this.relationShipMap.keySet().stream()
                .collect(Collectors.toMap(String::valueOf, e -> 0));

            return calculateUserScoreMapByFriendOfFriend(user, userScoreMap);
        }

        private Map<String, Integer> calculateUserScoreMapByFriendOfFriend(final String user, Map<String, Integer> userScoreMap) {
            List<String> userOfFriends = this.relationShipMap.get(user);
            if (userOfFriends == null) {
                return userScoreMap;
            }
            for (String userOfFriend : userOfFriends) {
                putUserScoreByFriend(userScoreMap, userOfFriend);
            }
            return userScoreMap;
        }

        private void putUserScoreByFriend(Map<String, Integer> userScoreMap, final String userOfFriend) {
            List<String> strings = this.relationShipMap.get(userOfFriend);
            for (String string : strings) {
                userScoreMap.put(string, userScoreMap.get(string) + FRIEND_OF_FRIEND);
            }
        }

        private void makeRelationship(final List<List<String>> friends) {
            for (List<String> friend : friends) {
                addRelationship(friend.get(0), friend.get(1));
                addRelationship(friend.get(1), friend.get(0));
            }
        }

        private void addRelationship(final String user1, final String user2) {
            if (!this.relationShipMap.containsKey(user1)) {
                this.relationShipMap.put(user1, new ArrayList<>(List.of(user2)));
                return;
            }
            List<String> relation = relationShipMap.get(user1);
            relation.add(user2);
            relationShipMap.put(user1, relation);
        }

        public List<String> getUserOfFriend(String user) {
            if (this.relationShipMap.get(user) == null) {
                return new ArrayList<>();
            }
            return this.relationShipMap.get(user);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            RelationShip that = (RelationShip)o;
            return Objects.equals(relationShipMap, that.relationShipMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(relationShipMap);
        }

        @Override
        public String toString() {
            return "RelationShip{" +
                "relationShipMap=" + relationShipMap +
                '}';
        }
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
            if (visitors.size() > 10000) {
                throw new IllegalArgumentException();
            }
            for (String visitor : visitors) {
                checkUserNameValid(visitor);
            }
        }
    }

}
