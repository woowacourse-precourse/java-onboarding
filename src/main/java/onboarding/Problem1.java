package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        //예외 발생
        if (exception(pobi) || exception(crong)) return -1;

        int cMax, pMax; // 포비와 크롱의 최댓값을 담을 변수

        pMax = Math.max(maxMulAdd(pobi.get(0)),maxMulAdd(pobi.get(1))); // 포비의 최댓값
        cMax = Math.max(maxMulAdd(crong.get(0)),maxMulAdd(crong.get(1))); // 크롱의 최댓값

        if (cMax == pMax) answer = 0;
        else answer = (pMax > cMax) ? 1 : 2;

        return answer;
    }

    static int maxMulAdd(int num){
        int add = 0, mul = 1;
        while (num > 0){
            add += num % 10;
            mul *= num % 10;
            num /= 10;
        }
        return Math.max(add, mul);
    }
    static public boolean exception(List<Integer> array){
      if (array.size() != 2) return true; // 리스트 사이즈가 2인지
      if (array.get(0) < 0 || array.get(1) > 401) return true; //페이지는 1~400
      if (array.get(0) % 2 == 0 || array.get(1) % 2 == 1) return true; // 왼쪽은 홀수, 오른쪽은 짝수
        return array.get(1) - array.get(0) != 1; //오른쪽 페이지 - 왼쪽 페이지 = 1
    }
}