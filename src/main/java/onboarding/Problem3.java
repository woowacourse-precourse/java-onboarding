package onboarding;

import java.util.List;

public class Problem3 {

    private static final List<String> criteriaList = List.of(
            new String("3"),
            new String("6"),
            new String("9")
    );

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    //숫자에 3,6,9가 들어갈 때 3,6,9의 개수를 구하는 메서드
    public static int getClapCount(int number) {
        int cnt = 0;
        for (String s : String.valueOf(number).split("")) {
            if (criteriaList.contains(s)) {
                cnt += 1;
            }
        }
        return cnt;
    }


}
