package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;
import static java.lang.Math.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = getAnswer(pobi, crong);
        return answer;
    }

    private static int getAnswer(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);

        int crongScore = getScore(crong);


        if ((pobi.get(0) == pobi.get(1)-1) && (crong.get(0) == crong.get(1)-1)) {

            if (pobiScore > crongScore) {
                return 1;
            } else if (pobiScore == crongScore) {
                return 0;
            } else return 2;

        } else return -1;
    }

    private static int getScore(List<Integer> player) {
        int sum = (
                max(getSum(player, 0), getSum(player, 1))
        );


        int multi = (
                max(getMulti(player, 0), getMulti(player, 1))
        );


        return max(sum, multi);
    }

    private static int getSum(List<Integer> list, int index) {

        int sum = 0;

        Integer num = list.get(index);

        while (num > 0) {
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }


    private static int getMulti(List<Integer> list, int index) {

        String num = String.valueOf(list.get(index));

        char[] digits = num.toCharArray();


        //여기 for 문 필요한거 맞음? 없어도 되는거 같은데??
        for (int i = 0; i < digits.length; i ++)

            if (digits.length == 1) {
                return getNumericValue(digits[0]);
            } else if (digits.length == 2) {
                return getNumericValue(digits[0]) * getNumericValue(digits[1]);
            } else {
                return getNumericValue(digits[0]) * getNumericValue(digits[1]) * getNumericValue(digits[2]);
            }

        return Integer.parseInt(null);
    }
}