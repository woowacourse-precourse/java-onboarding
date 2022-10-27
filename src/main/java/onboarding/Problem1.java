package onboarding;

import java.util.List;

class Problem1 {
    static int calculateMax(Integer num) {
        int sum = 0;
        int mul = 1;
        while(num > 0) {
            int currentNum = num % 10;
            sum += currentNum;
            mul *= currentNum;
            num /= 10;
        }

        return Math.max(sum,mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        try {
            if (pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1){
                Exception e = new Exception();
                throw e;
            }

            int pobiMax = Math.max(calculateMax(pobiLeft),calculateMax(pobiRight));
            int crongMax = Math.max(calculateMax(crongLeft),calculateMax(crongRight));

            if (pobiMax > crongMax) answer = 1;
            if (pobiMax < crongMax) answer = 2;
            if (pobiMax == crongMax) answer = 0;

        } catch (Exception e) {
            answer = -1;
        } finally {
            return answer;
        }
    }
}