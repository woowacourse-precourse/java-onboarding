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
}

class Other {

    Other(String name, int point) {
        this.name = name;
        this.point = point;
    }

    private String name;
    private int point;
}