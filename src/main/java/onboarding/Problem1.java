package onboarding;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int bookFirstPage = 1;
        int bookLastPage = 400;

        try {
            for(int index = 0; index <2 ; index ++) {
                if ( bookFirstPage <= pobi.get(index)  &&  pobi.get(index) <= bookLastPage ) {
                    ArrayList<Integer> pobisEachDigit = getEachDigit(pobi.get(index));

                }

                if ( bookFirstPage <= crong.get(index)  &&  crong.get(index) <= bookLastPage ) {
                    ArrayList<Integer> crongsEachDigit = getEachDigit(crong.get(index));

                }
            }
        } catch (Exception exception) {
            System.out.println("입력값은 1이상 400이하의 숫자만 가능합니다.(null 불가)");
        }
        return answer;
    }

    public static ArrayList<Integer> getEachDigit(int page) {
        ArrayList<Integer> eachDigitArray = new ArrayList<>();
        while(page > 0) {
            int eachDigit = page % 10;
            eachDigitArray.add(eachDigit);
            page /= 10;
        }
        return(eachDigitArray);
    }
}