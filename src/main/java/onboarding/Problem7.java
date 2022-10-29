package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class User {
    String name;
    ArrayList<Friend> friends;
    HashMap<String, Integer> recommendedUsers = new HashMap<>();
    User(String name) {
        this.name = name;
    }

    public void generateFriends(ArrayList<Friend> friends) {
        this.friends.addAll(friends);
    }

    private void addVisitor(ArrayList<String> visitors) {
        for (String s : visitors) {
            this.recommendedUsers.putIfAbsent(s, 0);
        }
    }

    private void addAcquaintances() {
        for (Friend f : this.friends) {
            this.recommendedUsers.putIfAbsent(f.getName(), 0);
        }
    }

    public void putVisitorsScore(ArrayList<String> visitors) {
        addVisitor(visitors);
        for (String s : visitors) {
            this.recommendedUsers.put(s, recommendedUsers.get(s) + 1);
        }
    }

    public void putAcquaintancesScore(ArrayList<Friend> friends) {
        addAcquaintances();
        for (Friend f : this.friends) {
            for (String s : f.friends) {
                this.recommendedUsers.put(s, recommendedUsers.get(s) + 10);
            }
        }
    }
}

class Friend {
    String name;
    ArrayList<String> friends;
    Friend(String name) {
        this.name = name;
    }

    public void generateFriends(ArrayList<String> friends) {
        this.friends = friends;
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
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

    }
}
