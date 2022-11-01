package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int SCORE_FOR_FRIEND = 10;
    private static final int SCORE_FOR_VISIT = 1;
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;
    private static final int USERNAME_LENGTH_MINIMUM = 1;
    private static final int USERNAME_LENGTH_MAXIMUM = 30;
    private static final int FRIENDS_SIZE_MINIMUM = 1;
    private static final int FRIENDSHIP_SIZE = 2;
    private static final int FRIENDS_SIZE_MAXIMUM = 10000;
    private static final int VISITORS_SIZE_LIMIT = 10000;
    private static final String USERNAME_EMPTY_EXCEPTION = "사용자 아이디가 입력되어있지 않습니다. ";
    private static final String USERNAME_TOO_LONG_EXCEPTION = " : 사용자 아이디가 30자를 초과했습니다. ";
    private static final String USERNAME_NOT_LOWERCASE_EXCEPTION = " : 사용자 아이디가 소문자로 이루어져 있지 않습니다. ";
    private static final String FRIENDS_EMPTY_EXCEPTION = "친구 관계가 존재하지 않습니다. ";
    private static final String FRIENDS_TOO_MANY_EXCEPTION = "친구 관계의 수가 제한인 10,000개를 초과했습니다. ";
    private static final String FRIENDSHIP_SIZE_INCORRECT_EXCEPTION = ": 친구 관계는 하나에 2명의 사람이 있어야 합니다. ";
    private static final String VISITORS_TOO_MANY_EXCEPTION = "방문자의 수가 10,000명을 초과했습니다.";
    private static final Set<String> usersFriend = new HashSet<>();
    private static final Map<String, Integer> scoreToUser = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkUser(user);
        checkFriends(friends);
        checkVisitors(visitors);
        addUsersFriend(user, friends);
        createMappingIfNotFriend(friends);
        getScore(friends, visitors);
        return sortNameByScore();
    }

    private static void checkUser(String user){
        if(user.length() < USERNAME_LENGTH_MINIMUM) usernameEmptyException();
        if(user.length() > USERNAME_LENGTH_MAXIMUM) usernameTooLongException(user);
        if(!Pattern.matches("^[a-z]*$", user)) usernameNotLowerCaseException(user);
    }

    private static void usernameEmptyException(){
        throw new IllegalArgumentException(USERNAME_EMPTY_EXCEPTION);
    }

    private static void usernameTooLongException(String username){
        throw new IllegalArgumentException(username.concat(USERNAME_TOO_LONG_EXCEPTION));
    }

    private static void usernameNotLowerCaseException(String username){
        throw new IllegalArgumentException(username.concat(USERNAME_NOT_LOWERCASE_EXCEPTION));
    }

    private static void checkFriends(List<List<String>> friends){
        if(friends.size() < FRIENDS_SIZE_MINIMUM) friendsEmptyException();
        if(friends.size() > FRIENDS_SIZE_MAXIMUM) friendsTooManyException();
        for(List<String> friend : friends){
            checkFriend(friend);
        }
    }

    private static void friendsEmptyException(){
        throw new IllegalArgumentException(FRIENDS_EMPTY_EXCEPTION);
    }

    private static void friendsTooManyException(){
        throw new IllegalArgumentException(FRIENDS_TOO_MANY_EXCEPTION);
    }

    private static void checkFriend(List<String> friend){
        if(friend.size() != FRIENDSHIP_SIZE) friendshipIncorrectException(friend);
        checkUser(friend.get(LEFT_INDEX));
        checkUser(friend.get(RIGHT_INDEX));
    }

    private static void friendshipIncorrectException(List<String> friend){
        String relationStatement = getListToString(friend);
        throw new IllegalArgumentException(relationStatement.concat(FRIENDSHIP_SIZE_INCORRECT_EXCEPTION));
    }

    private static String getListToString(List<String> friend){
        String result = "";
        for(String name : friend){
            result = result.concat(name).concat(" ");
        }
        return result;
    }

    private static void checkVisitors(List<String> visitors){
        if(visitors.size() > VISITORS_SIZE_LIMIT) visitorsTooManyException();
        for(String visitor : visitors){
            checkUser(visitor);
        }
    }

    private static void visitorsTooManyException(){
        throw new IllegalArgumentException(VISITORS_TOO_MANY_EXCEPTION);
    }

    private static List<String> sortNameByScore(){
        return scoreToUser.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void getScore(List<List<String>> friends, List<String> visitors){
        makeScoresForFriendship(friends);
        getScoreOfVisitors(visitors);
        deleteZeroValueOnMap();
    }

    private static void addUsersFriend(String user, List<List<String>> friends){
        for(List<String> relation : friends){
            addFriendIfExists(user, relation);
        }
    }

    private static void deleteZeroValueOnMap(){
        for(String name : scoreToUser.keySet()){
            deleteIfZero(name);
        }
    }

    private static void deleteIfZero(String name){
        if(scoreToUser.get(name) == 0) scoreToUser.remove(name);
    }

    private static void addFriendIfExists(String user, List<String> relation){
        if(!relation.contains(user)) return;
        usersFriend.addAll(relation);
    }

    private static void createMappingIfNotFriend(List<List<String>> friends){
        for(List<String> relation : friends){
            addToMapIfNotUsersFriend(relation);
        }
    }

    private static void addToMapIfNotUsersFriend(List<String> relation){
        for(String name : relation){
            addNameIfNotUsersFriend(name);
        }
    }

    private static void addNameIfNotUsersFriend(String name){
        if(!usersFriend.contains(name)) scoreToUser.put(name, 0);
    }

    private static void makeScoresForFriendship(List<List<String>> friends){
        for(List<String> relation : friends){
            giveScoreIfNotUsersFriend(relation);
        }
    }

    private static void giveScoreIfNotUsersFriend(List<String> relation){
        if(leftIsNotFriendButRight(relation)) {
            giveScoreForFriendTo(relation.get(LEFT_INDEX));
            return;
        }
        if(rightIsNotFriendButLeft(relation)) giveScoreForFriendTo(relation.get(RIGHT_INDEX));
    }

    private static void giveScoreForFriendTo(String name){
        int oldScore = scoreToUser.get(name);
        scoreToUser.replace(name, oldScore, oldScore+SCORE_FOR_FRIEND);
    }

    private static boolean leftIsNotFriendButRight(List<String> relation){
        if(!usersFriend.contains(relation.get(LEFT_INDEX)) && usersFriend.contains(relation.get(RIGHT_INDEX)))
            return true;
        return false;
    }

    private static boolean rightIsNotFriendButLeft(List<String> relation){
        if(!usersFriend.contains(relation.get(RIGHT_INDEX)) && usersFriend.contains(relation.get(LEFT_INDEX)))
            return true;
        return false;
    }

    private static void getScoreOfVisitors(List<String> visitors){
        for(String visitor : visitors){
            giveSpaceOrScoreOnMap(visitor);
        }
    }

    private static void giveSpaceOrScoreOnMap(String visitor){
        if(usersFriend.contains(visitor)) return;
        if(!scoreToUser.containsKey(visitor)) scoreToUser.put(visitor, 0);
        int oldScore = scoreToUser.get(visitor);
        scoreToUser.replace(visitor, oldScore, oldScore + SCORE_FOR_VISIT);
    }


}
