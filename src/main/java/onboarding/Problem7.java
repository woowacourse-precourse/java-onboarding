package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> getUsers(List<List<String>> friends) {
        Stream<String> flattenUserStream = friends.stream().flatMap(Collection::stream);
        List<String> userList = flattenUserStream
                                        .distinct()
                                        .collect(Collectors.toList());
        return userList;
    }

    static int getScore(String user, String anotherUser,
                        List<List<String>> friends, List<String> visitors){
        int friendScore = getSameFriendsCnt(user, anotherUser, friends) * 10;
        int visitScore = getVisitCnt(visitors, anotherUser);
        int totalScore = friendScore + visitScore;

        return totalScore;
    }

    static int getSameFriendsCnt(String user, String anotherUser, List<List<String>> friends){
        int sameFriendCnt = 0;
        List<String> userFriends = getFriends(user, friends);
        List<String> anotherUserFriends = getFriends(anotherUser, friends);

        Stream<String> sameFriendStream = userFriends.stream().filter(friend -> anotherUserFriends.contains(friend));
        sameFriendCnt = (int) sameFriendStream.count();

        return sameFriendCnt;
    }

    static List<String> getFriends(String user, List<List<String>> friends){
        Stream<List<String>> userContainedStream = friends.stream().filter(item -> item.contains(user));
        Stream<String> friendStream = userContainedStream.map(item -> item.get((item.indexOf(user) + 1) % 2));
        List<String> friendList = friendStream.collect(Collectors.toList());

        return friendList;
    }

    static int getVisitCnt(List<String> visitors, String visitor){
        return Collections.frequency(visitors, visitor);
    }
}
