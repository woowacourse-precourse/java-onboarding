package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    // [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"]
    // ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ]

    // visitor : ["bedi", "bedi", "donut", "bedi", "shakevan"]

    // mrko가 아는 친구 : donut, shakevan
    // andole이 아는 친구 : donut, shakevan
    // donut이 아는 친구 : andole, mrko
    // shakevan이 아는 친구 :andole, jun, mrko
    // jun이 아는 친구 : donut, shakevan

    // bedi : 3점
    // andole : 20점
    // jun : 20점
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
