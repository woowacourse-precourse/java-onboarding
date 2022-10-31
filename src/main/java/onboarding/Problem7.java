package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // friends에 저장되어 있는 각각의 유저마다 친구 목록을 저장하는 HashMap (key : username / value : 친구 목록(List<String>))
        HashMap<String, HashSet<String>> friendLists = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            // 친구 목록에 추가
            // (서로가 서로의 친구 목록에 각각 저장되어야 하기 때문에 인자의 위치를 바꿔서 함수를 2번 호출)
            setFriendList(friendLists, friend1, friend2);
            setFriendList(friendLists, friend2, friend1);
        }

        // 전체 유저 목록 (List)
        HashSet<String> totalUserList = getTotalUserList(friendLists, visitors);

        // 각 유저별 점수를 저장하는 HashMap (key : username / value : 점수 (전부 0으로 초기화))
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (String account : totalUserList) {
            scoreMap.put(account, 0); // 0으로 초기화
        }

        // 각각의 유저에 대한 점수 계산
        // 1. 사용자와 함께 아는 친구의 수 = 10점
        // 2. 사용자의 타임 라인에 방문한 횟수 = 1점

        // 점수가 가장 높은 순으로 정렬하여 최대 5명을 뽑음
        // 유의사항
        // 1. 이미 user의 친구인 경우에는 추천하지 않음
        // 2. 추천 점수가 0점인 경우 추천하지 않음
        // 3. 추천 점수가 같은 경우는 이름순으로 오름차순 정렬

        return answer;
    }

    // friend2를 friend1의 친구 목록에 저장하는 함수
    private static void setFriendList(HashMap<String, HashSet<String>> friendLists, String friend1, String friend2) {
        // friend1의 친구 목록이 friendLists에 이미 생성되어 있는 경우
        if (friendLists.containsKey(friend1)) {
            HashSet<String> friend1List = friendLists.get(friend1); // 기존 저장되어 있던 friend1의 친구 목록
            friend1List.add(friend2); // 친구 목록에 friend2 추가
            friendLists.replace(friend1, friend1List);
        }
        // friend1의 친구 목록이 friendLists에 생성되어 있지 않은 경우
        if (!friendLists.containsKey(friend1)) {
            friendLists.put(friend1, new HashSet<>(List.of(friend2))); // 친구 목록 생성
        }
    }

    // 전체 유저 목록을 반환하는 함수
    private static HashSet<String> getTotalUserList(HashMap<String, HashSet<String>> friendLists, List<String> visitors) {
        HashSet<String> totalUserList = new HashSet<>(friendLists.keySet()); // friends에 들어있는 유저는 전부 List에 넣기

        // friends에 들어있지 않으며, visitors에만 들어있는 유저를 List에 추가
        for (String visitor : visitors) {
            if (!friendLists.containsKey(visitor)) { // friends에 들어있지 않았던 경우 = friendLists에서 같은 이름의 key가 존재하지 않는 경우
                totalUserList.add(visitor);
            }
        }

        return totalUserList;
    }

}
