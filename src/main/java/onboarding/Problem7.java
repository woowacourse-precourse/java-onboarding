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
