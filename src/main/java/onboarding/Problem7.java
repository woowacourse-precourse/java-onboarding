package onboarding;

import java.util.*;

/*
기능 목록
1. 두 사람 중 user와 친구인 다른 사람의 이름을 반환하는 기능
2. 입력받은 List를 확인하며 친구목록 리스트에 추가하거나 그래프에 추가하는 기능
3. 점수를 계산하는 기능
4. 친구 그래프를 탐색하며 서로 아는 친구라면 추천 점수를 계산하는 기능
5. 방문자 리스트를 확인하며 방문 점수를 계산하는 기능
6. 문제의 기능 요구사항에 맞게 리스트를 정렬하는 기능
 */
public class Problem7 {
    public static Map<String, Integer> relation = new HashMap<>();
    public static List<String> friendList = new ArrayList<>();
    public static List<List<String>> friendGraph = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for (List<String> friend : friends) {
            checkContain(friend, user);
        }

        for (String myFriend : friendList) {
            search(myFriend);
        }

        for (String visitor : visitors) {
            boolean isContain = friendList.contains(visitor);
            calculateVisitorPoint(isContain, visitor);
        }

        answer = sort();
        return answer;
    }

    //user가 입력받은 List에 속해있는지 확인하는 함수
    public static void checkContain(List<String> friend, String user) {
        boolean isContain = friend.contains(user);
        contains(isContain, friend, user);
        notContains(isContain, friend, user);
    }

    //user가 입력받은 List에 속해있는 경우 친구목록 리스트에 추가하는 함수
    public static void contains(boolean isContain, List<String> friend, String user) {
        if (isContain) {
            friendList.add(findAnother(friend, user));
        }
    }

    //user가 입력받은 List에 속하지 않은 경우 그래프에 추가하는 함수
    public static void notContains(boolean isContain, List<String> friend, String user) {
        if (!isContain) {
            friendGraph.add(friend);
        }
    }

    //친구 그래프를 탐색하는 함수
    public static void search(String name) {
        for (List<String> friend : friendGraph) {
            boolean isContain = friend.contains(name);
            afterSearch(isContain, friend, name);
        }
    }

    //만약 친구 그래프 탐색 결과 서로 아는 친구라면 점수 계산
    public static void afterSearch(boolean isContain, List<String> friend, String name) {
        if (isContain) {
            String friendName = findAnother(friend, name);
            calculatePoint(friendName, 10);
        }
    }

    //추천 점수를 계산하는 함수
    public static void calculatePoint(String user, int point) {
        if (relation.containsKey(user))
            relation.put(user, relation.get(user) + 10);
        else
            relation.put(user, 10);
    }

    //방문 점수를 계산하는 함수
    public static void calculateVisitorPoint(boolean isContain, String visitor) {
        if (!isContain) {
            calculatePoint(visitor, 1);
        }
    }

    //두 사람 중 user와 친구인 다름 사람의 이름을 반환하는 함수
    public static String findAnother(List<String> twoPeople, String user) {
        if (twoPeople.get(0).equals(user))
            return twoPeople.get(1);
        else
            return twoPeople.get(0);
    }

    //문제의 기능 요구사항에 맞게 리스트를 정렬하는 함수
    public static List<String> sort() {
        List<String> result = new ArrayList<>(relation.keySet());
        Collections.sort(result, (s1, s2) -> relation.get(s1).compareTo(relation.get(s2)));
        if (result.size() > 5) {
            result.subList(0, 5);
        }
        return result;
    }
}