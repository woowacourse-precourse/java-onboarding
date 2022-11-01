package onboarding;

import java.util.*;

class Recommendation {
    String user;
    List<List<String>> friends;
    List<String> visitors;
    HashMap<String, Integer> users;

    public Recommendation(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        this.users = new HashMap<>();
    }

    int exception() {
        if((user.length() < 1) || (user.length() > 30)) {
            return -1;
        } else if((friends.size() < 1) || (friends.size() > 10000)) {
            return -1;
        } else if((visitors.size() > 10000)) {
            return  -1;
        } else {
            for(int i = 0; i < friends.size(); i++) {
                if((friends.get(i).get(0).length() < 1) || (friends.get(i).get(0).length() > 30)) {
                    return -1;
                } else if((friends.get(i).get(1).length() < 1) || (friends.get(i).get(1).length() > 30)) {
                    return -1;
                }
            }
        }

        return 0;
    }

    void init() {
        for(int i = 0; i < friends.size(); i++) {
            users.put(friends.get(i).get(0), 0);
            users.put(friends.get(i).get(1), 0);
        }
        for(int i = 0; i < visitors.size(); i++) {
            users.put(visitors.get(i), 0);
        }
    }

    void visitScore() {
        int value;

        for(int i = 0; i < visitors.size(); i++) {
            value = users.get(visitors.get(i));
            users.put(visitors.get(i), value + 1);
        }
    }

    void acquainScore() {
        List<String> userFriend = userFriend();
    }

    List<String> userFriend() {
        List<String> userFriend = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                userFriend.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                userFriend.add(friends.get(i).get(0));
            }
        }

        return userFriend;
    }
}
