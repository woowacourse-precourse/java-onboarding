package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    //각 자리의 숫자를 모두 더하는 함수
    public static int page_plus(int number){
        int sum_plus = 0;
        while(number != 0){
            sum_plus += number % 10;
            number /= 10;
        }
        return sum_plus;
    }

    //각 자리의 숫자를 모두 곱하는 함수
    public static int page_mul(int number){
        int sum_mul = 1;
        while(number != 0){
            sum_mul *= number % 10;
            number /= 10;
        }
        return sum_mul;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //error 처리
        //배열 안의 숫자가 연속되지 않으면 에러
        if(pobi.get(0) + 1 != pobi.get(1))
            return -1;
        if(crong.get(0) + 1 != crong.get(1))
            return -1;

        //error 처리
        //배열 안의 숫자가 1~400 사이가 아니면 에러
        if(pobi.get(0) < 1 && pobi.get(1) > 401)
            return -1;
        if(crong.get(0) < 1 && crong.get(1) > 401)
            return -1;

        //error 처리
        // 왼쪽 숫자가 짝수이면 에러
        if(pobi.get(0) % 2 == 0)
            return -1;
        if(crong.get(0) % 2 == 0)
            return -1;


        int pobi_max = 0;
        int crong_max= 0;

        int compare1 = page_plus(pobi.get(0));
        int compare2 = page_mul(pobi.get(1));
        if (compare1 >= compare2)
            pobi_max = compare1;
        else
            pobi_max = compare2;

        compare1 = page_plus(crong.get(0));
        compare2 = page_mul(crong.get(1));
        if (compare1 >= compare2)
            crong_max = compare1;
        else
            crong_max = compare2;

        int answer = Integer.MAX_VALUE;

        if(pobi_max > crong_max )
            answer = 1;
        else if (pobi_max < crong_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }
        else
            return -1;
        return answer;
    }

}