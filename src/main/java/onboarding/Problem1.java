package onboarding;

import java.util.List;

class Problem1 {

    //입력 조건을 검사하는 method
    public static boolean verifyConditions(List<Integer> test){
        boolean metConditions = true;

        //모두 1부터 400페이지안에 해당하지 않는 경우
        // or 홀수 페이지가 짝수 or 짝수 페이지가 홀수
        if(!(test.get(0) >=1 & test.get(0) <=399))
            metConditions = false;
        else if(!(test.get(1) >=2 & test.get(1) <=400))
            metConditions = false;
        else if((test.get(0)%2 != 1) | (test.get(1)%2 !=0))
            metConditions = false;
        else if((test.get(0)+1) != (test.get(1)))
            metConditions = false;

        return metConditions;
    }

    //각 자리 숫자 더하는 method
    public static int Sum(int n){
        int result = 0;

        while(n>1){
            result += n%10;
            n/=10;
        }
        return result;
    }

    //각 자리 숫자 곱하는 method
    public static int Mul(int n){
        int result = 1;

        while(n>1){
            result = result * (n%10);
            n/=10;
        }
        return result;
    }

    //각 자리 숫자의 곱과 덧셈 중 더 큰 값을 점수로 하기
    public static int makeScore(List<Integer> list){
        int a = list.get(0);
        int b = list.get(1);
        int resultA = 0;
        int resultB = 0;

        resultA = Math.max(Sum(a),Mul(a));
        resultB = Math.max(Sum(b),Mul(b));

        return Math.max(resultA, resultB);
    }

    public static int winner(int a, int b){
        int result = 0;

        if(a>b)
            result = 1;
        else if(a<b)
            result = 2;

        return result;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //입력 조건 만족하지 않을 경우 예외사항 return
        if(!(verifyConditions(pobi)))
            answer =  -1;
        else if(!(verifyConditions(crong)))
            answer = -1;
        else{
            int scorePobi = makeScore(pobi);
            int scoreCrong = makeScore(crong);
            answer = winner(scorePobi, scoreCrong);
        }

        return answer;
    }
}