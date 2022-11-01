package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static final List<Integer> DENOMINATORS = List.of(
            50000, 10000, 5000, 1000,
            500, 100, 50, 10, 1);

    /**
     * 금액을 화폐 단위로 나눈 결과를 리스트로 리턴합니다.
     * 리스트의 각 원소는 순서대로 {@link Problem5#DENOMINATORS}의 화폐 단위의
     * 개수입니다.
     * <p>
     * 가능한 {@link Problem5#DENOMINATORS}에서 이른 순서로 오는 화폐 단위를
     * 많이 갖도록 나눕니다.
     */
    public static List<Integer> solution(int money) {
        ArrayList<Integer> counts = new ArrayList<>();

        for (Integer denom: DENOMINATORS) {
            Integer count = money / denom;
            counts.add(count);
            money -= count * denom;
        }

        return counts;
    }
}
