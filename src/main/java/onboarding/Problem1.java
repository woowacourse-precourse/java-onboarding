package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     *예외처리 함수
     */
    private static int exception(List<Integer> person){
        if( person.get(0)%2==0 || person.get(1)%2==1){
            return -1;
        } else if (person.get(1) - person.get(0) != 1){
            return -1;
        } else{
            return 0;
        }
    }

    /**
     *모든 자릿수를 더하는 함수
     */
    private static int add_all(int num){

        int answer = 0;

        for(int i=num ; num>0 ; num=num/10)
            answer += num%10;

        return answer;
    }

    /**
     *모든 자릿수를 곱하는 함수
     */
    private static int mul_all(int num){

        int answer = 1;

        for(int i=num ; num>0 ; num=num/10)
            answer *= num%10;

        return answer;
    }

}