package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if ((pobiRight-pobiLeft) != 1 || (crongRight-crongLeft) != 1) return -1;


        int pobiMax = findMax(pobiLeft, pobiRight);
        int crongMax = findMax(crongLeft, crongRight);

        if (pobiMax > crongMax) answer = 1;
        else if (pobiMax < crongMax) answer = 2;
        else answer = 0;

        return answer;
    }

    public static int findMax(int left, int right){

        int leftSum = 0;
        int leftMul = 1;
        int rightSum = 0;
        int rightMul = 1;

        while(left > 0){
            int  n = left%10;

            leftSum += n;
            leftMul *= n;

            left /= 10;
        }

        while(right > 0){
            int  n = right%10;

            rightSum += n;
            rightMul *= n;

            right /= 10;
        }

        return Math.max(Math.max(leftSum, leftMul), Math.max(rightSum, rightMul));
    }
}