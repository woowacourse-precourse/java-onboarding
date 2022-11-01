package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

    public void calculateVisitorsScore(List<String> visitors) {
        for (String s : visitors) {
            if (!isFriend(s)) {
                Integer prevScore = recommendedUsers.getOrDefault(s, 0);
                recommendedUsers.put(s, prevScore + 1);
            }
        }
    }

    public void calculateRecommendScore() {
        for (Friend f : friends.getFriends()) {
            for (String s : f.friends.getNameList()) {
                Integer prevScore = recommendedUsers.getOrDefault(s, 0);
                recommendedUsers.put(s, prevScore + 10);
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

    public List<String> findRecommendedFriends() {
        List<Map.Entry<String, Integer>> recommendedFriends = recommendedUsers.entrySet().stream().collect(Collectors.toList());

        List<String> recommendedFriendsList = recommendedFriends.stream().sorted((f1, f2) -> {
            if (f1.getValue() == f2.getValue()) {
                return f1.getKey().compareTo(f2.getKey());
            } else {
                return f2.getValue() - f1.getValue();
            }
        }).map(e -> e.getKey())
        .collect(Collectors.toList());

        if (recommendedFriendsList.size() > 5) {
            return recommendedFriendsList.subList(0, 5);
        }
        return recommendedFriendsList;
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
        ArrayList<Friend> friendsOfUser = new ArrayList<>();
        User targetUser = new User(user);

        for (List<String> relationship : friends) {
            if (relationship.indexOf(user) >= 0) {
                friendsOfUser.add(new Friend(relationship.get(1 - relationship.indexOf(user))));
            }
        }
        targetUser.generateFriends(new Friends(friendsOfUser));

        for (Friend f : targetUser.friends.getFriends()) {
            ArrayList<Friend> acquaintancesList = new ArrayList<>();
            for (List<String> relationship : friends) {
                if (relationship.indexOf(f.name) != -1 && relationship.indexOf(targetUser.name) == -1 ) {
                    acquaintancesList.add(new Friend(relationship.get(1 - relationship.indexOf(f.name))));
                }
            }
            targetUser.getFriend(f.getName()).generateFriends(new Friends(acquaintancesList));
        }

        targetUser.calculateRecommendScore();
        targetUser.calculateVisitorsScore(visitors);

        List<String> recommendedUsers = targetUser.findRecommendedFriends();
        return recommendedUsers;
    }
}