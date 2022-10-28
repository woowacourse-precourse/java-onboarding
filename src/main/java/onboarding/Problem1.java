package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int score(int num) {
        List<Integer> numList = new ArrayList<>();

        while (num != 0) {
            numList.add(num % 10);
            num /= 10;
        }
        int sum = 0;
        int mul = 1;
        for (Integer n : numList) {
            sum += n;
            mul *= n;
        }
        return Math.max(sum, mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        // ----- 유효성 확인 -----
        if (pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1) {
            return -1;
        }

        // ----- 포비의 점수 계산 -----
        int pobiScore = Math.max(score(pobiLeft), score(pobiRight));

        // ----- 크롱의 점수 계산 -----
        int crongScore = Math.max(score(crongLeft), score(crongRight));

        // ----- 결과 계산 -----
        // 포비와 크롱의 점수가 같다면,
        if (pobiScore == crongScore) return 0;
        // 포비의 점수가 더 크다면,
        if (pobiScore > crongScore) return 1;
        // 포비의 점수가 더 작다면,
        return 2;
    }
}