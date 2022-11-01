package onboarding;

import java.util.*;

public class Problem7 {
    static HashSet<String> alreadyFriends = new HashSet<>();
    static List<String> acquaintance = new ArrayList<>();
    static List<String> newVisitors = new ArrayList<>();
    static HashMap<String, Integer> recommendScore = new HashMap<>();
    static List<String> sortedID = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        executeAll(user, friends, visitors);
        sortRecommendID();
        answer = sortedID;

        return answer;
    }

    public static void executeAll(String user, List<List<String>> friends, List<String> visitors) {
        checkAllRelationInfo(friends, user);
        addAcquaintanceID(friends, user);
        addNewVisitors(visitors);
        resetScore();
        calculateScore();
    }

    public static void sortRecommendID() {
        List<Map.Entry<String, Integer>> idList = new ArrayList<>(recommendScore.entrySet());
        // 내림차순 정렬
        Collections.sort(idList, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : idList) {
            sortedID.add(entry.getKey());
            if (isMoreThanFive()) {
                break;
            }
        }
    }

    public static boolean isMoreThanFive() {
        if (sortedID.size() == 5) {
            return true;
        }
        return false;
    }

    public static void checkAllRelationInfo(List<List<String>> friends, String user) {
        for (List<String> readOneList : friends) {
            String leftID = readOneList.get(0);
            String rightID = readOneList.get(1);
            isAlreadyFriend(leftID, rightID, user);
        }
    }

    public static void isAlreadyFriend(String leftID, String rightID, String user) {
        if (leftID.equals(user)) {
            alreadyFriends.add(rightID);
        }
        if (rightID.equals(user)) {
            alreadyFriends.add(leftID);
        }
    }

    public static void addAcquaintanceID(List<List<String>> friends, String user) {
        for (List<String> readOneList : friends) {
            String leftID = readOneList.get(0);
            String rightID = readOneList.get(1);
            checkAcquaintance(leftID, rightID, user);
        }
    }

    public static void checkAcquaintance(String leftID, String rightID, String user) {
        for (Iterator<String> alreadyFriend = alreadyFriends.iterator(); alreadyFriend.hasNext(); ) {
            isAcquaintance(leftID, rightID, user, alreadyFriend.next());
        }
    }

    public static void isAcquaintance(String leftID, String rightID, String user, String alreadyFriend) {
        if (excludeUser(leftID, rightID, user)
                && leftID.equals(alreadyFriend)) {
            acquaintance.add(rightID);
        }
        if (excludeUser(leftID, rightID, user)
                && rightID.equals(alreadyFriend)) {
            acquaintance.add(leftID);
        }
    }

    public static boolean excludeUser(String leftID, String rightID, String user) {
        if (!leftID.equals(user) && !rightID.equals(user)) {
            return true;
        }
        return false;
    }

    public static void addNewVisitors(List<String> visitors) {
        for (Iterator<String> iter = visitors.iterator(); iter.hasNext(); ) {
            String visitor = iter.next();
            if (isNewVisitor(visitor)) {
                newVisitors.add(visitor);
            }
        }
    }

    public static boolean isNewVisitor(String visitor) {
        for (Iterator<String> iter = alreadyFriends.iterator(); iter.hasNext(); ) {
            String alreadyFriend = iter.next();
            if (visitor.equals(alreadyFriend)) {
                return false;
            }
        }
        return true;
    }

    public static void resetScore() {
        for (String acquaintID : acquaintance) {
            recommendScore.put(acquaintID, 0);
        }
        for (String visitorID : newVisitors) {
            recommendScore.put(visitorID, 0);
        }
    }

    public static void calculateScore() {
        for (String acquaintID : acquaintance) {
            recommendScore.put(acquaintID, recommendScore.get(acquaintID) + 10);
        }
        for (String visitorID : newVisitors) {
            recommendScore.put(visitorID, recommendScore.get(visitorID) + 1);
        }
    }
}