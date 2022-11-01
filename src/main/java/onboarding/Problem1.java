package onboarding;

import javax.xml.validation.Validator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validateNum(pobi) == -1 || validateNum(crong) == -1)
            return -1;

        return answer;
    }
    // 페이지가 맞으면 1, 아니면 -1
    private static int validateNum(List<Integer> lst) {
        if (lst.get(0) < 1 || lst.get(1) > 400)
            return -1;
        if (lst.get(0) % 2 == 0 || lst.get(1) % 2 == 1)
            return  -1;
        if (lst.get(0) + 1 != lst.get(1))
            return  -1;

        return 1;
    }
}