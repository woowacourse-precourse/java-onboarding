package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        HashMap<String, HashSet<String>> friendsMap; // 사람들 각각의 친구 목록을 담는 변수
        Map<String, Integer> score = new HashMap<>(); // 사람들 각각의 점수를 담는 변수

        // frinesMap 만들기
        friendsMap = makeFriendsMap(friends);

        // user와 함께 아는 친구 점수
        addAcquaintanceScore(friendsMap, score, user);

        // 타임 라인 방문 점수
        addTimelineScore(visitors, score);

        // score 정렬을 위해 score를 List로 변환
        List<Map.Entry<String, Integer>> listScore = new ArrayList<>(score.entrySet());

        // listScore를 정렬한 후 3명 리턴
        answer = sortListScore(listScore);
        return answer;
    }

    private static HashMap<String, HashSet<String>> makeFriendsMap(List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendsMap = new HashMap<>();

        for(List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            // firstFriend의 친구 리스트에 secondFriend 추가
            addInFriendsMap(friendsMap, firstFriend, secondFriend);
            // secondFriend의 친구 리스트에 firstFriend 추가
            addInFriendsMap(friendsMap, secondFriend, firstFriend);
        }

        return friendsMap;
    }

    private static void addInFriendsMap(HashMap<String, HashSet<String>> friendsMap,
                                        String personA, String friendOfPersonA) {
        if (!friendsMap.containsKey(personA))
            friendsMap.put(personA, new HashSet<>());
        friendsMap.get(personA).add(friendOfPersonA);
    }

    private static void addAcquaintanceScore(HashMap<String, HashSet<String>> friendsMap,
                                             Map<String, Integer> score,
                                             String user) {
        // friendsOfUser: user의 친구 목록을 담는 변수
        HashSet<String> friendsOfUser = friendsMap.get(user);

        // person: user를 제외한 다른 사람들 중 한 명
        for(String person : friendsMap.keySet()) {
            // friendsOfOtherPerson: person의 친구 목록을 담는 변수
            HashSet<String> friendsOfPerson = friendsMap.get(person);

            // user에 대한 점수는 계산하지 않아도 됨
            if(person.equals(user)) continue;
            // person이 user와 아는 사이라면 점수를 계산하지 않음
            if(friendsOfPerson.contains(user))
                continue;

            // person과 user가 함께 아는 사람을 구한 후 점수 계산
            friendsOfPerson.retainAll(friendsOfUser);
            score.put(person, friendsOfPerson.size() * 10);
        }
    }

    private static void addTimelineScore(List<String> visitors, Map<String, Integer> score) {
        for(String visitor : visitors) {
            if(score.containsKey(visitor))
                score.put(visitor, score.get(visitor) + 1);
            else score.put(visitor, 1);
        }
    }

    private static List<String> sortListScore(List<Map.Entry<String, Integer>> listScore) {
        List<String> answer = new ArrayList<>();

        listScore.sort((obj1, obj2) -> {
            // value 기준 내림차순 정렬, 값이 같으면 key 기준 오름차순 정렬
            if (!obj2.getValue().equals(obj1.getValue()))
                return obj2.getValue().compareTo(obj1.getValue());
            else return obj1.getKey().compareTo(obj2.getKey());
        });

        // answer 구하기
        for(int i = 0; i < listScore.size() && i < 3; i++)
            answer.add(listScore.get(i).getKey());

        return answer;
    }
}