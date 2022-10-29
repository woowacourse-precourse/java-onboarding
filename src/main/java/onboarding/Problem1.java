package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result;
        //exception checking
        boolean exception;
        if (pobi.size() != 2 || crong.size() != 2) exception = true;
        else if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) exception = true;
        else exception=false;

        if (exception) {
            result = -1;
        } else {

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
                int multNum = 1;
                for (Integer number : arrNum) {
                    addNum += number;
                    multNum *= number;
                }
                crong_max = Math.max(addNum, multNum);
            }

            if (pobi_max > crong_max) {
                result = 1;
            } else if (pobi_max < crong_max) {
                result = 2;
            } else result = 0;
        }

        return result;
    }


}

