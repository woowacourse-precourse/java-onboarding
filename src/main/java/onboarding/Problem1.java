package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    //합,곱 메서드 선언
    public static int sum_num(int pageNum){
        int sum = 0;
        int num = pageNum;
        while (num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public static int mul_num(int pageNum){
        int mul = 1;
        int num = pageNum;
        while (num!=0){
            mul *= num%10;
            num /= 10;
        }
        return mul;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //answer 초기화
        int answer = 0;

        //좌우 페이지 선언
        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        //최댓값 선언
        List<Integer> max_pobiArr = List.of(sum_num(pobi_left), sum_num(pobi_right),
                mul_num(pobi_left), mul_num(pobi_right));
        List<Integer> max_crongArr = List.of(sum_num(crong_left), sum_num(crong_right),
                mul_num(crong_left), mul_num(crong_right));
        Integer max_pobi = Collections.max(max_pobiArr);
        Integer max_crong = Collections.max(max_crongArr);

        //예외처리 및 솔루션
        if (
                pobi.size() != 2 || crong.size() != 2
                        || pobi_left > 400 || pobi_left < 1
                        || pobi_right > 400 || pobi_right < 1
                        || crong_left > 400 || crong_left < 1
                        || crong_right > 400 || crong_right < 1
                        || (pobi_left % 2) != 1 || (pobi_right % 2) != 0
                        || (crong_left % 2) != 1 || (crong_right % 2) != 0
                        || (pobi_right-pobi_left)!=1 || (crong_right-crong_left)!=1
        ) {
            answer = -1;
        } else if(max_pobi.equals(max_crong)) {
            answer = 0;
        } else if (max_pobi > max_crong) {
            answer = 1;
        } else if (max_pobi < max_crong) {
            answer = 2;
        }
        return answer;
    }
}