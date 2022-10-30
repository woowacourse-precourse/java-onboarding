package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class User {
    String name;
    Friends friends;
    HashMap<String, Integer> recommendedUsers = new HashMap<>();
    User(String name) {
        this.name = name;
    }

    public void generateFriends(Friends friends) {
        this.friends = friends;
    }

    private boolean isFriend(String user) {
        return this.friends.getNameList().contains(user);
    }
    private void addVisitor(List<String> visitors) {
        for (String s : visitors) {
            if (!isFriend(s)) {
                recommendedUsers.putIfAbsent(s, 0);
            }
        }
    }

    private void addAcquaintances() {
        for (Friend f : friends.getFriends()) {
            for (String s : f.friends.getNameList())
                this.recommendedUsers.putIfAbsent(s, 0);
        }
    }

    public void putVisitorsScore(List<String> visitors) {
        addVisitor(visitors);
        for (String s : visitors) {
            if (!isFriend(s)) {
                recommendedUsers.put(s, recommendedUsers.get(s) + 1);
            }
        }
    }

    public void putAcquaintancesScore() {
        addAcquaintances();
        for (Friend f : friends.getFriends()) {
            for (String s : f.friends.getNameList()) {
                recommendedUsers.put(s, recommendedUsers.get(s)+10);
            }
        }
    }

    public Friend getFriend(String name) throws IllegalArgumentException {
        for (Friend f : this.friends.getFriends()) {
            if (f.getName() == name) {
                return f;
            }
        }
        throw new IllegalArgumentException("해당 친구는 없습니다.");
    }

    public List<String> printRecommendedFriends() {
        List<String> keySetList = new ArrayList<>(recommendedUsers.keySet());
        Collections.sort(keySetList, (o1, o2) -> (recommendedUsers.get(o2).compareTo(recommendedUsers.get(o1))));
        return new ArrayList<>(recommendedUsers.keySet());
    }
}

class Friend {
    String name;
    Friends friends;
    Friend(String name) {
        this.name = name;
    }

    public void generateFriends(Friends friends) {
        this.friends = friends;
    }

    public List<String> getFriends() {
        List<String> nameList = new ArrayList<>();
        for (String s : this.friends.getNameList()) {
            nameList.add(s);
        }
        return nameList;
    }

    public String getName() {
        return this.name;
    }
}

class Friends {
    ArrayList<Friend> friends;

    Friends(ArrayList<Friend> friends) {
        this.friends = friends;
    }

    public ArrayList<Friend> getFriends() {
        return this.friends;
    }

    public ArrayList<String> getNameList() {
        ArrayList<String> friendsNameList = new ArrayList<>();
        for (Friend f : friends) {
            friendsNameList.add(f.getName());
        }
        return friendsNameList;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<Friend> friendsArray = new ArrayList<>();
        User targetUser = new User(user);

        for (List<String> l : friends) {
            if (l.contains(user)) {
                friendsArray.add(new Friend(l.get(0)));
            }
        }
        targetUser.generateFriends(new Friends(friendsArray));

        for (Friend f : targetUser.friends.getFriends()) {
            ArrayList<Friend> acquaintancesList = new ArrayList<>();
            for (List<String> l : friends) {
                if (l.get(0).contains(f.name) && l.get(1) != targetUser.name) {
                    acquaintancesList.add(new Friend(l.get(1)));
                }
            }
            targetUser.getFriend(f.getName()).generateFriends(new Friends(acquaintancesList));
        }

        targetUser.putAcquaintancesScore();
        targetUser.putVisitorsScore(visitors);

        List<String> recommendedUsers = targetUser.printRecommendedFriends();
        System.out.println(targetUser.recommendedUsers);
        return recommendedUsers;
    }
}
