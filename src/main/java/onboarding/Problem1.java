package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiResult = 0;
        int crongResult = 0;

        // 연속된 페이지가 아니거나 [1,2] 보다 작거나 [399,400]보다 크면 예외
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            return -1;
        }

        if(pobi.get(0)<1 || pobi.get(1)>400 || crong.get(0)<1 || crong.get(1)>400 ){
            return -1;
        }

        // pobi와 crong의 왼쪽, 오른쪽 페이지의 각 자리 숫자 합과 곱 중 최댓값 구하기
        for(int i = 0; i < 2; i++){
            pobiResult = Math.max(plusNum(pobi.get(i)), timesNum(pobi.get(i)));
            crongResult = Math.max(plusNum(crong.get(i)), timesNum(crong.get(i)));
        }

        if (pobiResult > crongResult){
            answer = 1;
        }
        else if(pobiResult < crongResult){
            answer = 2;
        }
        else if(pobiResult == crongResult){
            answer = 0;
        }

        return answer;
    }

    public static int plusNum(int num){
        int sum = 0;

        while(num!=0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int timesNum(int num){
        int sum = 1;

        while(num!=0){
            sum *= num % 10;
            num /= 10;
        }
        return sum;
    }



}