package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    /*
   기능 목록
   1. user의 친구목록을 set을 이용해 담는다.
   2. set에 존재하지 않는 사람들을 HashMap에 점수 0으로 담는다.
   3. List<List<String>>에서 Map에 존재하며 관계에 얽여있는 사람이 set에 있는 경우 10점을 추가해준다.
   4. 방문자 리스트에서 set에 존재 하지 않는 이름을 추가하고, 한 번 있을 때 마다 1점씩 추가한다.
   5. HashMap을 점수의 역순, 이름의 정순으로 정렬한 후, 이름만 리턴한다.
   */

    private static final int SCORE_FOR_FRIEND = 10;
    private static final int SCORE_FOR_VISIT = 1;
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;

    private static Set<String> usersFriend = new HashSet<>();
    private static Map<String, Integer> scoreToUser = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> sortNameByScore(){
        return scoreToUser.entrySet().stream()
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
