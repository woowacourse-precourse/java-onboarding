package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiSum = 0;
        int crongSum = 0;
        int pobiMul = 1;
        int crongMul = 1;
        int pobiMax = 0;
        int crongMax = 0;
        // 페이지가 음수인경우
        for (int i = 0; i < pobi.size(); i++) {
            if (pobi.get(i) <= 0) {
                return -1;
            }
            if (crong.get(i) <= 0) {
                return -1;
            }
        }
        // 왼쪽이 짝수인 경우
        if (pobi.get(0) % 2 == 0 || crong.get(0) == 0) {
            return -1;
        }
        // 책이 연속되지 않은 경우
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        for (int i = 0; i < pobi.size(); i++) {
            String pobiNow = Integer.toString(pobi.get(i));
            String crongNow = Integer.toString(crong.get(i));
            for (int j = 0; j < pobiNow.length(); j++) {
                int now = pobiNow.charAt(j) - '0';
                pobiSum += now;
                pobiMul *= now;
            }
            for (int j = 0; j < crongNow.length(); j++) {
                int now = crongNow.charAt(j) - '0';
                crongSum += now;
                crongMul *= now;
            }
        }
        pobiMax = Math.max(pobiSum, pobiMul);
        crongMax = Math.max(crongSum, crongMul);
        if (pobiMax == crongMax) {
            return 0;
        } else if (pobiMax > crongMax) {
            return 1;
        } else if (crongMax > pobiMax) {
            return 2;
        } else {
            return -1;
        }
    }
}