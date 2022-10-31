package onboarding;

import java.util.List;

class Problem1 {
    static final int PAGE_MAX = 400;
    static final int PAGE_MIN = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 점수를 비교해 가장 높은 사람을 return
        // pobi 가 이길 경우 1, 크롱이 이길 경우 -1, 비길경우 0, 예외사항은 -1
        int answer = Integer.MAX_VALUE;
        int scorePobi = -1, scoreCrong = -1;

        // check
        if (pobi.get(0) + 1 != pobi.get(1) || pobi.get(0) < PAGE_MIN || pobi.get(1) > PAGE_MAX) return -1;
        if (crong.get(0) + 1 != crong.get(1) || crong.get(0) < PAGE_MIN || crong.get(1) > PAGE_MAX) return -1;

        // start
        // 각자리 수를 더하거나, 모두 곱해 가장 큰수를 구한다.
        for (int i = 0; i < 2; i++) {
            scorePobi = Math.max(scorePobi, calc(pobi.get(i)));
            scoreCrong = Math.max(scoreCrong, calc(crong.get(i)));
        }
        if (scorePobi > scoreCrong) answer = 1;
        else if (scorePobi < scoreCrong) answer = 2;
        else answer = 0;
        return answer;
    }

    private static int calc(Integer integer) {
        // 들어온 수에 대하여, 각 자리 숫자를 더하거나, 모두 곱해 큰 수를 return
        int w = integer, res = -1, sum = 0;
        while (w > 0) {
            sum += (w % 10);
            w /= 10;
        }
        res = sum;
        w = integer;
        sum = 1;
        // 각자리 수에 대하여 곱셈
        while (w > 0) {
            sum *= (w % 10);
            w /= 10;
        }
        return Math.max(res, sum);
    }

}