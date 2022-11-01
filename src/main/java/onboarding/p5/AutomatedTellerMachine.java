package onboarding.p5;

import java.util.ArrayList;
import java.util.List;

public class AutomatedTellerMachine {
    // 화폐를 담고있는 배열
    public static final int[] bill = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    // 가장 적은 화폐 조합을 반환해주는 메서드
    public static List<Integer> getBills(final int money){
        List<Integer> result = new ArrayList<>();
        int remain = money;
        for (int b : bill) {
            int num = remain / b;
            result.add(num);
            remain -= num * b;
        }
        return result;
    }
}
