package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashSet;

/*
문제 설명
친구 추천 알고리즘을 위한 규칙
- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문환 횟수 = 1점

친구 추천 규칙에 따라 점수가 높은 순으로 정렬하여 최대 5명을 반환하도록 한다.
추천 점수가 0점일 경우 추천하지 않으며, 점수가 같은 경우는 이름순으로 정렬한다.

user: 사용자 아이디 문자열
friends: 각 원소가 길이 2인 친구 관계 정보 리스트. [아이디 A, 아이디 B] -> A와 B는 친구
visitors: 사용자 타임 라인 방문 기록
*/

/*
기능 목록
- 점수를 세기 위한 친구 HashSet 구성하기.
- 친구 목록 HashSet을 통해 점수를 0으로 일단 초기화하기.
- 사용자와 함께 아는 친구 그룹 구성하기.
- 함께 아는 친구들 점수 내기.
- 타임 라인 방문 기록을 통해 점수 내기.
- 함께 아는 친구를 통해 낸 점수와 타임 라인에 방문한 횟수를 통해 낸 점수 합치기.
- 점수 내림차순으로 정렬하여 최대 5명 뽑기.
- 추천 점수가 같은 경우 이름순으로 정렬하기.
- 추천 점수가 0점인 경우 추천하지 않기.
*/

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 친구 목록을 중복되지 않도록 구성해준다.
        HashSet<String> friends_set = new HashSet<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String friend = friends.get(i).get(j);

                if (!(friend.equals(user))) {
                    friends_set.add(friend);
                }
            }
        }

        return answer;
    }
}
