package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return getResult(user, friends, visitors);
    }

    private static List<String> getResult(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<UserPoint> userPoints = makeUserPoints(user, friends, visitors);

        sortUserPoints(userPoints);

        for (UserPoint userPoint : userPoints.subList(0, getMaxLength(userPoints))) {
            answer.add(userPoint.userId);
        }

        return answer;
    }

    private static int getMaxLength(List<UserPoint> userPoints) {
        int maxLength = 5;
        if (userPoints.size() < maxLength) {
            maxLength = userPoints.size();
        }
        return maxLength;
    }

    private static List<UserPoint> makeUserPoints(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationships = makeRelationShips(friends);
        List<String> userFriends = fillUserFriends(user, relationships);

        List<UserPoint> userPoints = new ArrayList<>();

        enrichPointFor(getPointFrom(relationships, user, userFriends), userPoints);
        enrichPointFor(getPointFrom(visitors, user, userFriends), userPoints);

        return userPoints;
    }

    private static void enrichPointFor(Map<String, Integer> pointMap, List<UserPoint> userPoints) {
        for (String recommend : pointMap.keySet()) {
            userPoints.add(new UserPoint(recommend, pointMap.get(recommend)));
        }
    }

    public static Map<String, Integer> getPointFrom(List<String> visitors, String user, List<String> userFriends) {
        Map<String, Integer> visitorPoints = new HashMap<>();

        addPoint(visitors, visitorPoints, 1);
        removeCantRecommendCase(user, userFriends, visitorPoints);
        return visitorPoints;
    }

    private static void removeCantRecommendCase(String user, List<String> userFriends, Map<String, Integer> points) {
        for (String friend : userFriends) {
            removeKey(points, friend);
        }
        removeKey(points, user);
    }

    private static void removeKey(Map<String, Integer> points, String friend) {
        if (!isEmptyValue(points, friend)) {
            points.remove(friend);
        }
    }

    private static boolean isEmptyValue(Map<String, ?> map, String key) {
        return map.get(key) == null;
    }

    public static Map<String, Integer> getPointFrom(Map<String, List<String>> relationships,
            String user, List<String> userFriends) {
        Map<String, Integer> friendPoints = new HashMap<>();

        for (String friend : userFriends) {
            addPoint(fillUserFriends(friend, relationships), friendPoints, 10);
        }

        removeCantRecommendCase(user, userFriends, friendPoints);

        return friendPoints;
    }

    private static void addPoint(List<String> list, Map<String, Integer> pointList, int point) {
        for (String recommend : list) {
            pointList.putIfAbsent(recommend, 0);
            pointList.put(recommend, pointList.get(recommend) + point);
        }
    }

    public static List<String> fillUserFriends(String user, Map<String, List<String>> relationships) {
        return relationships.get(user);
    }

    public static Map<String, List<String>> makeRelationShips(List<List<String>> friends) {
        Map<String, List<String>> relationships = new HashMap<>();

        for (List<String> friendRelation : friends) {
            enrichRelation(relationships, friendRelation.get(0), friendRelation.get(1));
            enrichRelation(relationships, friendRelation.get(1), friendRelation.get(0));
        }

        return relationships;
    }

    private static void enrichRelation(Map<String, List<String>> relationships, String f1, String f2) {
        if (isEmptyList(relationships.get(f1))) {
            relationships.put(f1, new ArrayList<>());
        }

        relationships.get(f1).add(f2);
    }

    private static boolean isEmptyList(List<String> list) {
        return list == null;
    }

    public static class UserPoint {

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
            return compareUserPoint(this, (UserPoint) other) == 0;
        }
    }

    public static void sortUserPoints(List<UserPoint> list) {
        Collections.sort(list, (a, b) ->
                compareUserPoint(a, b)
        );
    }

    private static int compareUserPoint(UserPoint a, UserPoint b) {
        if (b.getPoint() == a.getPoint()) {
            return a.getUserId().compareTo(b.getUserId());
        }
        return b.getPoint() - a.getPoint();
    }

}
