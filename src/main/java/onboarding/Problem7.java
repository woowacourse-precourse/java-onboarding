package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Problem7 pro = new Problem7();

    private static Map<String, Integer> mysteryFriend = new HashMap<>(); // 중복 값 처리를 위해 추천 친구 목록 HashMap 선언
    private static List<String> myFriend;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        myFriend = pro.getMyFriendList(user, friends); // user 의 친구 목록 생성

        // 친구의 친구면 score +10
        for (int i = 0; i < friends.size(); i++) {
            pro.friendToFriend(user, friends.get(i));
        }


        // 타임라인에 방문한 유저이면 score +1
        for (int i = 0; i < visitors.size(); i++) {
            pro.timeLineVisitor(visitors.get(i));
        }

        // 점수에 따라 정렬한 추천 친구 리스트를 만든다
        List<String> finalCheckList = pro.sortMysteryList();

        // 최대 5명의 추천 친구 리스트를 만들어 answer 에 넣는다.
        for (int i = 0; i < finalCheckList.size(); i++) {
            if (answer.size() <= 5) {
                answer.add(finalCheckList.get(i));
            }
        }

        return answer;
    }

    // 점수에 따른 추천 친구 정렬
    private List<String> sortMysteryList() {
        return mysteryFriend.keySet().stream().sorted(
                (o1, o2) -> {
                    if (mysteryFriend.get(o1).equals(mysteryFriend.get(o2))) {
                        return o1.compareTo(o2);
                    }
                    return mysteryFriend.get(o2).compareTo(mysteryFriend.get(o1));
                }
        ).collect(Collectors.toList());
    }

    // 타임라인에 방문한 친구라면 score +1
    private void timeLineVisitor(String visitor) {
        if (!myFriend.contains(visitor)) {
            mysteryFriend.put(visitor, mysteryFriend.getOrDefault(visitor, 0) + 1);
        }
    }

    // 친구의 친구면 점수 +10
    private void friendToFriend(String user, List<String> friend) {
        String firstName = friend.get(0);
        String secondName = friend.get(1);

        // 친구 목록에 내가 있는지 조회
        if (!friend.contains(user)) {
            if (myFriend.contains(secondName) && !myFriend.contains(firstName)) {
                mysteryFriend.put(firstName, mysteryFriend.getOrDefault(secondName, 0) + 10);

            } else if (myFriend.contains(firstName) && !myFriend.contains(secondName)) {
                mysteryFriend.put(secondName, mysteryFriend.getOrDefault(firstName, 0) + 10);
            }
        }
    }


    // 나의 친구 목록을 만든다.
    private List<String> getMyFriendList(String user, List<List<String>> friends) {
        LinkedHashSet<String> myFriend = new LinkedHashSet<>();

        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                myFriend.add(friend.get(0));
            }
        }
        return new ArrayList<>(myFriend);
    }


}
