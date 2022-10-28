package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiSum = 0, crongSum = 0; // 포비와 크롱의 각 자리 숫자의 합
        int pobiMul = 1, crongMul = 1; // 포비와 크롱의 각 자리 숫자의 곱
        int pobiMax = Integer.MIN_VALUE;
        int crongMax = Integer.MIN_VALUE;
        int i;

        for(i = 0; i < 2; i++) {
            int pobiNum = pobi.get(i);
            int crongNum = pobi.get(i);

            if(pobiNum <= 1 || pobiNum >= 400 || crongNum <= 1 || crongNum >= 400) { // 예외처리
                answer = -1;
                return answer;

            } else {
                while(pobiNum != 0) { // 각 자리수 구하기
                    pobiSum += pobiNum % 10;
                    pobiMul *= pobiNum % 10;

                    pobiNum /= 10;
                }
                while(crongNum != 0) {
                    crongSum += crongNum % 10;
                    crongMul *= crongNum % 10;

                    crongNum /= 10;
                }
            }
        }
        pobiMax = Math.max(pobiSum, pobiMul); // 각 자리수 더한 값과 곱한값 중 최대값 찾기
        crongMax = Math.max(crongSum, crongMul);

        if(pobiMax > crongMax) {
            answer = 1;
        }else if(pobiMax < crongMax) {
            answer = 2;
        }else {
            answer = 0;
        }

        return answer;

    }
}