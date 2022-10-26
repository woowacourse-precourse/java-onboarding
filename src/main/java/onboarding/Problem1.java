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

    /**
     *더한 값과 곱한 값 중에 더 큰 값을 반환하는 함수
     */
    private static int which_big(int num){

        int add_num =add_all(num);
        int mul_num =mul_all(num);

        if (add_num > mul_num){
            return add_num;
        } else{
            return mul_num;
        }
    }

    /**
     *두 수를 비교하는 함수
     */
    private static int result_num(int num1, int num2){

        int left =which_big(num1);
        int right =which_big(num2);

        if (left>right){
            return left;
        } else{
            return right;
        }
    }

    /**
     *누가 이겼는지 알리는 함수
     */
    private static int who_win(int pobi_num, int crong_num){

        if(pobi_num>crong_num){
            return 1;
        } else if (crong_num < pobi_num) {
            return 2;
        }else{
            return 0;
        }
    }

}