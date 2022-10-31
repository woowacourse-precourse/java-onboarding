package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        //변수를 쉽게 알아보기 위해 추가
        int pobiLeftNumber = pobi.get(0);
        int pobiRightNumber = pobi.get(1);
        int crongLeftNumber = crong.get(0);
        int crongRightNumber = crong.get(1);

        //페이지 오류
        if(pobiLeftNumber + 1 != pobiRightNumber || crongLeftNumber + 1 != crongRightNumber ||
                pobiLeftNumber < 1 || pobiRightNumber > 400 || crongLeftNumber < 1 || crongRightNumber > 400){
            return -1;
        }

        int pobiNumber = Math.max(getNumberMax(pobiLeftNumber), getNumberMax(pobiRightNumber));
        int crongNumber = Math.max(getNumberMax(crongLeftNumber), getNumberMax(crongRightNumber));

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