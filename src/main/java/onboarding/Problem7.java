package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendScore = new HashMap<>();
        List<String> friendList = new ArrayList<>();
        List<String> friendOfFriendList = new ArrayList<>();
        HashSet<String> people = new HashSet<>();

        //유저의 친구 목록, 전체 사람 목록
        for (List<String> list : friends) {
            people.addAll(list);
            if (list.contains(user)) {
                if (list.get(0) == user) {
                    friendList.add(list.get(1));
                } else friendList.add(list.get(0));
            }
        }
        people.remove(user);

        //유저의 타임라인에 방문한 사람 목록, 전체 사람 목록
        people.addAll(visitors);


        //set -> map
        for (String name : people) {
            friendScore.put(name, 0);
        }


        for (List<String> list : friends) {
            if (list.contains(user))
                continue;
            //다른 유저의 친구 관계에 유저의 친구가 포함되어 있다면 점수 +10
            for (String name: friendList) {
                if (list.contains(name)) {
                    String friendOfFriend;
                    if (friendList.contains(list.get(0))) {
                        friendOfFriend = list.get(1);
                    } else {
                        friendOfFriend = list.get(0);
                    }
                    int score = friendScore.get(friendOfFriend);
                    score += 10;
                    friendScore.put(friendOfFriend, score);
                }
            }
        }

        for (String visitor : visitors) {
            int score = friendScore.get(visitor);
            score += 1;
            friendScore.put(visitor, score);
        }


        return answer;
    }

    public static void main(String args[]) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(Problem7.solution(user, friends, visitors));
    }
}
