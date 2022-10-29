package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String username, List<List<String>> friends, List<String> visitors) {
        SNS sns = new SNS(username);

        for(List<String> friendship : friends) {
            sns.friendConnection(friendship.get(0), friendship.get(1));
        }

        sns.calculateFriendsScore();
        sns.calculateVisitorScore(visitors);

        sns.print();

        return sns.getRecommendFriendList();
    }
}

class SNS {
    /*
     *service for managing friendships
     */
    private final Map<String, User> userlist;
    private final User user;

    public SNS(String username) {
        this.userlist = new HashMap<>();
        this.user = new User(username);
        this.userlist.put(username, this.user);
    }

    public boolean addUser(String username) {
        if (this.userlist.containsKey(username)) {
            return false;
        }
        User new_user = new User(username);

        this.userlist.put(username, new_user);

        return true;
    }

    public User getUser(String username) {
        if (!userlist.containsKey(username)) {
            addUser(username);
        }
        return userlist.get(username);
    }

    public boolean friendConnection(String usernameA, String usernameB) {
        User userA = this.getUser(usernameA);
        User userB = this.getUser(usernameB);

        userA.addFriends(usernameB);
        userB.addFriends(usernameA);

        return true;
    }

    public void calculateFriendsScore() {
        for(String friend_name : this.userlist.keySet()) {

            User friend = this.getUser(friend_name);
            if(friend_name.equals(this.user.getName())) continue;
            for(String name : this.user.getFriends()) {
                if(friend.hasFriend(name)) {
                    friend.addScore(10);
                }
            }
        }
    }

    public void calculateVisitorScore(List<String> visitors) {
        for(String friend_name : visitors) {
            User friend = this.getUser(friend_name);
            friend.addScore(1);
        }
    }

    public List<String> getRecommendFriendList() {
        Map<String, Integer> candidate = new HashMap<>();

        List<String> ret = new ArrayList<>();
        for(String friend_name : this.userlist.keySet()) {
            User friend = this.getUser(friend_name);
            int score = friend.getScore();
            if(score > 0 && !this.user.hasFriend(friend_name)) {
                candidate.put(friend_name, score);
            }
        }

        List<Map.Entry<String, Integer>> candidate_entry = new ArrayList<>(candidate.entrySet());
        candidate_entry.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String, Integer> winner : candidate_entry) {
            ret.add(winner.getKey());
            if (ret.size() == 5) break;
        }

        return ret;
    }

    public void print() {
        for(User friend : this.userlist.values()) {
            System.out.printf("%s : %d\n", friend.getName(), friend.getScore());
        }
    }
}

class User{
    private final String name;
    private final Set<String> friends;
    private int score;

    public User(String name) {
        this.name = name;
        this.friends = new HashSet<>();
        this.score = 0;
    }

    public Set<String> getFriends() {
        return this.friends;
    }

    public boolean addFriends(String friend_name) {
        this.friends.add(friend_name);
        return true;
    }

    public String getName() {
        return this.name;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public int getScore() {
        return this.score;
    }

    public boolean hasFriend(String name) {
        return this.friends.contains(name);
    }
}