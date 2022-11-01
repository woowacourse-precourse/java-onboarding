package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
* 1. 크루의 이름, 친구 이름 List, List<Suggestion> 을 필드로 가지는 Crew class 생성
*   1-1. Crew(String name): 파라미터로 이름을 받는 생성자
*   1-2. getSuggestions(): suggestion List 를 반환하는 메소드
*   1-3. getKnowEachOtherFriends(Crew crew): Crew 를 파라미터로 받아 현재 크루와 서로 아는 친구의 List 를 반환
*   1-4. isFriend(String name): 해당 name 을 가진 크루와의 친구관계 여부를 확인하는 메소드
* 2. 크루 이름과 추천 점수를 필드로 가지는 Suggestion class 생성
*   2-1. Suggestion(String name): Crew 를 파라미터로 받는 생성자
*   2-2. calculateScore(Map<>, List<>): 친구 map 과 방문기록 list 를 파라미터로 받아 추천 Crew 의 점수를 계산하는 메소드
*   2-3. getScore(): 해당 추천인에 대한 점수를 가져오는 메소드
* 3. 친구 관계 정보를 바탕으로 crew 의 이름을 key, Crew class 를 value 로 가지는 Map 생성
*   3-1. 친구인 크루의 이름을 Crew class 의 List<String> 필드에 저장
* 4. map 의 keySet 중에서 user 와 친구가 아닌 크루들을 List<Suggestion> 필드에 추가하며 점수를 계산
* 5. List<Suggestion> 에서 점수가 0 보다 크고, 이름순으로 정렬을 하여 최대 5명의 crew 의 이름을 반환
*/

class Suggestion {
    private int score;
    private String name;

    public Suggestion(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }

    public void calculateScore(Crew user, Map<String, Crew> friends, List<String> visitors) {
        score += user.getKnowEachOtherFriends(friends.get(name)).size() * 10;
        score += visitors.stream()
                .filter(crew -> crew.equals(name))
                .count();
    }
}

class Crew {
    private List<String> friends;
    private List<Suggestion> suggestions;

    public Crew() {
        friends = new ArrayList<>();
        suggestions = new ArrayList<>();
    }

    public List<String> getFriends() {
        return friends;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void addSuggestion(String crew, Map<String, Crew> friends, List<String> visitors) {
        Suggestion suggestion = new Suggestion(crew);
        suggestion.calculateScore(this, friends, visitors);
        suggestions.add(suggestion);
    }

    public boolean isFriend(String name) {
        return friends.contains(name);
    }

    public List<String> getKnowEachOtherFriends(Crew crew) {
        return friends.stream()
                .filter(friend -> crew.friends.contains(friend))
                .collect(Collectors.toList());
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Crew> friendsMap = initFriendsMap(user, friends, visitors);

        Crew currentUser = friendsMap.get(user);

        friendsMap.keySet().stream()
                .filter(crew -> !crew.equals(user) && !currentUser.isFriend(crew))
                .forEach(crew -> currentUser.addSuggestion(crew, friendsMap, visitors));

        return currentUser.getSuggestions().stream()
                .filter(suggestion -> suggestion.getScore() > 0)
                .sorted(Comparator.comparing(Suggestion::getScore, Comparator.reverseOrder())
                        .thenComparing(Suggestion::getName))
                .limit(5)
                .map(Suggestion::getName)
                .collect(Collectors.toList());
    }

    private static Map<String, Crew> initFriendsMap(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Crew> friendsMap = new HashMap<>();

        friendsMap.put(user, new Crew());

        for (List<String> friend : friends) {
            String crewA = friend.get(0);
            String crewB = friend.get(1);

            if (!friendsMap.containsKey(crewA)) {
                friendsMap.put(crewA, new Crew());
            }
            if (!friendsMap.containsKey(crewB)) {
                friendsMap.put(crewB, new Crew());
            }
            friendsMap.get(crewA).getFriends().add(crewB);
            friendsMap.get(crewB).getFriends().add(crewA);
        }

        visitors.stream()
                .filter(visitor -> !friendsMap.containsKey(visitor))
                .forEach(visitor -> friendsMap.put(visitor, new Crew()));

        return friendsMap;
    }
}
