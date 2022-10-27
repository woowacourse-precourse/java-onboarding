package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends,
                                        List<String> visitors) {

        //친구 목록 맵
        Map<String, List<String>> friendsMap = createFriendList(friends);

        //추천 친구 점수 맵
        Map<String, Integer> scoreMap = new HashMap<>();

        // 함께 아는 친구 점수 추가
        friendsMap.get(user)
                .forEach(friend -> friendsMap.get(friend).stream()
                        .filter(s -> checkFriends(user,s,friendsMap))
                        .forEach(s -> addScore(scoreMap,10,s)));

        // 타임 라인 방문한 횟수 점수 추가
        visitors.stream()
                .filter(s -> checkFriends(user,s,friendsMap))
                .forEach(s -> addScore(scoreMap, 1, s));

        //점수 맵의 키를 리스트로 변환
        List<String> answer = new ArrayList<>(scoreMap.keySet());

        //점수 순으로 정렬 - 점수가 같을 경우 이름순으로 정렬
        answer.sort((o1, o2) ->  {
                if(scoreMap.get(o1).equals(scoreMap.get(o2))) return o1.compareTo(o2);
                return scoreMap.get(o2) - scoreMap.get(o1);
        });

        //추천 친구목록이 5명 초과일 때 상위 5명으로 자름
        if(answer.size()>5) answer = answer.subList(0,5);

        return answer;
    }

    // 친구 목록 생성 메소드
    private static Map<String, List<String>> createFriendList(List<List<String>> friends) {

        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends) {
            //친구1
            String human1 = friend.get(0);
            //친구2
            String human2 = friend.get(1);

            // 친구1 의 친구2 추가
            friendsMap.put(human1, addFriend(friendsMap,human1,human2));

            // 친구2 의 친구1 추가
            friendsMap.put(human2, addFriend(friendsMap,human2,human1));
        }

        return friendsMap;
    }

    // 친구 추가 메소드
    private static List<String> addFriend(Map<String, List<String>> friendsMap,
                                  String human1, String human2) {

        List<String> list = new ArrayList<>();
        if(friendsMap.get(human1) != null) list = friendsMap.get(human1);
        list.add(human2);

        return list;
    }

    // 점수 추가 메소드
    private static void addScore( Map<String, Integer> scoreMap,
                                                  int n, String recommend) {

        int score = 0;
        if(scoreMap.get(recommend) != null) score = scoreMap.get(recommend);
        scoreMap.put(recommend, score+n);

    }

    // 본인 or 이미 친구인 경우 확인하는 메소드
    private static boolean checkFriends(String user, String people,
                                        Map<String, List<String>> friendsMap ) {
        // 본인일 경우
        if(people.equals(user)) return false;

        // 이미 친구일 경우
        return !friendsMap.get(user).contains(people);
    }

}
