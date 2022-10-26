package onboarding;

import java.util.ArrayList;
import java.util.List;



class Problem1 {
     // 올바른 페이지 입력받았는지 check
     // 왼쪽 페이지가 홀수고 오른쪽 페이지가 왼쪽 페이지 숫자 +1 이면 통과
     static boolean checkPage(List<Integer> book){
        if(book.get(0) %2 == 1 && book.get(1) == book.get(0) + 1){
            return true;
        }
        return false;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!(checkPage(pobi) && checkPage(crong))){ // 페이지 올바른지 check
            return -1;
        }



        return answer;
    }
}