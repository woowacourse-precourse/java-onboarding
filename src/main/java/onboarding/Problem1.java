package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //1.왼쪽 & 오른쪽 페이지 취득
        int pLeftPage = pobi.get(0); //97
        int pRightPage = pobi.get(1); //98

        int cLeftPage = crong.get(0); //197
        int cRightPage = crong.get(1); //198

        //2.입력값 검증
        if(pRightPage - pLeftPage != 1 || cRightPage - cLeftPage != 1)
            return -1;

        int pMax = Math.max(getSum(pRightPage), Math.max(getSum(pLeftPage),
                Math.max(getMultiple(pRightPage), getMultiple(pLeftPage))));

        int cMax = Math.max(getSum(cRightPage), Math.max(getSum(cLeftPage),
                Math.max(getMultiple(cRightPage), getMultiple(cLeftPage))));

        //
        return answer;
    }

    public static int getSum(int num) {
        int sum = 0;

        while(num / 10 > 0){
            sum += (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public static int getMultiple(int num) {
        int mul = 1;

        while(num / 10 > 0){
            mul *= (num % 10);
            num = num / 10;
        }

        return mul;
    }

}