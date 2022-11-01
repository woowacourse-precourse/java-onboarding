package onboarding;

import java.util.List;

class Problem1 {

    public static final int pobiWin = 1;
    public static final int crongWin = 2;
    public static final int draw = 0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*1.왼쪽 & 오른쪽 페이지 번호 취득*/
        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);

        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);

        /*2.입력값 검증*/
        if(pRightPage - pLeftPage != 1 || cRightPage - cLeftPage != 1)
            return -1;

        if(pRightPage > 400 || pLeftPage > 400 || cRightPage > 400 || cLeftPage > 400)
            return -1;

        /*3.각 페이지 자릿수의 합과 곱을 구한다.*/
        int pMax = Math.max(getSum(pRightPage), Math.max(getSum(pLeftPage),
                Math.max(getMultiple(pRightPage), getMultiple(pLeftPage))));

        int cMax = Math.max(getSum(cRightPage), Math.max(getSum(cLeftPage),
                Math.max(getMultiple(cRightPage), getMultiple(cLeftPage))));

        /*4.최댓값을 비교하고 게임 결과를 리턴한다.*/
        if(pMax > cMax)
            answer = pobiWin;

        if(pMax < cMax)
            answer = crongWin;

        if(pMax == cMax)
            answer = draw;

        return answer;
    }

    public static int getSum(int num) {
        int sum = 0;

        while(num > 0){
            sum += (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public static int getMultiple(int num) {
        int mul = 1;

        while(num > 0){
            mul *= (num % 10);
            num = num / 10;
        }

        return mul;
    }

}