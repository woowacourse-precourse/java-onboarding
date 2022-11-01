package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 계산해야하는 화폐 단위는 변하지 않으므로 final로 생성
        final int CURRENTUNITS[] = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 모든 화폐 단위에 대해 money를 나눈 몫을 리스트에 순서대로 저장
        for (int currentUnit : CURRENTUNITS) {
            answer.add(money / currentUnit);
            money %= currentUnit;
        }

        return answer;
    }
}
