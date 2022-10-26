package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

    static int defNumber(List<Integer> book){
         int a = book.get(0);
         int b = book.get(1);
         List<Integer> aList = new ArrayList<>(), bList = new ArrayList<>();

         while(a > 0){
             aList.add(a%10);
             a/=10;
         }
         while(b > 0){
             bList.add(b%10);
             b/=10;
         }
         List<Integer> ansList = new ArrayList<>(List.of(0, 1, 0, 1));

         for(int i = 0; i < aList.size(); i++){
             ansList.set(0, ansList.get(0) + aList.get(i));
             ansList.set(1, ansList.get(1) * aList.get(i));
         }

         for(int i = 0; i < bList.size(); i++){
            ansList.set(2, ansList.get(2) + bList.get(i));
            ansList.set(3, ansList.get(3) * bList.get(i));
        }
        Collections.sort(ansList, Collections.reverseOrder());
         System.out.println(ansList);
         return ansList.get(0);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!(checkPage(pobi) && checkPage(crong))){ // 페이지 올바른지 check
            return -1;
        }

        int p_num = defNumber(pobi);
        int c_num = defNumber(crong);

        if(p_num > c_num) answer = 1;
        if(p_num < c_num) answer = 2;
        if(p_num == c_num) answer = 0;

        return answer;
    }
}