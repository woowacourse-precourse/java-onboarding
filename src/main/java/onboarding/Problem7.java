package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem7 {
//    규칙 너무 길어서 제한사항, 요약만 기입.
//
//    제한사항
//    1. user는 길이가 1 이상 30 이하인 문자열이다.
//    2. friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
//    3. friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
//    4. A와 B는 친구라는 의미이다.
//    5. 아이디는 길이가 1 이상 30 이하인 문자열이다.
//    6. visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
//    7. 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
//    8. 동일한 친구 관계가 중복해서 주어지지 않는다.
//    9. 추천할 친구가 없는 경우는 주어지지 않는다.

    //    -- 요약 --
//    1. 방문자 점수가 가장 높은 순으로 최대 5명 return.
//      1-1 추천 점수 0점은 추천하지 않는다.
//      1-2 점수가 같으면 이름순으로 정렬한다.
//    2. 점수
//      2-1 사용자와 함께 아는 친구의 수 = 10점
//      2-2 사용자의 타임 라인에 방문한 횟수 = 1점
//


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//      1. 우선 user를 받아오자.
//      2. user 정보를 해석하고 계산하는 메서드 구현
//        2-1 friends 리스트에서 user 아닌 대상 비교 점수 계산
//      3. 점수 높은순으로 정렬 메서드 구현
//        3-1 같은 점수 이름순 정렬
//        3-2 5명 이하로 출력할 것
//      4. donut, shakevan 은 이미 친구라서 추천친구에 해당되지 않음
//        4-1 이미 친구는 추천친구목록에서 제거
//
        List<String> answer = Collections.emptyList();
        answer = calFinalScore(user, friends, visitors);
        return answer;
    }

    public static List<String> calFinalScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> friendMap = new TreeMap<>(); // key : 추천친구, value : 점수
        ArrayList<String> alreadyFriends = findAlreadyFriends(user, friends);   // 이미 친구 목록

        for (int index = 0; index < friends.size(); index++) {
//      친구의 친구 점수 10점 주기
//            이미 친구인 이름이 0번째 있고 1번째가 user가 아니라면
            if (alreadyFriends.contains(friends.get(index).get(0)) && friends.get(index).get(1) != user) {
//            추천친구 목록에 등록 또는 점수 획득 : value 값이 존재하면 원래값 +10, 없으면 key 이름과 value 10으로 항목 추가
                if (friendMap.containsKey(friends.get(index).get(1))) {
                    int score = friendMap.get(friends.get(index).get(1));
                    friendMap.replace(friends.get(index).get(1), score + 10);
                }
                else {
                    friendMap.put(friends.get(index).get(1), 10);
                }
//            이미 친구인 이름이 1번째 있고 0번째가 user가 아니라면
            }
            else if (alreadyFriends.contains(friends.get(index).get(1)) && friends.get(index).get(0) != user) {
//            추천친구 목록에 등록 또는 점수 획득 : value 값이 존재하면 원래값 +10, 없으면 key 이름과 value 10으로 항목 추가
                if (friendMap.containsKey(friends.get(index).get(0))) {
                    int score = friendMap.get(friends.get(index).get(0));
                    friendMap.replace(friends.get(index).get(0), score + 10);
                }
                else {
                    friendMap.put(friends.get(index).get(0), 10);
                }
            }
        }
//      방문자 점수 1점 주기
        for (int index = 0; index < visitors.size(); index++) {
//            추천친구 목록에 방문자 등록 또는 점수 획득 : value 값이 존재하면 원래값 +1, 없으면 key 이름과 value 1으로 항목 추가
            if (friendMap.containsKey(visitors.get(index))) {
                int score = friendMap.get(visitors.get(index));
                friendMap.replace(visitors.get(index), score + 1);
            }
            else {
                if (!alreadyFriends.contains(visitors.get(index))) {
                    friendMap.put(visitors.get(index), 1);
                }
            }
        }
//      5명 점수 오름차순 정렬 반환
        List<String> keySet = new ArrayList<>(friendMap.keySet());
        keySet.sort((A, B) -> friendMap.get(B).compareTo(friendMap.get(A)));

        if (keySet.size() > 5) {
            for (int index = 0; index < 5; index++) {
                result.add(keySet.get(index));
            }
        }
        else {
            for (String key : keySet) {
                result.add(key);
            }
        }
        return result;
    }

    public static ArrayList<String> findAlreadyFriends(String user, List<List<String>> friends) {
        ArrayList<String> alreadyFriendsList = new ArrayList<>();
//          친구 관계에서 0번째 또는 1번째 user가 포함될경우 이미 친구로 등록한다.
//          둘다 user 일경우 예외처리
        for (int index = 0; index < friends.size(); index++) {
            if (friends.get(index).get(0) == user && friends.get(index).get(1) != user) {
                alreadyFriendsList.add(friends.get(index).get(1));
            }
            if (friends.get(index).get(1) == user && friends.get(index).get(0) != user) {
                alreadyFriendsList.add(friends.get(index).get(0));
            }
        }
        return alreadyFriendsList;
    }
}