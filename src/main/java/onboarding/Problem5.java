package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private final static int[] MONETARY_UNITS = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int remainder = money; // 변환할 나머지 금액을 계산할 변수
        for (int unit : MONETARY_UNITS) {
            int count = remainder / unit; // 해당 화폐단위의 사용 개수
            answer.add(count); // 반환할 리스트에 해당 화폐단위의 사용 개수를 담는다.
            remainder %= unit; // 다음 화폐단위로 변환할 나머지 금액
        }
        return answer;
    }
}
