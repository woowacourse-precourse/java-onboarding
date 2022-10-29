package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    // [아이디, 점수] 포함하는 List<List<String>> 리스트 만들기
    // 모든 friends 목록을 탐색하면서 모든 친구들을 담는 리스트 만들기
    // -> 이미 친구인 사람은 제외
    // friends에서 user -> user의 친구 -> 친구의 친구들에게 10점을 주기
    // 마지막에는 인덱스가 5를 넘어가면 잘라내기로 함
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
