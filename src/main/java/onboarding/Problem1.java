package onboarding;

import javax.swing.*;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (errorCheck(pobi) || errorCheck(crong))
            return -1;
        int maxP = personMax(pobi);
        int maxC = personMax(crong);
        if (maxP > maxC)
            return 1;
        else if (maxP < maxC)
            return 2;
        else
            return 0;
    }
    private static List<Integer> int2array(Integer num) {
        List<Integer> digits = new ArrayList<>();
        while(num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private static int pageMax(List<Integer> digits) {
        int sum = 0;
        int mult = 1;

        for (Integer digit : digits) {
            sum += digit;
            mult *= digit;
        }

        return Math.max(sum, mult);
    }

    private static int personMax(List<Integer> list){
        int maxL;
        int maxR;

        List<Integer> digitsL = int2array(list.get(0));
        List<Integer> digitsR = int2array(list.get(1));

        maxL = pageMax(digitsL);
        maxR = pageMax(digitsR);

        return Math.max(maxL, maxR);
    }

    private static boolean errorCheck(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        // || 연산자는 좌항이 참이면 더이상 검사하지 않으므로 효율적 에러처리가 가능하다.
        if (left < 1 || left > 400 || left % 2 != 1
                || right < 1 || right > 400 || right % 2 != 0
                || right - left != 1)
            return true;
        return false;
    }
}