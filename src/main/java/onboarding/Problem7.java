package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public void friendMap(List<List<String>> friends) {

    }


}
//  1. hashmap으로 친구 당 가지는 모든 친구관계를 구성
//  2. 사용자가 가지는 친구 관계와 같은 친구를 뽑음.
//  3.친구 별로 사용자와 같은 친구 하나당 10을 추가하는 hashmap 생성
//  visitors는 1점 추가
//  4.hash 맵에서 밸류값이 높은 순서대로 뽑는데 같은 밸류값 뽑아서
//  일단 이름순으로 list에 삽입 5명되면 break
