package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Problem7 {


    public static final int LIST_START_LENGTH = 1;
    public static final int LIST_END_LENGTH = 10_000;

    public static final int USERID_START_LENGTH = 1;
    public static final int USERID_END_LENGTH = 30;

    static UserPoints makeUserPoints(String user, List<List<String>> friends, List<String> visitors) {
        return new UserPoints(user, friends, visitors);
    }

    static RelationShips makeRelationShips(List<List<String>> friends) {
        return new RelationShips(friends);
    }

    static UserPoint makeUserPoint(String userId, int point) {
        return new UserPoint(userId, point);
    }

    static UserPointMap makeUserPointMap(List<String> visitors, String user, List<String> userFriends) {
        return new UserPointMap(visitors, user, userFriends);
    }

    static UserPointMap makeUserPointMap(RelationShips relationships, String user, List<String> userFriends) {
        return new UserPointMap(relationships, user, userFriends);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return makeUserPoints(user, friends, visitors).result();
    }

    private static boolean isEmptyValue(Map<String, ?> map, String key) {
        return map.get(key) == null;
    }


    private static boolean isEmptyList(List<String> list) {
        return list == null;
    }


    private static boolean isValidLength(int num, int start, int end) {
        return start <= num && num <= end;
    }

    private static boolean isValidList(List<?> list) {
        return isValidLength(list.size(), LIST_START_LENGTH, LIST_END_LENGTH);
    }

    private static boolean isValidUserId(String userId) {
        for (char ch : userId.toCharArray()) {
            if (!Character.isLowerCase(ch)) {
                return false;
            }
        }

        return isValidLength(userId.length(), USERID_START_LENGTH, USERID_END_LENGTH);
    }

    static class UserPoints {

        final int RESULT_LIMIT_LENGTH = 5;
        private List<UserPoint> points;

        public UserPoints(String user, List<List<String>> friends, List<String> visitors) {
            this.points = makeUserPoints(user, friends, visitors);
        }

        private int limitLength() {
            int limitLen = RESULT_LIMIT_LENGTH;
            if (points.size() < limitLen) {
                limitLen = points.size();
            }
            return limitLen;
        }

        private List<UserPoint> makeUserPoints(String user, List<List<String>> friends, List<String> visitors) {
            if (!isValidUserId(user)) {
                throw new InputMismatchException("유효하지 않은 사용자 입니다.");
            }

            RelationShips relationships = makeRelationShips(friends);
            List<String> userFriends = relationships.friendsFor(user);

            List<UserPoint> userPoints = new ArrayList<>();

            enrichPointFor(makeUserPointMap(relationships, user, userFriends), userPoints);
            enrichPointFor(makeUserPointMap(visitors, user, userFriends), userPoints);

            return userPoints;
        }


        private void enrichPointFor(UserPointMap userPointMap, List<UserPoint> userPoints) {
            for (String recommend : userPointMap.value().keySet()) {
                userPoints.add(new UserPoint(recommend, userPointMap.value().get(recommend)));
            }
        }


        public void sort() {
            Collections.sort(points);
        }

        public List<String> result() {
            sort();

            List<String> ret = new ArrayList<>();

            for (UserPoint userPoint : points.subList(0, limitLength())) {
                ret.add(userPoint.userId);
            }

            return ret;
        }

    }

    static class UserPointMap {

        public final int FRIEND_POINT = 10;
        public final int VISITOR_POINT = 1;

        private Map<String, Integer> pointMap;

        public UserPointMap(List<String> visitors, String user, List<String> userFriends) {
            if (!isValidList(visitors)) {
                throw new InputMismatchException("Visitor, 리스트의 범위를 초과하였습니다.");
            }

            this.pointMap = new HashMap<>();

            addPoints(visitors, VISITOR_POINT);
            removeCantRecommendCase(user, userFriends);
        }

        public UserPointMap(RelationShips relationships, String user, List<String> userFriends) {
            this.pointMap = new HashMap<>();

            for (String friend : userFriends) {
                addPoints(relationships.friendsFor(friend), FRIEND_POINT);
            }

            removeCantRecommendCase(user, userFriends);
        }

        private void removeCantRecommendCase(String user, List<String> userFriends) {
            for (String friend : userFriends) {
                removeKey(friend);
            }
            removeKey(user);
        }

        private void removeKey(String friend) {
            if (!isEmptyValue(pointMap, friend)) {
                pointMap.remove(friend);
            }
        }


        private void addPoints(List<String> list, int point) {
            for (String recommend : list) {
                addPoint(point, recommend);
            }
        }

        private void addPoint(int point, String recommend) {
            if (!isValidUserId(recommend)) {
                throw new InputMismatchException("유효하지 않은 사용자 입니다.");
            }

            pointMap.putIfAbsent(recommend, 0);
            pointMap.put(recommend, pointMap.get(recommend) + point);
        }

        public Map<String, Integer> value() {
            return pointMap;
        }
    }

    static class RelationShips {

        private Map<String, List<String>> value;

        public RelationShips(List<List<String>> friends) {
            this.value = makeRelationShipsFor(friends);
        }

        public Map<String, List<String>> result() {
            return this.value;
        }

        private Map<String, List<String>> makeRelationShipsFor(List<List<String>> friends) {
            if (!isValidList(friends)) {
                throw new InputMismatchException("friends, 리스트의 범위를 초과하였습니다.");
            }
            Map<String, List<String>> relationships = new HashMap<>();

            for (List<String> friendRelation : friends) {
                enrichRelation(relationships, friendRelation.get(0), friendRelation.get(1));
                enrichRelation(relationships, friendRelation.get(1), friendRelation.get(0));
            }

            return relationships;
        }

        private void enrichRelation(Map<String, List<String>> relationships, String f1, String f2) {
            if (!isValidUserId(f1)) {
                throw new InputMismatchException("유효하지 않은 사용자입니다.");
            }
            if (isEmptyList(relationships.get(f1))) {
                relationships.put(f1, new ArrayList<>());
            }

            relationships.get(f1).add(f2);
        }

        public List<String> friendsFor(String user) {
            return value.get(user);
        }
    }

    static class UserPoint implements Comparable<UserPoint> {

        private String userId;
        private int point;

        public UserPoint(String userId, int point) {
            this.userId = userId;
            this.point = point;
        }


        public int getPoint() {
            return this.point;
        }

        public String getUserId() {
            return userId;
        }

        @Override
        public String toString() {
            return "UserPoint{" +
                    "userId='" + userId + '\'' +
                    ", point=" + point +
                    '}';
        }

        @Override
        public boolean equals(Object other) {
            if (other.getClass() != UserPoint.class) {
                return false;
            }
            return compareTo((UserPoint) other) == 0;
        }

        @Override
        public int compareTo(UserPoint o) {
            if (o.getPoint() == this.getPoint()) {
                return this.getUserId().compareTo(o.getUserId());
            }
            return o.getPoint() - this.getPoint();
        }
    }

}
