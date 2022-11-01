package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pl = pobi.get(0); //pl: 포비의 왼쪽 페이지 넘버
        int pr = pobi.get(1); //pr: 포비의 오른쪽 페이지 넘버
        int cl = crong.get(0); //cl: 크롱의 왼쪽 페이지 넘버
        int cr = crong.get(1); //cr: 크롱의 오른쪽 페이지 넘버

        //예외처리
        if (checkException(pl, pr, cl, cr)){
            return -1;
        }

        //포비가 이기면 1, 크롱이 이기면 2, 무승부이면 0
        if (getMaxValue(pl, pr) > getMaxValue(cl, cr)){
            return 1;
        } else if (getMaxValue(pl, pr) < getMaxValue(cl, cr)) {
            return 2;
        } else {
            return 0;
        }
    }

    //0. 예외처리
    static boolean checkException(int pl, int pr, int cl, int cr){
        //예외 처리 1. 1~400 범위가 아닌 경우
        if (pl<1 || pl>399 || cl<1 || cl>399){
            return true;
        }
        //예외 처리 2. 왼쪽 페이지와 오른쪽 페이지가 서로 1씩 차이나지 않는 경우
        if (pr-pl != 1 || cr-cl != 1){
            return true;
        }
        //예외 처리 3. 왼쪽 페이지가 홀수가 아닌 경우
        if (pl%2 != 1 || cl%2 != 1){
            return true;
        }

        return false;
    }

    //1. 최댓값 구하기
    static int getMaxValue(int l, int r) {
        int l_added_value = 0;
        int l_multiplied_value = 1;
        int r_added_value = 0;
        int r_multiplied_value = 1;

        //왼쪽 페이지 번호의 최댓값
        while(l > 0){
            l_added_value += l%10;
            l_multiplied_value *= l%10;
            l/=10;
        }

        //오른쪽 페이지 번호의 최댓값
        while(r > 0){
            r_added_value += r%10;
            r_multiplied_value *= r%10;
            r/=10;
        }

        //가장 큰 값이 최종 값
        return max(max(l_added_value, l_multiplied_value), max(r_added_value, r_multiplied_value));
    }
}