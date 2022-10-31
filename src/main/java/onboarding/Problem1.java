package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능목록
 * 1.각자리의 숫자를 구한다.
 * 2.각자리의 숫자의 합을 구한다.
 * 3.각자리의 숫자의 곱을 구한다.
 * 4.비교한다.
 *
 * 5.점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6.시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int getTotalByAdd(List<Integer> eachDigit) {
        int total = 0;
        for (Integer num : eachDigit) {
            total += num;
        }
        return total;
    }

    private int getTotalByMultiply(List<Integer> eachDigit) {
        //곱셈은 1이 기본값.
        int total = 1;
        for (Integer num : eachDigit) {
            total = total * num;
        }
        return total;
    }

    private List<Integer> getEachDigit(int num) {
        List<Integer> eachDigit = new ArrayList<>();
        String stringNum = changeIntegerToString(num);
        for (int i = 0; i < stringNum.length(); i++) {
            //char 형을 int 값으로 가져오는 법.
            //Character.getNumericValue(stringNum.charAt(i));
            int digit = stringNum.charAt(i) - '0';
            eachDigit.add(digit);
        }
        return eachDigit;
    }

    private String changeIntegerToString(int value) {
        return String.valueOf(value);
    }

}