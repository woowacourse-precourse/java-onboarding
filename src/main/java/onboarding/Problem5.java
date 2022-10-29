package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
- 기능 구현사항 목록 -
1. 화폐 단위가 들어있는 array 생성(내림차순)
2. 크기와 같은 빈 array_answer 생성
3. array 를 돌면서 n을 나눈 몫을 array_answer 에 저장
4. n %= array[i] 갱신
 */
public class Problem5 {
    static final int[]  arr_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static List<Integer> calc(List<Integer> ans, int money){
        for(int unit : arr_money) {
            ans.add(money / unit);
            money %= unit;
        }
        return ans;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        return calc(answer,money);
    }
}
