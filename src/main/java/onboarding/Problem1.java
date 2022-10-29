package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //Pobi
        int pobi_max = 0;
        for (int i = 0; i < 2; i++) {

            //자릿수로 분해하기
            ArrayList<Integer> arrNum = new ArrayList<>();
            int pageNum = pobi.get(i);
            while (pageNum > 0) {
                arrNum.add(pageNum % 10);
                pageNum /= 10;
            }

            //분해한 자릿수별로 더하기/곱하기
            int addNum = 0;
            int multNum = 1;
            for (Integer number : arrNum) {
                addNum += number;
                multNum *= number;
            }
            pobi_max = Math.max(addNum, multNum);
        }

        //crong
        int crong_max = 0;
        for (int i = 0; i < 2; i++) {

            //자릿수로 분해하기
            ArrayList<Integer> arrNum = new ArrayList<>();
            int pageNum = crong.get(i);
            while (pageNum > 0) {
                arrNum.add(pageNum % 10);
                pageNum /= 10;
            }

            //분해한 자릿수별로 더하기/곱하기
            int addNum = 0;
            int multNum = 0;
            for (Integer number : arrNum) {
                addNum += number;
                multNum *= number;
            }
            crong_max = Math.max(addNum, multNum);
        }

    return Math.max(pobi_max,crong_max);
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        pobi.add(131);
        pobi.add(132);

        List<Integer> crong = new ArrayList<>();
        crong.add(211);
        crong.add(212);

        int result = Problem1.solution(pobi, crong);
        System.out.println(result);
    }
}

