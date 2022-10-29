package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    static List<Friend> friends_list;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> findUserFriends(String user, List<List<String>> friends){
        List<String> user_friends = Stream.of(friends).flatMap(List::stream)
                .filter(i->i.contains(user))
                .flatMap(List::stream)
                .filter(i -> !i.equals(user))
                .collect(Collectors.toList());
        return user_friends;
    }

    static List<String> findFriendsOfFriend(List<String> user_friends, List<List<String>> friends){
        List<String> user_unknown_friends;
        user_unknown_friends = Stream.of(friends).flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        user_unknown_friends.removeAll(user_friends);
        // user 는 지워지지 않아 나중에 solution 메서드에서 지워야한다.
        return user_unknown_friends;
    }

    static boolean addPointToFriendObject(String name, int point){
        for(Friend friendObject:friends_list){
            if (friendObject.getName().equals(name)) {
                friendObject.addPoint(point);
                return true;
            }
        }
        return false;
    }

    static void friendPointCalculate(List<String> user_unknown_friends){
        final int FRIENDSPOINT = 10;

        for(String name:user_unknown_friends){
            if(!addPointToFriendObject(name, FRIENDSPOINT)){
                friends_list.add(new Friend(name, FRIENDSPOINT));
            }
        }
    }

    static void visitorPointCalculate(List<String> visitors){
        final int VISITPOINT = 1;

        for(String name:visitors){
            if(!addPointToFriendObject(name, VISITPOINT)){
                friends_list.add((new Friend(name, VISITPOINT)));
            }
        }
    }
    static List<String> findTopFive(List<Friend> friends_list){
        List<String> top_five;

        top_five = friends_list.stream().sorted(Comparator.comparing(Friend::getPoint).reversed()
                .thenComparing(Friend::getName))
                .limit(5)
                .map(Friend::getName)
                .collect(Collectors.toList());
        return top_five;
    }
}

class Friend{
    String name;
    int point = 0;

    Friend(String name){
        this.name = name;
    }
    Friend(String name, int point){
        this.name = name;
        this.point = point;
    }
    int getPoint() {
        return this.point;
    }
    String getName(){return this.name;}
    void addPoint(int addpoint){
        point += addpoint;
    }
}
