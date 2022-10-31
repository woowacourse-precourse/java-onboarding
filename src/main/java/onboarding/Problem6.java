package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String[]> split = new ArrayList<String[]>();
        List<Integer[]> LCS = new ArrayList<Integer[]>();

        for (List<String> list:forms) {
            split.add(list.get(1).split(""));
            for (List<String> dif:forms) {
                if (list.get(1).equals(dif.get(1))) continue;
                else split.add(dif.get(1).split(""));
//                for (split.get(0)){
//                    for(){
//                    }
//                    /*
//                        list 값을 배열로 만듬, dif 값을 배열로 만듬
//                        dif 배열 기준으로 list와 하나씩 비교
//                        아닌 경우 0 맞는 경우 1로 채우고 만약
//                        왼쪽 상단이 1일 경우는 같은 그게 있다고 가정하고
//                        break 후 이메일 값을 집어 넣는다.
//                     */
//                }
            }
        }
        return answer;
    }
}
