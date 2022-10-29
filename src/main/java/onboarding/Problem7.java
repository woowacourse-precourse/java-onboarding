package onboarding;

import java.util.*;
import java.util.stream.Collectors;


class User{

    private String name;
    private int score = 0;

    public int getScore() {
        return score;
    }

    public boolean isScoreZero(){return score == 0;}
    public String getName() {
        return name;
    }
    public void resetScore(){score = 0;}

    private List<User> friends = new ArrayList<>();

    public void addScore(){score++;}
    public User(String name) {
        this.name = name;
    }

    public void addFriend(User user){
        friends.add(user);
    }
    public void calculateFriendsScore(User user){
        score += countContainedFriends(user)*10;
    }
    private int countContainedFriends(User src){
        int count = 0;
        for(var srcFriend: src.friends)
            if(this.friends.contains(srcFriend))count++;
        return count;
    }

    public boolean isFriend(User user){
        return friends.contains(user);
    }
}

class Database{
    private Map<String, User> database = new HashMap<>();
    private List<String> visitLogs;

    public Database(List<String> visitLogs) {
        this.visitLogs = visitLogs;
    }

    private void addUser(String name){
        database.put(name, new User(name));
    }
    public User findByName(String name){
        return database.get(name);
    }

    public void registerUsersFromLog(List<String> logs){
        for(var name: logs)
            if(!database.containsKey(name))database.put(name, new User(name));
    }

    public void addRelation(List<String> relation){
        for(var name: relation)
            if(!database.containsKey(name))addUser(name);
        for(int i = 0; i < 2; i++){
            User user1 = findByName(relation.get(0));
            User user2 = findByName(relation.get(1));
            user1.addFriend(user2);
            user2.addFriend(user1);
        }
    }

    private void calculateScoreByTargetName(String name){
        User user = findByName(name);
        for(var entry: database.entrySet()){
            entry.getValue().resetScore();
            if(entry.getKey() == name)continue;
            User otherUser = entry.getValue();
            otherUser.calculateFriendsScore(user);
        }
        for(var log: visitLogs){
            if(database.containsKey(log))database.get(log).addScore();
        }
    }

    public List<User> getRecommendedUsersByName(String name){
        User target = findByName(name);
        calculateScoreByTargetName(name);
        List<User> users = new ArrayList<>();
        for(var userEntry: database.entrySet()){
            User user = userEntry.getValue();
            if(user == target || user.isScoreZero() || user.isFriend(target) )continue;
           users.add(user);
        }
        return users;
    }

}
class SNS{

    private Database database;
    public SNS(List<List<String>> friends, List<String> visitors){
        database = new Database(visitors);
        for(var relation: friends){
            database.addRelation(relation);
        }
        database.registerUsersFromLog(visitors);
    }
    public List<String> recommendFriends(String name){
        return database.getRecommendedUsersByName(name).stream().map(user->user.getName()).collect(Collectors.toList());
    }

}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SNS sns = new SNS(friends, visitors);
        return sns.recommendFriends(user);
    }
}
