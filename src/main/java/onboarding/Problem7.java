package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> allUserList = getUsers(friends);
        System.out.println(allUserList);
        List<String> userFriendList = getFriends(user, friends);
        Stream<String> notUserFriendStream = allUserList.stream().filter(id -> !userFriendList.contains(id) && !id.equals(user));
        //notUserFriendStream.forEach(item -> System.out.println(item));

        List<List<String>> userScore = new ArrayList<>();

        for (String id : notUserFriendStream.collect(Collectors.toList())){
            int score = getScore(user, id, friends, visitors);
            List<String> newElement = List.of(id, String.valueOf(score));
            userScore.add(newElement);
            System.out.println(userScore);
        }

        Comparator<List<String>> compareFriends = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int score1 = Integer.parseInt(o1.get(1));
                int score2 = Integer.parseInt(o2.get(1));
                int result = 1;

                if (score1 < score2) {
                    result = -1;
                } else if (score1 == score2) {
                    result = o2.get(0).compareTo(o1.get(0));
                }

                return result;
            }
        };

        Collections.sort(userScore, compareFriends.reversed());
        System.out.println(userScore);
        if (userScore.size() >= 5){
            userScore = userScore.subList(0, 5);
        }

        answer = userScore.stream()
                .map(entry -> entry.get(0))
                .collect(Collectors.toList());

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
