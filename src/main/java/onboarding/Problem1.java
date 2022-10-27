package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 페이지가 연속적인가 -> 아닐경우 return -1
        // 2. 오른쪽 왼쪽 계산해주는 메소드
        // 3. 나의 큰수 결정하는 메소드
        // 4. 포비랑 크롱을 비교하는 메소드 -> return 값을 정하는 메소드 : solution

        return -1;
    }

    public boolean checkPage(List<Integer> list){ // 페이지 연속 확인하는 메소드
        if(list.get(1)-list.get(0)==1) return true;
        else return false;

    }

    public int calMax(List<Integer> list){ // 왼쪽 오른쪽 페이지 계산해주는 메소드
        // 왼쪽 페이지의 덧셈 곱셈을  -> 큰수결정
        // 오른쪽 페이지의 덧셈 곱셈을  -> 큰수결정
        // 왼 vs 오 큰수 결정 해서 반환
        return 0;
    }

    public int calPlus(int number){ // 각페이지의 덧셈을 해주는 메소드

        return 0;
    }

    public int calMulti(int number){ // 각페이지의 곱셈을 해주는 메소드
        return 0;
    }


}