package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;

class User implements Comparable<User>{
    private String name;
    private int score;
    private HashSet<User> friends;

    public User(String name){
        this.name = name;
        this.score = 0;
        this.friends = new HashSet<>();
    }

    public void addFriend(User newFriend){
        this.friends.add(newFriend);
    }

    public void addScore(int amount){
        this.score += amount;
    }

    public void addScoreToFriends(int amount){
        for(User friend : this.friends){
            friend.addScore(amount);
        }
    }

    public void addScoreToMutualFriends(int amount){
        for(User friend : this.friends){
            friend.addScoreToFriends(amount);
        }
    }

    public boolean isNotFriendWith(User user){
        return !this.friends.contains(user);
    }

    public boolean isScoreLargerThanZero(){
        return this.score > 0;
    }
    public void addNameToList(List<String> nameList){
        nameList.add(this.name);
    }

    @Override
    public int compareTo(User otherUser){ //if thisFriend > otherFriend return 1
        if(otherUser.isScoreEqual(this.score)){
            return otherUser.compareName(this.name) * -1;
        }
        if(otherUser.isScoreLarger(this.score)){
            return -1;
        }
        return 1;
    }

    public boolean isScoreLarger(int otherScore){
        return this.score > otherScore;
    }

    public boolean isScoreEqual(int otherScore){
        return this.score == otherScore;
    }

    public int compareName(String otherName){
        return otherName.compareTo(this.name);
    }
}
public class Problem7 {
    public static final int VISIT_SCORE = 1;
    public static final int MUTUAL_FRIEND_SCORE = 10;
    public static final int MAX_ANSWER_LIST_SIZE = 5;
    public static final HashMap<String, User> USER_MAP = new HashMap<>();

    public static void processFriendsList(List<List<String>> friends){
        for(List<String> friendPair : friends){
            String name1 = friendPair.get(0);
            String name2 = friendPair.get(1);
            User user1 = getUserFromName(name1);
            User user2 = getUserFromName(name2);
            makeFriend(user1, user2);
        }
    }

    public static User getUserFromName(String name){
        if(USER_MAP.containsKey(name)){
            return USER_MAP.get(name);
        }
        return createNewUser(name);
    }

    public static User createNewUser(String name){
        User newUser = new User(name);
        USER_MAP.put(name, newUser);
        return newUser;
    }

    public static void makeFriend(User user1, User user2){
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public static void calculateScore(String targetUserName, List<String> visitors){
        User targetUser = USER_MAP.get(targetUserName);
        processVisitorsList(visitors);
        targetUser.addScoreToMutualFriends(MUTUAL_FRIEND_SCORE);
    }

    public static void processVisitorsList(List<String> visitors){
        for(String visitorName : visitors){
            User visitor = getUserFromName(visitorName);
            visitor.addScore(VISIT_SCORE);
        }
    }

    public static List<String> getListOfTopUserName(String targetUser){
        List<User> userList = getListOfUsersNotFriendWithTarget(targetUser);
        List<String> topUserList = new LinkedList<>();
        userList.sort(Collections.reverseOrder());
        int sizeOfList = Math.min(userList.size(), MAX_ANSWER_LIST_SIZE);
        for(int i = 0; i < sizeOfList; i++){
            User topUser = userList.get(i);
            topUser.addNameToList(topUserList);
        }
        return topUserList;
    }

    public static List<User> getListOfUsersNotFriendWithTarget(String targetUserName){
        List<User> userList = new LinkedList<>();
        User targetUser = getUserFromName(targetUserName);
        for(User user : USER_MAP.values()){
            addNotFriendUserToList(userList, targetUser, user);
        }
        return userList;
    }

    public static void addNotFriendUserToList(List<User> userList, User targetUser, User newUser){
        if(targetUser != newUser && targetUser.isNotFriendWith(newUser) && newUser.isScoreLargerThanZero()){
            userList.add(newUser);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        processFriendsList(friends);
        calculateScore(user, visitors);
        answer = getListOfTopUserName(user);
        return answer;
    }
}
