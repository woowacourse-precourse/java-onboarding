package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {
    private Map<String, User> database = new HashMap<>();
    private List<String> visitLogs;

    public Database(List<String> visitLogs) {
        this.visitLogs = visitLogs;
    }

    private void addUser(String name) {
        database.put(name, new User(name));
    }

    public User findByName(String name) {
        return database.get(name);
    }

    public void registerUsersFromLog(List<String> logs) {
        for (var name : logs)
            if (!database.containsKey(name)) addUser(name);
    }

    public void addRelation(List<String> relation) {
        for (var name : relation)
            if (!database.containsKey(name)) addUser(name);
        User user1 = findByName(relation.get(0));
        User user2 = findByName(relation.get(1));
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    private void calculateScoreByTargetName(String name) {
        User user = findByName(name);
        for (var entry : database.entrySet()) {
            entry.getValue().resetScore();
            if (entry.getKey() == name) continue;
            User otherUser = entry.getValue();
            otherUser.calculateFriendsScore(user);
        }
        for (var log : visitLogs) {
            if (database.containsKey(log)) database.get(log).addScore();
        }
    }

    public List<User> getRecommendedUsersByName(String name) {
        User target = findByName(name);
        calculateScoreByTargetName(name);
        List<User> users = new ArrayList<>();
        for (var userEntry : database.entrySet()) {
            User user = userEntry.getValue();
            if (user == target || user.isScoreZero() || user.isFriend(target)) continue;
            users.add(user);
        }
        return users;
    }

}
