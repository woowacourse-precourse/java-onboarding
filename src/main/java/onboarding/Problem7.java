package onboarding;

import java.util.*;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendScore = new HashMap<>();
        List<String> friendList = new ArrayList<>();
        List<String> friendOfFriendList = new ArrayList<>();
        HashSet<String> people = new HashSet<>();

        //유저의 타임라인에 방문한 사람 목록을 전체 사람 목록에 put
        people.addAll(visitors);

        //유저의 친구 목록 계산, 전체 사람 목록에 중복되는 사람과 유저 본인 제거해서 계산
        for (List<String> list : friends) {
            people.addAll(list);
            if (list.contains(user)) {
                if (list.get(0) == user) {
                    friendList.add(list.get(1));
                } else friendList.add(list.get(0));
            }
        }
        people.remove(user);

        //전체 사람 목록 set -> map
        for (String name : people) {
            friendScore.put(name, 0);
        }

        //다른 유저의 친구 관계에 유저의 친구가 포함되어 있다면 점수 +10
        for (List<String> list : friends) {
            if (list.contains(user))
                continue;
            //전체 친구 관계를 돌아보며 유저의 친구가 포함되어 있는지 확인
            for (String name : friendList) {
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

        //visitor 점수 계산
        for (String visitor : visitors) {
            int score = friendScore.get(visitor);
            score += 1;
            friendScore.put(visitor, score);
        }

        //이름으로 정렬 -> 점수로 정렬 후 유저와 친구가 아닌 사람만 answer에 추가.
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScore.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : entryList) {
            if (entry.getValue() != 0 && !friendList.contains(entry.getKey()))
                answer.add(entry.getKey());
        }

        if (answer.size() > 5)
            answer = answer.subList(0, 4);

        return answer;
    }
}
