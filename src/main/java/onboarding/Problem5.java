package onboarding;
/*
* 1. Greedy 알고리즘을 이용하여 구현
* 2. 돈의 액수를 담은 배열 생성
* 3. 배열을 돌며 나누어 떨어지는 경우 화폐로 변환
*/
import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < unit.length; i++){
            int cnt = money / unit[i];
            money -= cnt * unit[i];
            answer.add(cnt);
        }
        return answer;
    }
}
