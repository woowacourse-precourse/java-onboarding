package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiNumber = -1, crongNumber = -1;

        //페이지 오류
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)){
            return -1;
        }

        pobiNumber = Math.max(getNumberMax(pobi.get(0)), getNumberMax(pobi.get(1)));
        crongNumber = Math.max(getNumberMax(crong.get(0)), getNumberMax(crong.get(1)));

        if(pobiNumber > crongNumber){
            answer = 1;
        }
        else if(pobiNumber < crongNumber){
            answer = 2;
        }
        else if(pobiNumber == crongNumber){
            answer = 0;
        }

        return answer;
    }

    //번호의 각 자리 숫자들의 합이나 곱 중 가장 큰값을 구하는 함수
    private static int getNumberMax(int num){
        int sum = 0, multi = 1;
        while(num != 0){
            sum += num%10;
            multi *= num%10;
            num /= 10;
        }
        return Math.max(sum, multi);
    }
}