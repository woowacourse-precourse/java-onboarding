package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 test = new Problem1();
        int answer = Integer.MAX_VALUE;
        if (test.checkException(pobi) && test.checkException(crong)) {
            int pobiMax = test.getMaxValue(pobi, pobi.size());
            int crongMax = test.getMaxValue(crong, crong.size());
            if (pobiMax > crongMax) {
                answer = 1;
            } else if (pobiMax == crongMax) {
                answer = 0;
            } else {
                answer = 2;
            }
        } else {
            answer = -1;
        }

        return answer;
    }

    private boolean checkException(List<Integer> checkList) {
        for (Integer checkValue : checkList) {
            if (!(checkValue >= 1 && checkValue <= 400)) {
                return false;
            }
        }
        return checkList.get(0) % 2 == 1 && checkList.get(1) % 2 != 1 && checkList.get(0) + 1 == checkList.get(1);
    }

    private int getMaxValue(List<Integer> list, int listLength) {
        ArrayList<Integer> maxValueList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            int plus_value = 0, multiply_value = 1;
            int each_num = list.get(i);
            while (each_num > 0) {
                plus_value += each_num % 10;
                multiply_value *= each_num % 10;
                each_num /= 10;
            }
            maxValueList.add(Math.max(plus_value, multiply_value));
        }
        return Collections.max(maxValueList);
    }
}