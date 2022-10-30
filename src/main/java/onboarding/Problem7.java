package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User userOfSns = new User(user);
        Others others = new Others(userOfSns);
        recordRelationshipLlist(friends, userOfSns, others);
        recordVisitorList(visitors, userOfSns, others);
        List<String> answer = others.getTopFiveNameOfOtherList();
        return answer;
    }

    static void recordRelationshipLlist(List<List<String>> relationshipList, User user, Others others) {
        List<List<String>> otherRelationships = new ArrayList<>();
        relationshipList.stream().forEach(relationship -> {
            String isFriendOrOther = recordRelationship(relationship, user);
            boolean isOther = checkIsOther(isFriendOrOther);
            if (isOther) {
                otherRelationships.add(relationship);
            }
        });
        otherRelationships.stream().forEach(relationship -> {
            others.addRelationship(relationship);
        });
    }

    static String recordRelationship(List<String> relationship, User user) {
        boolean isRelationshipOfUserOfUser = user.checkIsRelationshipOfUser(relationship);
        if (isRelationshipOfUserOfUser) {
            user.addRelationship(relationship);
            return "friend";
        }
        return "other";
    }

    static boolean checkIsOther(String isFriendOrOther) {
        if (isFriendOrOther.equals("other")) {
            return true;
        }
        return false;
    }
}

class User {

    private String user;
    private List<String> friends = new ArrayList<>();

    User(String user) {
        this.user = user;
    }

    String getUser() {
        return this.user;
    }

    List<String> getFriendList() {
        List<String> friendList = this.friends;
        return friendList;
    }

    boolean checkIsRelationshipOfUser(List<String> relationship) {
        String user = this.getUser();
        boolean isContainUser = relationship.contains(user);
        return isContainUser;
    }

    void addRelationship(List<String> relationship) {
        String friend = this.getFriendFromRelationship(relationship);
        this.friends.add(friend);
    }

    String getFriendFromRelationship(List<String> relationship) {
        String user = this.getUser();
        int indexOfUser = relationship.indexOf(user);
        int indexOfFriend = 1 - indexOfUser;
        String friend = relationship.get(indexOfFriend);
        return friend;
    }
}

class Others {

    Others(User user) {
        this.user = user;
        this.othersList = new ArrayList<>();
    }

    private List<Other> othersList;
    ;
    private User user;

    User getUser() {
        return this.user;
    }

    List<Other> getOthersList() {
        return this.othersList;
    }

    void addRelationship(List<String> relationship) {
        String other1 = relationship.get(0);
        String other2 = relationship.get(1);
        this.addOther(other1);
        this.addOther(other2);
        this.addPointIfHaveMutual(other1, other2);
        this.addPointIfHaveMutual(other2, other1);
    }

    String addOther(String otherName) {
        boolean isRegisteredOther = this.checkIsRegisteredOther(otherName);
        if (isRegisteredOther) {
            return "Registered other";
        }

        Other other = new Other(otherName, 0);
        this.othersList.add(other);
        return "new other";
    }

    boolean checkIsRegisteredOther(String otherName) {
        List<String> othersNameList = this.getOthersNameList();
        boolean isRegisteredOther = othersNameList.contains(otherName);
        return isRegisteredOther;
    }

    List<String> getOthersNameList() {
        List<Other> othersList = this.getOthersList();
        List<String> othersNameList = new ArrayList<>();
        othersList.stream().forEach(other -> {
            String name = other.getName();
            othersNameList.add(name);
        });
        return othersNameList;
    }
}

class Other {

    Other(String name, int point) {
        this.name = name;
        this.point = point;
    }

    private String name;
    private int point;

    String getName() {
        return this.name;
    }
}