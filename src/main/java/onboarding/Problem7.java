package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
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

    static List<String> findFriendsOfFriend (List<String> user_friends, List<List<String>> friends){
        List<String> user_unknown_friends;
        user_unknown_friends = Stream.of(friends).flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        user_unknown_friends.removeAll(user_friends);
        // user 는 지워지지 않아 나중에 solution 메서드에서 지워야한다.
        return user_unknown_friends;
    }
}
class Friend{
    String name;
    int point = 0;

    Friend(String name){
        this.name = name;
    }
    int getPoint() {
        return this.point;
    }
    void addPoint(int addpoint){
        point += addpoint;
    }
}
