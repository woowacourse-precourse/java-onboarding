package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    //기능1. 입력받은 페이지 번호의 각 자리의 숫자를 더하거나 곱한다.
    public static int sumdivPage(int page){
        int answer = 0;
        int hundred, ten, one;
        int mok, na;
        int sum = 0;
        int div = 1;

        if(page>=100){
            mok = page/100;
            na = page%100;
            hundred = mok;
            ten = na/10;
            one = na%10;
            sum = hundred + ten + one;
            div = hundred * ten * one;
            answer = bigPage(sum, div);

        }else if(page>=10){
            ten = page/10;
            one = page%10;
            sum = ten + one;
            div = ten * one;
            answer = bigPage(sum, div);
        }else{
            answer = page;
        }
        return answer;
    }
}