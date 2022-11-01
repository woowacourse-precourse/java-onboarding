package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = makeFriendList(user, friends);
        Map<String, Integer> scoreMap = getScore(user, friends, friendList, visitors);

        return answer;
    }

    public static List<String> makeFriendList(String user, List<List<String>> friends){
        List<String> friendList = new ArrayList<>();
        friends.stream()
                .filter(f->f.get(0).equals(user))
                .forEach(f->friendList.add(f.get(1)));
        friends.stream()
                .filter(f->f.get(1).equals(user))
                .forEach(f->friendList.add(f.get(0)));

        return friendList;
    }


    public static Map<String, Integer> getScore(String user, List<List<String>> friends, List<String> friendList, List<String> visitors){
        Map<String, Integer> scoreMap = new HashMap<>();

        //친구추천대상 Map 만들기
        friends.stream()
                .filter(f->!f.get(0).equals(user))
                .filter(f->!friendList.contains(f.get(0)))
                .forEach(f->scoreMap.putIfAbsent(f.get(0), 0));
        friends.stream()
                .filter(f->!f.get(1).equals(user))
                .filter(f->!friendList.contains(f.get(1)))
                .forEach(f->scoreMap.putIfAbsent(f.get(1), 0));
        visitors.stream()
                .filter(f->!friendList.contains(f))
                .forEach(f->scoreMap.putIfAbsent(f, 0));


        //함께 아는 친구가 있을 시 +10
        friends.stream()
                .filter(f->friendList.contains(f.get(0)))
                .filter(f->!f.get(1).equals(user))
                .forEach(f->scoreMap.put(f.get(1), scoreMap.get(f.get(1))+10));
        friends.stream()
                .filter(f->friendList.contains(f.get(1)))
                .filter(f->!f.get(0).equals(user))
                .forEach(f->scoreMap.put(f.get(0), scoreMap.get(f.get(0))+10));

        //타임라인 방문 시 +1
        visitors.stream()
                .filter(f->scoreMap.containsKey(f))
                .forEach(f->scoreMap.put(f, scoreMap.get(f)+1));

        return scoreMap;
    }

}


