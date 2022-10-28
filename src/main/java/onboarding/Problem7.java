package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
- 기능 구현사항 목록 -
1. 친구 목록 해쉬맵 만들기
2. user 와 이미 친구인 사람 목록 만들기 (나중에 해쉬맵에서 제거할 목록)
3. 점수 측정 -> value 값으로 정렬후 5명으로 자르기
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> dic = new HashMap<String,Integer>();
        HashMap<String,Integer> new_dic = new HashMap<String,Integer>();
        List std = new ArrayList();
        for(List relate : friends) {
            for(int i = 0; i < 2; i++) {
                dic.put((String) relate.get(i), 0);
            }
        }
        for (String who : visitors) {
            dic.put(who, 0);
        }
        System.out.println(dic);
        return answer;
    }
}
