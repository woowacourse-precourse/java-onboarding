package onboarding;

import java.util.List;


/**
 * <기능 목록>
 *     1. 메소드
 *          1) max
 *          : 파라미터로 받는 두 변수(int) 중 큰 것을 반환한다.
 *          2) calculate
 *          : 왼쪽, 오른쪽 페이지의 각 자리 수를 모두 더하거나 뺀 것 중 가장 큰 수를 반환한다.
 *          3) exceptionValidate
 *          : pobi와 crong의 승패를 결정할 수 없는 예외의 경우를 검증. 예외 상황의 경우 -1를 반환한다.
 *            이 함수가 검증하는 예외사항은 [참고1]과 같다.
 *
 *
 *      [참고1]
 *      # exceptionValidate가 검증하는 예외사항
 *
 *      - 펼친 페이지의 두 수가 연속하지 않는 경우.
 *      - 펼친 페이지의 두 수가 책의 범위를 벗어나는 경우.
 */


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int max(int a, int b){
        return a > b? a : b;
    }

    public static int calculate(List<Integer> pages){

        int max_value = -1;
        for(Integer page: pages){
            int addValue = 0;
            int multiplyValue = 1;

            while(page!=0){
                addValue += (page%10);
                multiplyValue *= (page%10);

                page /=10;
            }

            int temp = max(addValue, multiplyValue);

            if(temp > max_value){
                max_value = temp;
            }
        }

        return max_value;
    }

    public static int exceptionValidate(List<Integer> list1, List<Integer> list2){
        int list1_1 = list1.get(0);
        int list1_2 = list1.get(1);

        int list2_1 = list2.get(0);
        int list2_2 = list2.get(1);

        // 경우1. 둘 중 한명이라도 펼친 페이지의 두 수가 연속하지 않는 경우
        if ((list1_2- list1_1) != 1 || (list2_2 - list2_1) != 1) {

            return -1;
        }

        // 경우2. 펼친 페이지의 두 수가 책의 범위를 벗어나는 경우
        if (list1_1 < 1 || list1_2 > 400 || list2_1 < 1 || list2_2 > 400){
            return -1;
        }

        return 1;
    }
}