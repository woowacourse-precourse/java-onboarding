package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ListGraph friendGraph = new ListGraph();
        friends.forEach(list -> friendGraph.put(new User(list.get(0)), new User(list.get(1))));
        User targetUser = friendGraph.getUser(new User(user));

        HashMap<User, Integer> map = new HashMap<>();

        List<User> targetUserFriendList = friendGraph.getUser(targetUser).getFriends();
        targetUserFriendList.forEach(freind -> friendGraph.getUser(freind).getFriends().forEach(friendUser -> {
                    if (!friendUser.equals(targetUser)){
                        map.put(friendUser, map.getOrDefault(friendUser, 0) + 1);
                    }
                }
        ));

        Set<User> recommendedUser = new HashSet<>();
        map.forEach((key, value) -> {
            if (value > 1 && !targetUser.getFriends().contains(key)) {
                key.addTenPoint(value);
                recommendedUser.add(key);
            }
        });


        for (String visitor : visitors) {
            User visitedUser = new User(visitor);
            if (!targetUserFriendList.contains(visitedUser)) {
                if (recommendedUser.contains(visitedUser)) {
                    recommendedUser.forEach( i -> {
                        if (i.equals(visitedUser)) i.addOnePoint();
                    });
                }
                else {
                    visitedUser.addOnePoint();
                    recommendedUser.add(visitedUser);
                }
            }
        }
        return recommendedUser.stream().sorted().limit(5).map(User::getId).collect(Collectors.toList());
    }
}
class ListGraph {
    private Set<User> listGraph = new HashSet<>();

    public ListGraph() {
    }

    public Set<User> getListGraph() {
        return listGraph;
    }

    public void setListGraph(Set<User> listGraph) {
        this.listGraph = listGraph;
    }
    public User getUser(User user) {
        if (!listGraph.contains(user)) return null;
        for (User storedUser : listGraph) {
            if (storedUser.equals(user)) return storedUser;
        }
        return null;
    }
    public void put(User userA, User userB) {
        if (!listGraph.contains(userA)){
            listGraph.add(userA);
        }
        if (!listGraph.contains(userB)) {
            listGraph.add(userB);
        }
        listGraph.forEach(i -> {
            if (i.equals(userA)) i.getFriends().add(userB);
            if (i.equals(userB)) i.getFriends().add(userA);
        });
    }
}
class User implements Comparable<User> {
    private String id;
    private List<User> friends = new ArrayList<>();
    private int point;

    public User(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getId() {
        return id;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addOnePoint() {
        this.point += 1;
    }

    public void addTenPoint(int value) {
        this.point += (10 * value);
    }

    public int getPoint() {
        return point;
    }

    @Override
    public int compareTo(User o) {
        if (o.getPoint() - getPoint() != 0) {
            return o.getPoint() - this.getPoint();
        }
        return this.getId().compareTo(o.getId());
    }
}
