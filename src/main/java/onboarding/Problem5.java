package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) { // 하나의 새로운 지갑을 만들고 몫과 나머지를 이용해서 풀이
        List<Integer> wallet = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1); // 하나의 리스트에 모두 담아두기
        List<Integer> result = new ArrayList<>(); // 반환할 결과

        for (int i = 0; i < 9; i++) // 지갑의 범위만큼 돌면서 입력받은 money를 각 요소로 나눠서 몫을 저장, 나머지를 이용해 다음 요소로 다시 나누기
        {
            result.add(money / wallet.get(i));
            money %= wallet.get(i);
        }

        return result;
    }
}
