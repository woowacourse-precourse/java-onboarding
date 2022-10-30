package onboarding;

import java.util.List;
import java.util.Scanner;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int bookFirstPage = 1;
        int bookLastPage = 400;

        try {
            for(int index = 0; index <2 ; index ++) {
                if ( bookFirstPage <= pobi.get(index)  &&  pobi.get(index) <= bookLastPage ) {

                }

                if ( bookFirstPage <= crong.get(index)  &&  crong.get(index) <= bookLastPage ) {

                }
            }
        } catch (Exception exception) {
            System.out.println("입력값은 1이상 400이하의 숫자만 가능합니다.(null 불가)");
        }
        return answer;
    }

}