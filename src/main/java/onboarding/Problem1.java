package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<List<Integer>> numbers = List.of(pobi, crong);
        List<Integer> pobiList = new ArrayList<>();
        List<Integer> crongList = new ArrayList<>();

        if (pobi.get(0) < 1 || pobi.get(0) > 400 || pobi.get(1) < 1 || pobi.get(1) > 400
                || crong.get(0) < 1 || crong.get(0) > 400 || crong.get(1) < 1 || crong.get(1) > 400
                || pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || pobi.get(1) - pobi.get(0) != 1
                || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                int divide = numbers.get(i).get(j);
                int sum;
                int multiply;

                while (divide > 0) {
                    int percent = divide % 10;
                    divide /= 10;
                    if (i == 0 && j == 0) {
                        sum = percent + percent;
                        multiply = percent * percent;
                        pobiList.add(Math.max(sum, multiply));
                    } else if (i == 0 && j == 1) {
                        sum = percent + percent;
                        multiply = percent * percent;
                        pobiList.add(Math.max(sum, multiply));
                    } else if (i == 1 && j == 0) {
                        sum = percent + percent;
                        multiply = percent * percent;
                        crongList.add(Math.max(sum, multiply));
                    } else {
                        sum = percent + percent;
                        multiply = percent * percent;
                        crongList.add(Math.max(sum, multiply));
                    }
                }
            }
        }
        int pobiMaxValue = Math.max(pobiList.get(0), pobiList.get(1));
        int crongMaxValue = Math.max(crongList.get(0), crongList.get(1));

        if (pobiMaxValue > crongMaxValue) {
            return 1;
        } else if (pobiMaxValue < crongMaxValue) {
            return 2;
        } else {
            return 0;
        }
    }

}