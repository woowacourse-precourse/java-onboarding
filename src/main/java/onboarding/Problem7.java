package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) makeFriendMap
 *          : friends 리스트를 바탕으로 친구관계도를 만든다(friendMap(HashMap))
 *          2) calculateScore
 *          : makeFriendMap에서 만든 친구관계도, user, visitors를 바탕으로 friendCount 메소드와 visitorCount 메소드를 실행시켜 멤버별 점수를 계산한다.
 *          3) friendCount
 *          : user의 직접 친구가 아닌 멤버의 친구 목록에서 user와 함께 아는 친구 수를 바탕으로(5. intersection 메소드 활용) 점수를 부여한다.(함께 아는 친구 수 x 10)
 *          4) visitorCount
 *          : user의 피드에 방문한 멤버 중, user와 직접 친구가 아닌 멤버에게 방문 횟수만큼의 점수를 부여한다.
 *          5) intersection
 *          : List1과 List2의 요소 중 공통되는 것들의 수를 구하여 반환한다.
 *          6) solution
 *          : calculateScore에서 반환한 멤버별 점수를 담은 countResult HashMap을 1. value(획득점수) 내림차순, 만약 value같다면 2. key(멤버이름) 오름차순으로 정렬하고, 그 중 최고 점수를 획득한 최대 5명을 반환한다.
 *
 *
 *      2. 흐름
 *          1) friends를 바탕으로 makeFriendMap 메소드에서 친구관계도(friendMap)를 만든다.
 *          2-1) calculateScore에 user, friendMap, visitors를 인자로 넣는다. calculateScore에서는 다음 과정(2-2, 2-3, 2-4)이 진행된다.
 *          2-2) friendCount에서 user, friendMap을 인자로 받아 user와 함께 아는 친구 수를 바탕으로 점수를 부여한다.(intersection 메소드 사용)
 *          2-3) visitorCount에서 user의 피드에 방문한 멤버 중 user와 직접 친구가 아닌 멤버들에게 방문 횟수만큼 점수를 부여한다.
 *          3-1) solution 메소드에서 "멤버이름" : "점수" 가 담긴 HashMap을 정렬한다.(정렬 기준 : 1. 점수 내림차순, 2. 멤버이름 오름차순) 정렬결과는 List에 담긴다.
 *          3-2) 정렬된 List에서 최대 5명의 이름을 뽑아 반환한다.
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
