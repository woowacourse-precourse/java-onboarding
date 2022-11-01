package onboarding;

import java.util.*;
import java.util.Comparator;

public class Problem7 {

    private static HashSet<String> peopleList(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> people = new HashSet<>();
        //유저의 타임라인에 방문한 사람, 전체 친구목록 put
        people.addAll(visitors);
        for (List<String> list : friends) {
            people.addAll(list);
        }
        return people;
    }


    //유저의 친구 목록
    private static List<String> makeFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> list : friends) {
            if (list.contains(user)) {
                String friend = anotherPerson(list, user);
                friendList.add(friend);
            }
        }
        return friendList;
    }

    private static String anotherPerson(List<String> list, String person) {
        String another;
        if (list.get(0) == person) {
            another = list.get(1);
        } else {
            another = list.get(0);
        }
        return another;
    }

    //친구들의 친구 목록에 있는 유저들의 점수 +10
    private static HashMap<String, Integer> friendOfFriendScore(List<String> friendOfFriendList,
                                                                HashMap<String, Integer> friendScore) {
        for (String friendOfFriend : friendOfFriendList) {
            int score = friendScore.get(friendOfFriend);
            score += 10;
            friendScore.put(friendOfFriend, score);
        }
        return friendScore;
    }

    //visitor 점수 +1
    private static HashMap<String, Integer> visitorScore(List<String> visitors,
                                                         HashMap<String, Integer> friendScore) {
        for (String visitor : visitors) {
            int score = friendScore.get(visitor);
            score += 1;
            friendScore.put(visitor, score);
        }
        return friendScore;
    }

    //이름으로 정렬 -> 점수로 정렬 후 유저와 친구가 아닌 사람만 answer에 추가.
    private static List<String> sortAnswer(HashMap<String, Integer> friendScore,
                                           List<String> friendList) {
        List<String> answer = new ArrayList<>();
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

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendScore = new HashMap<>();

        HashSet<String> people = peopleList(user, friends, visitors);
        List<String> friendList = makeFriendList(user, friends);

        //전체 사람 목록 set -> map
        for (String name : people) {
            friendScore.put(name, 0);
        }

        //다른 유저의 친구 관계에 유저의 친구가 포함되어 있다면 점수 +10
        for (String name : friendList) {
            List<String> friendOfFriendList = makeFriendList(name, friends);
            friendScore = friendOfFriendScore(friendOfFriendList, friendScore);
        }

        //visitor 점수 계산
        friendScore = visitorScore(visitors, friendScore);

        friendScore.remove(user);

        answer = sortAnswer(friendScore, friendList);
        return answer;
    }
}