package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (numException(pobi) && numException(crong)) {
            int pobiValue = memberHighestValue(pobi);
            int crongValue = memberHighestValue(crong);

            answer = winMember(pobiValue, crongValue);
        } else {
            answer = -1;
        }
        return answer;
    }

    public static int winMember(int pobi, int crong) {
        if (pobi > crong)
            return 1;
        else if (pobi == crong)
            return 0;
        else
            return 2;
    }

    public static int memberHighestValue(List<Integer> member) {
        List<Integer> ints = new ArrayList<>();
        for (Integer num : member) {
            ints.add(pageHighestValue(num));
        }
        return Collections.max(ints);
    }

    public static int pageHighestValue(Integer num) {
        int page = num.intValue();
        int sum = 0;
        int multiply = 1;
        while (page != 0) {
            sum += page % 10;
            multiply *= page % 10;

            page /= 10;
        }
        return sum > multiply ? sum : multiply;
    }

    public static boolean numException(List<Integer> member) {
        int first = member.get(0);
        int second = member.get(1);

        if (checkEvenOdd(first, second)) {
            if (second - first == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    public static boolean checkEvenOdd(int firstNum, int secondNum) {
        if (firstNum % 2 == 1 && secondNum % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}