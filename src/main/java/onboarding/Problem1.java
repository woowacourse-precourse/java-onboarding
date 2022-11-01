package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {

    public static int best_num(int left, int right) { // 숫자를 이용해서 가장 큰 수를 나타내도록 하는 메소드
        int left_plus = 0;
        int right_plus = 0; // 더하는 것을 저장하는 변수 (각각 왼쪽 페이지와 오른쪽 페이지)
        int left_mul = 1;
        int right_mul = 1; // 곱하는 것을 저장하는 변수 (각각 왼쪽 페이지와 오른쪽 페이지)
        int element_left;
        int element_right; // 각 index에 따른 값을 저장하는 요소
        while(right > 0) {
            element_right = (right % 10);
            right /= 10;
            right_plus += element_right;
            right_mul *= element_right;
        }
        while(left > 0) {
            element_left = (left % 10);
            left /= 10;
            left_plus += element_left;
            left_mul *= element_left;
        }

        int[] order = new int[]{left_plus, left_mul, right_plus, right_mul};
        return Arrays.stream(order).max().getAsInt(); // 가장 큰 값이 나타나게 한다.

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);
        if (pobi_left + 1 != pobi_right || crong_left + 1 != crong_right) {
            return -1;

        } else if ((pobi_left % 2) == 0 || (crong_left % 2) == 0) {
            return -1;
        }

        int pobi_best = best_num(pobi_left, pobi_right);
        int crong_best = best_num(crong_left, crong_right);

        if (pobi_best > crong_best){
            answer = 1;
        } else if (pobi_best < crong_best) {
            answer = 2;
        } else {
            answer = 0;
        }


        return answer;
    }

}